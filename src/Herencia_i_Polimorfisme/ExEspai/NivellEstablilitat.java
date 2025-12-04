package Herencia_i_Polimorfisme.ExEspai;

public interface NivellEstablilitat {

    String EXCEL_LENT = "Excel·lent";
    String TENSIONAT  = "Tensionat";
    String ACCEPTABLE = "Acceptable";

    class Candidat {

        private final String id;
        private final String cognom;
        private final String getCognom;

        public Candidat(String id, String cognom, String getCognom) {
            this.id = id;
            this.cognom = cognom;
            this.getCognom = getCognom;
        }

        public String getId() {
            return id;
        }

        public String getCognom() {
            return cognom;
        }

        public String getGetCognom() {
            return getCognom;
        }
    }
}
