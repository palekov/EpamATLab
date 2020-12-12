package pack1;

public class Protection {              // class for access type demonstration
    int n_default =1;
    private int n_private =2;
    protected int n_protected = 3;
    public int n_public = 4;

    public Protection() {
        System.out.println("base class constructor");
        System.out.println("n_default = " + n_default);
        System.out.println("n_private = " + n_private);
        System.out.println("n_protected = " + n_protected);
        System.out.println("n_public = " + n_public);
    }
}
