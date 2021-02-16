package packages.pack2;

public class Protection2 extends packages.pack1.Protection {
    public Protection2() {
        System.out.println("constructor from packages.pack2 subclass");
        // System.out.println("n_default = " + n_default);  // no access for this package
        // System.out.println("n_private = " + n_private);  // no access for this class
        System.out.println("n_protected = " + n_protected);
        System.out.println("n_public = " + n_public);
    }
}
