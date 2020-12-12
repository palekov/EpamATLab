package pack1;

public class SamePackage {
    public SamePackage() {
        Protection p = new Protection();
        System.out.println("constructor of the same package");
        System.out.println("n_default = " + p.n_default);
        //System.out.println("n_private = " + p.n_private);    // owner class access only
        System.out.println("n_protected = " + p.n_protected);
        System.out.println("n_public = " + p.n_public);
    }
}
