package Obligatoriska.uppgifter.OU1;
import java.util.*;

public class OU1 {
    public static void main(String[] args) {
        System.out.println ("TEMPERATURER\n");
        // inmatningsverktyg
        Scanner    in = new Scanner (System.in);
        in.useLocale (Locale.US);
        // mata in uppgifter om antalet veckor och antaletmätningar
        System.out.print ("antalet veckor: ");
        int    antalVeckor = in.nextInt ();
        System.out.print ("antalet mätningar per vecka: ");
        int    antalMatningarPerVecka = in.nextInt ();
        // plats att lagra temperaturer
        double[][]    t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++){
            System.out.println ("temperaturer -vecka " + vecka+ ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble ();
        }
        System.out.println ();
        // visa temperaturerna
        System.out.println ("temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++){
            for (int matning = 1;matning <= antalMatningarPerVecka; matning++)
                System.out.print (t[vecka][matning] + " ");
            System.out.println ();
        }
        System.out.println ();
        double[]    minT = new double[antalVeckor + 1];
        double[]    maxT = new double[antalVeckor + 1];
        double[]    sumT = new double[antalVeckor + 1];
        double[]    medelT = new double[antalVeckor + 1];
        // koden ska skrivas här
        for (int vecka = 1; vecka <= antalVeckor; vecka++) {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
                if (matning == 1){
                    maxT[vecka] = -Double.MAX_VALUE;
                    minT[vecka] = Double.MAX_VALUE;
                }
                if (maxT[vecka] <= t[vecka][matning])
                    maxT[vecka] = t[vecka][matning];
                if (minT[vecka] >= t[vecka][matning])
                    minT[vecka] = t[vecka][matning];
                sumT[vecka] = sumT[vecka] + t[vecka][matning];
            }
            medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;
            System.out.println("Vecka " + vecka + ": | MAX: " + maxT[vecka] + " | MIN: " + minT[vecka] + " | MEDEL: " + medelT[vecka]);
        }

        double    minTemp = minT[1];
        double    maxTemp = maxT[1];
        double    sumTemp = 0; // Ändrad då den annars räknar sumT[1] 2 gånger
        double    medelTemp;
        // koden ska skrivas här
        for (int vecka = 1; vecka <= antalVeckor; vecka++) {
            if (maxTemp <= maxT[vecka])
                maxTemp = maxT[vecka];
            if (minTemp >= minT[vecka])
                minTemp = minT[vecka];
            sumTemp += sumT[vecka];
        }
        medelTemp = sumTemp / (antalMatningarPerVecka * antalVeckor);
        System.out.println("Total: | MAX: " + maxTemp + " | MIN: " + minTemp + " | MEDEL: " + medelTemp);
    }
}
