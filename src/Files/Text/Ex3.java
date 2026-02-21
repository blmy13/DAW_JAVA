package Files.Text;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class Ex3 {
    public static void main(String[] args) {

        String nomProductes[] = {
                "4LIFE TRANSFER FACTOR PLUS 90 TBS",
                "AB SOLUTION PLUS 240ml",
                "ABRASONE RECTAL crema 30 gr.",
                "ABRAXANE 100mg 1vial 50ml",
                "ACID HYALURONIC 20MG 30CAPS",
                "ACID HYALURONIC 60MG 30CAPS TRIPLE STRENGTH",
                "ACIDOPHILUS PLUS 60caps",
                "ACOMPLIA 20mg 28 tabs",
                "ACT eau dentaire fluor classic cinnamon fl 400 ml",
                "ACTOVEGIN 10 ML 5 AMP",
                "ACTOVEGIN FORTE 200 mg 100 dragees",
                "ACTOVEGIN INJ. 5 X 5 ML",
                "ADRENALIN 1:1000 ( 1mg/ ml ) 10x1 ml",
                "AETHOXYSKLEROL 0.25% 5Ampo 2ml",
                "AETHOXYSKLEROL 0.5% 5 Ampo 2ml",
                "AETHOXYSKLEROL 1% 30 ml VIAL",
                "AETHOXYSKLEROL 1% 5x2ml",
                "AETHOXYSKLEROL 2% 5x2ml",
                "AETHOXYSKLEROL 3% 5 Amp 2ml",
                "AETHOXYSKLEROL 4% 5x2ml",
                "AGGRENOX  200/25mg 60 caps",
                "AGIOCUR Granulat 250g",
                "AGIOLAX MITE 1000gr",
                "AHAVA CREMA CORPORAL VAINILLA 300 GR.",
                "AHAVA DERMUD BODY MILK 250 ml.",
                "AHAVA DERMUD CR.HUMECTANT CALMANT 50 ML SPF15",
                "AHAVA DERMUD CREMA COLZES I GENOLLS 75 ml.",
                "AHAVA DERMUD CREMA CORPORAL 200 ML.",
                "AHAVA DERMUD CREMA MANS 125 ML",
                "AHAVA DERMUD CREMA NUTRITIVA 50 ML"};

        int vendesTrim[][] = {
                {290, 316, 877, 924},
                {339, 874, 158, 359},
                {485, 754, 80, 38},
                {490, 358, 628, 330},
                {52, 118, 852, 463},
                {925, 69, 164, 458},
                {234, 680, 342, 758},
                {290, 316, 877, 924},
                {339, 874, 158, 359},
                {485, 754, 80, 38},
                {490, 358, 628, 330},
                {52, 118, 852, 463},
                {925, 69, 164, 458},
                {234, 680, 342, 758},
                {290, 316, 877, 924},
                {339, 874, 158, 359},
                {485, 754, 80, 38},
                {490, 358, 628, 330},
                {52, 118, 852, 463},
                {925, 69, 164, 458},
                {234, 680, 342, 758},
                {290, 316, 877, 924},
                {339, 874, 158, 359},
                {485, 754, 80, 38},
                {490, 358, 628, 330},
                {52, 118, 852, 463},
                {925, 69, 164, 458},
                {234, 680, 342, 758},
                {485, 754, 80, 38},
                {490, 358, 628, 330}};

        try (Formatter f = new Formatter("vendes.txt")) {
            f.format("%-52s %-10s %-10s %-10s %-10s%n",
                    "Producte", "1 Trim", "2 Trim", "3 Trim", "4 Trim");
            f.format("%-52s %-10s %-10s %-10s %-10s%n",
                    "--------", "------", "------", "------", "------");
            for (int i = 0; i < nomProductes.length; i++) {
                f.format("%-52s %-10d %-10d %-10d %-10d%n", nomProductes[i],
                        vendesTrim[i][0],
                        vendesTrim[i][1],
                        vendesTrim[i][2],
                        vendesTrim[i][3]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
