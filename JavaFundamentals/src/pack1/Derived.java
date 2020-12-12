package pack1;

public class Derived extends Protection {        //  subclass for access demonstration
        public Derived() {
            System.out.println("subclass constructor from pack1 subclass");
            System.out.println("n_default = " + n_default);
            // System.out.println("n_private = " + n_private);   // access for owner class only
            System.out.println("n_protected = " + n_protected);
            System.out.println("n_public = " + n_public);
    }
}
