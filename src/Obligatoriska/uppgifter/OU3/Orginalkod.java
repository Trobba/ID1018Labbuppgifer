package Obligatoriska.uppgifter.OU3;

public class Orginalkod {
    public static void main(String[] args) {
        int[] iList = new int[6];
        iList[0] = 2;
        iList[1] = -5;
        iList[2] = 1;
        iList[3] = 5;
        iList[4] = 8;
        iList[5] = 4;
        int minimumInt = min(iList);
        System.out.println(minimumInt);
    }
    public static int min (int[] element) throws IllegalArgumentException {
        if (element.length == 0)throw new IllegalArgumentException ("tom samling");
        // hör ihop med spårutskriften 2:
        // int    antalVarv = 1;
        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar +antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];
        int i = 0;
        int j = 0;
        while (sekvens.length > 1) {
            // skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;
            while (j < antaletPar) {
                // Tar minsta värdet av sekvens [i] och sekvens[i+1]
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
                i += 2;
            }
            if (antaletOparadeElement == 1)
                delsekvens[j] = sekvens[sekvens.length - 1];

            // utgå nu ifrån delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;

            // spårutskrift 1 –för att följasekvensen
            // System.out.println (java.util.Arrays.toString (sekvens));
            // spårutskrift 2 -för att avsluta loopen i förväg// (för att kunna se vad som händer i början)
            //if (antalVarv++ == 10)
            //    System.exit (0);
            }
            // sekvens[0] är det enda återstående tänkbara elementet
            // -det är det minsta elementet
        return sekvens[0];
    }
}
