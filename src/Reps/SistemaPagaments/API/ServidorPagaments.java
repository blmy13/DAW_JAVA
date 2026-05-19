package Reps.SistemaPagaments.API;

import Reps.SistemaPagaments.DAO.TransaccioDAO;
import Reps.SistemaPagaments.Entitats.EstrategiaPagament;
import Reps.SistemaPagaments.Entitats.PagamentPaypal;
import Reps.SistemaPagaments.Entitats.ProcessadorPagaments;
import Reps.SistemaPagaments.Entitats.Transaccio;
import Reps.SistemaPagaments.Persistencia.TransaccioDAOMySQL;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class ServidorPagaments {
    public static void main(String[] args) throws IOException {
        // crear servidor
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8080), 0);

        // 2. Definir configuració base del processador
        EstrategiaPagament estrategiaDefecte = new PagamentPaypal("api@gmail.com");
        TransaccioDAO daoReal = new TransaccioDAOMySQL();
        ProcessadorPagaments processador = new ProcessadorPagaments(estrategiaDefecte, daoReal);

        // nou endpoint (POST + JSON)
        servidor.createContext("/api/pagar", new HttpHandler() {
            @Override
            public void handle(HttpExchange peticio) throws IOException {
                // 1. bloquejar qualsevol mètode que no sigui POST
                if (!"POST".equalsIgnoreCase(peticio.getRequestMethod())) {
                    String error = "{\"error\": \"Mètode no vàlid. Fes servir POST.\"}";
                    enviarJSON(peticio, 405, error); // 405 = Method Not Allowed
                    return;
                }

                try {
                    // 2. llegir peticio i convertir a text
                    String body = new String(peticio.getRequestBody().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);

                    // llegir import, amb maven és més fàcil
                    String[] parts = body.split(":");
                    // neteja text, manté números, punts o signe negatiu
                    String numeroNet = parts[1].replaceAll("[^0-9.\\-]", "");
                    double quantitat = Double.parseDouble(numeroNet);

                    // 3. logica negoci
                    Transaccio t = new Transaccio(quantitat, estrategiaDefecte);
                    processador.executarCompra(t);

                    // 4. JSON de resposta correcta
                    String jsonResposta = "{\n" +
                            "  \"estat\": \"EXIT\",\n" +
                            "  \"missatge\": \"Pagament processat correctament\",\n" +
                            "  \"import_cobrat\": " + quantitat + "\n" +
                            "}";
                    enviarJSON(peticio, 200, jsonResposta);

                } catch (Exception e) {
                    // 5. JSON error(Codi 400)
                    String jsonError = "{\n" +
                            "  \"estat\": \"ERROR\",\n" +
                            "  \"missatge\": \"" + e.getMessage() + "\"\n" +
                            "}";
                    enviarJSON(peticio, 400, jsonError);
                }
            }

            private void enviarJSON(HttpExchange peticio, int codiHttp, String json) throws IOException {
                peticio.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                byte[] bytesResposta = json.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                peticio.sendResponseHeaders(codiHttp, bytesResposta.length);
                OutputStream sortida = peticio.getResponseBody();
                sortida.write(bytesResposta);
                sortida.close();
            }
        });

        // endpoint per llegir historial
        servidor.createContext("/api/historial", new HttpHandler() {
            @Override
            public void handle(HttpExchange peticio) throws IOException {
                // 1. Bloquejar qualsevol mètode que no sigui GET
                if (!"GET".equalsIgnoreCase(peticio.getRequestMethod())) {
                    String error = "{\"error\": \"Mètode no vàlid. Fes servir GET.\"}";
                    enviarJSON(peticio, 405, error);
                    return;
                }

                try {
                    // 2. recuperar llista de la base de dades
                    List<Transaccio> historial = daoReal.obtenirTransaccions();

                    // 3. Construir JSON
                    StringBuilder jsonBuilder = new StringBuilder();
                    jsonBuilder.append("[\n");
                    for (int i = 0; i < historial.size(); i++) {
                        Transaccio t = historial.get(i);
                        jsonBuilder.append("  {\n");
                        jsonBuilder.append("    \"import\": ").append(t.getImportTransaccio()).append("\n");
                        jsonBuilder.append("  }");
                        if (i < historial.size() - 1) {
                            jsonBuilder.append(",");
                        }
                        jsonBuilder.append("\n");
                    }
                    jsonBuilder.append("]");

                    // 4. tornar dades al client
                    enviarJSON(peticio, 200, jsonBuilder.toString());

                } catch (Exception e) {
                    String jsonError = "{\n" +
                            "  \"estat\": \"ERROR\",\n" +
                            "  \"missatge\": \"" + e.getMessage() + "\"\n" +
                            "}";
                    enviarJSON(peticio, 500, jsonError); // 500 = Internal Server Error
                }
            }

            private void enviarJSON(HttpExchange peticio, int codiHttp, String json) throws IOException {
                peticio.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                byte[] bytesResposta = json.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                peticio.sendResponseHeaders(codiHttp, bytesResposta.length);
                OutputStream sortida = peticio.getResponseBody();
                sortida.write(bytesResposta);
                sortida.close();
            }
        });

        // 3. inicialitzar servidor
        servidor.setExecutor(null); // Utilitza la configuració per defecte
        servidor.start();

        System.out.println(">> Servidor inicialitzat amb èxit.");
        System.out.println(">> L'API pagar respon a: http://localhost:8080/api/pagar (Només accepta POST)");
        System.out.println(">> L'API historial respon a: http://localhost:8080/api/historial (Només accepta GET)");
    }
}