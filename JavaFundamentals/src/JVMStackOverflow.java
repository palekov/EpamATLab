public class JVMStackOverflow {

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);
        if (num == 0)
            return;
        else
            recursivePrint(++num);
    }

    public static void main(String[] args) {
        JVMStackOverflow.recursivePrint(1);
    }
}

