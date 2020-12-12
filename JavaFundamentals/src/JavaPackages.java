import pack1.*;
import pack2.*;

public class JavaPackages {                      // main demo class for packages access
    public static void main(String[] args) {
        Protection ob1 = new Protection();       // from pack1
        Derived ob2 = new Derived();             // from pack1
        SamePackage ob3 = new SamePackage();     // from pack1
        Protection2 ob4 = new Protection2();     // from pack2
        OtherPackage ob5 = new OtherPackage();   // from pack2
    }
}
