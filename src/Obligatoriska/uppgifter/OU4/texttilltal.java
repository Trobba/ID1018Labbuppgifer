package Obligatoriska.uppgifter.OU4;
import java.util.*; // Scanner
import static java.lang.System.out;

public class texttilltal {
        public static void main (String[] args)
        {
            out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
            // mata in två naturliga heltal
            Scanner in = new Scanner (System.in);
            out.println ("två naturliga heltal:");
            String tal1 = in.next ();
            String tal2 = in.next ();
            out.println ();
            // addera heltalen och visa resultatet
            String summa = addera (tal1, tal2);
            visa (tal1, tal2, summa, '+');

            String differens = subtrahera(tal1,tal2);
            visa(tal1,tal2,differens,'-');
            // subtrahera heltalen och visa resultatet
            // koden här
        }
        // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
        // summa som en teckensträng.
        public static String addera (String tal1, String tal2)
        {
            StringBuilder summa = new StringBuilder();
            int rest = 0;
            int c1;
            int c2;
            int siffra;

            if (tal1.length() > tal2.length())
                tal2 = sattLenNum(tal2, tal1.length()-tal2.length());
            else if (tal1.length() < tal2.length())
                tal1 = sattLenNum(tal1,tal2.length() - tal1.length());

            for (int i = tal1.length()-1; i >= 0; i--){
                c1 = Character.getNumericValue(tal1.charAt(i));
                c2 = Character.getNumericValue(tal2.charAt(i));
                siffra = c1 + c2+ rest;
                rest = siffra / 10;
                siffra = siffra % 10;
                summa.append(siffra);
            }

            if (rest != 0)
                summa.append(rest);
            summa.reverse();
            return summa.toString();
        }
        // Subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
        // deras differens som en teckensträng.
        // Det första heltalet är inte mindre än det andra heltalet.
        public static String subtrahera (String tal1, String tal2)
        {
            StringBuilder differens = new StringBuilder();
            int rest = 0;
            int c1;
            int c2;
            int siffra;

            if (tal1.length() > tal2.length())
                tal2 = sattLenNum(tal2, tal1.length()-tal2.length());
            else if (tal1.length() < tal2.length())
                tal1 = sattLenNum(tal1, tal2.length()-tal1.length());


            for (int i = tal1.length()-1; i >= 0; i--){
                c1 = Character.getNumericValue(tal1.charAt(i)) - rest;
                c2 = Character.getNumericValue(tal2.charAt(i));
                siffra = c1 - c2;
                if (siffra < 0){
                    rest = 1;
                    siffra += 10;
                }
                if (i == 0 && c1 < 0 && c2 != 0){
                    c2 = (c2 + 1) * (int)(Math.pow(10,tal1.length()-1));
                    differens.reverse();
                    siffra = c2 - Integer.parseInt(differens.toString());
                    return "-" + siffra;
                }
                differens.append(siffra);
            }
            differens.reverse();
            return differens.toString();
        }
        // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
        // utförd i samband med hetalen
        public static void visa (String tal1, String tal2, String resultat, char operator)
        {
            // sätt en lämplig längd på heltalen och resultatet
            int len1 = tal1.length ();
            int len2 = tal2.length ();
            int len = resultat.length ();
            int maxLen = Math.max (Math.max (len1, len2), len);
            tal1 = sattLen (tal1, maxLen - len1);
            tal2 = sattLen (tal2, maxLen - len2);
            resultat = sattLen (resultat, maxLen - len);
            // visa heltalen och resultatet
            out.println ("  " + tal1);
            out.println ("" + operator + " " + tal2);
            for (int i = 0; i < maxLen + 2; i++)
                out.print ("-");
            out.println ();
            out.println ("  " + resultat + "\n");
        }
        // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
        public static String sattLen (String s, int antal)
        {
            StringBuilder sb = new StringBuilder (s);
            for (int i = 0; i < antal; i++)
                sb.insert (0, " ");
            return sb.toString ();
        }
        public static String sattLenNum (String s, int antal)
        {
            StringBuilder sb = new StringBuilder (s);
            for (int i = 0; i < antal; i++)
                sb.insert (0, "0");
            return sb.toString ();
        }
}
