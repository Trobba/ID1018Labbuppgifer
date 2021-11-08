package Obligatoriska.uppgifter.OU2;

/*
    This program gives the different values of a triangle
 */

public class Triangel {
    public static double semiperimetern(double a, double b, double c){
        return ((a+b+c)/2);
    }
    public static double getArea(double a, double b, double c){
        return Math.sqrt(semiperimetern(a,b,c) * (semiperimetern(a,b,c)-a) *
                (semiperimetern(a,b,c)-b) * (semiperimetern(a,b,c)-c));
    }
    public static double getCircumference(double a, double b, double c){
        return a+b+c;
    }
    //  Bisektris tar emot två sidor i en triangel och vinkeln(i radianer) mellan dessa sidor.
    // Metoden returnerar längden av den motsvarande bisektrisen -den som delar den givnavinkeln
    // i två lika delar.
    public static double getBisektris (double b, double c, double alfa) {
        double p = 2 * b * c * Math.cos (alfa / 2);
        return p / (b + c);
    }
    public static double getInsideCircleR(double a, double b, double c){
        return Math.sqrt((semiperimetern(a,b,c) - a) * (semiperimetern(a,b,c) - b) *
                (semiperimetern(a,b,c) - c) / semiperimetern(a,b,c));
    }
    public static double getOutsideCircleR(double a, double b, double c){
        return (a*b*c)/ (4 * Math.sqrt(semiperimetern(a,b,c) * (semiperimetern(a,b,c) - a) *
                (semiperimetern(a,b,c) - b) * (semiperimetern(a,b,c) - c)));
    }
    public static double getMedianA(double a, double b, double c){
        return (Math.sqrt(2*Math.pow(b,2) + 2*Math.pow(c,2) - Math.pow(a,2)))/2;
    }
    public static double getMedianB(double a, double b, double c){
        return (Math.sqrt(2*Math.pow(a,2) + 2*Math.pow(c,2) - Math.pow(b,2)))/2;
    }
    public static double getMedianC(double a, double b, double c){
        return (Math.sqrt(2*Math.pow(a,2) + 2*Math.pow(b,2) - Math.pow(c,2)))/2;
    }
}
