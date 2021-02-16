package programming;

public class JavaProgrammingLanguage {
    public static void main(String[] args) {
        System.out.println( System.getProperty("java.version") );
        System.out.println( System.getenv("JAVA_HOME") );
        for (int i = 0; i < args.length; i++)
            System.out.println(args[i]);
        System.out.println( System.getProperty("mentee") );
        System.exit(-1);
    }
}
