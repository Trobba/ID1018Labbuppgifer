package Obligatoriska.uppgifter.OU2;

import java.util.Scanner;

public class EnTriangelOchDessCirklar {
    public static void main(String[] args) {
        // Hämtar användarens data
        double[] triangleSides = new double[3];
        Scanner in = new Scanner (System.in);
        for (int antalSidor = 0; antalSidor < 3; antalSidor++){
            System.out.print ("Hur lång är sidan? Sidorna är a,b,c\n");
            triangleSides[antalSidor] = in.nextDouble();
        }
        // Skriver ut de olika cirklarnas radier
        System.out.println("Cirkeln utanför triangelns radie: " +
                Triangel.getOutsideCircleR(triangleSides[0],triangleSides[1], triangleSides[2])
                + " | Cirkeln innanför triangelns radie: "+
                Triangel.getInsideCircleR(triangleSides[0],triangleSides[1], triangleSides[2]));
    }
}
