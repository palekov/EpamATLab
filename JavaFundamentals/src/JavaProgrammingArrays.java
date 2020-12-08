
import java.util.Arrays;

public class JavaProgrammingArrays {
    public static void main(String[] args) {
        int[] array = new int[15];
        String[] stringArray = new String[10];

        String[] array1 = new String[] { "a", "b", "c" };
        String[] array2 = new String[] { "a", "b", "c" };

        stringArray[0] = "Vasya";
        stringArray[4] = "Petya";
        stringArray[8] = "Fedya";

        String str = Arrays.toString(array);
        int hash = Arrays.hashCode(array);

        System.out.println(str);
        System.out.println(hash);

        for(int i = 0; i < stringArray.length; i++)
            System.out.println(stringArray[i]);
        for(int i = 0; i < 5; i++) {
            array[i] =i;
            System.out.println(array[i]);
        }

        System.out.println();
        System.out.println(array1.equals(array2));
        System.out.println(Arrays.equals(array1, array2));

        System.out.println(array[15]);
    }
}
