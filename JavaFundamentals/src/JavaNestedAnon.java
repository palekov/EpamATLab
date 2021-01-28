public class JavaNestedAnon {

    //   write an anonymous class and initialize it with instance initialization block
    //   show that an anonymous class has access to static and instance fields/methods of the enclosing context
    //   show that an anonymous class can have only instance fields/methods
    //   show that an anonymous class has access to final local variables
    //   show that an anonymous class has access to effectively final local variables (Java 8+)

    public interface MonitoringSystem {
        public void startMonitoring();
    }

    static int currentErrorsCount = 23;

    public static void main(String[] args) {

        final int fin = 999;
        char sim = 'X';
        sim = 'Y';
        char sam = 'A';

        new MonitoringSystem() {
            int num = 10;
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг отслеживания ошибок стартовал!");
                System.out.println(fin);
                System.out.println(sam);

                // System.out.println(sim);
                //  error: Variable 'sim' is accessed from within inner class, needs to be final or effectively final
            }

            public int getCurrentErrorsCount() {
                return currentErrorsCount;
            }
        };
    }
}

