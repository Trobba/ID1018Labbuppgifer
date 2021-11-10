package Obligatoriska.uppgifter.EU1;

public class nyKod {
    public static void main(String[] args) {
        System.out.println(min(new int[]{1, 2, 3, 4,23,6,8,1,7,3,8,-4}));
    }

    public static int min (int[] element) throws IllegalArgumentException {
        if (element.length == 0)throw new IllegalArgumentException ("tom samling");
        // Returnderar det mista värdet i en given array av ints
        int smallestNum = element[0];
        for (int i = 1; element.length > i; i++){
            if (element[i] < smallestNum)
                smallestNum = element[i];
        }
        return smallestNum;
    }
}
