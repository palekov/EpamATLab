package pack2;

public class OtherPackage {
    public OtherPackage() {
        pack1.Protection p = new pack1.Protection();
        System.out.println("constructor from pack2");
        // System.out.println("n_default = " + p.n_default);      // no access for this package
        // System.out.println("n_private = " + p.n_private);      // no access for this class
        // System.out.println("n_protected = " + p.n_protected);  // no access for this class
        System.out.println("n_public = " + p.n_public);
    }
}
