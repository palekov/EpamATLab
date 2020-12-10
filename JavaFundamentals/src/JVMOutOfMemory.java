
import java.util.LinkedList;
import java.util.List;

public class JVMOutOfMemory {
    static final List<Object[]> arrays = new LinkedList<>();

    public static void main(String[] args) {
        {
            System.out.println("totalMemory = " + Runtime.getRuntime().totalMemory());
            System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory());
            System.out.println("maxMemory = " + Runtime.getRuntime().maxMemory());
            for ( ; ; ) {
                arrays.add(new Object[100]);         //   создаем  OutOfMemoryError
            }
        }
    }
}