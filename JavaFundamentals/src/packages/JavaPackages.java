package packages;

import packages.pack1.*;
import packages.pack2.*;

public class JavaPackages {                      // main demo class for packages access
    public static void main(String[] args) {
        Protection ob1 = new Protection();       // from packages.pack1
        Derived ob2 = new Derived();             // from packages.pack1
        SamePackage ob3 = new SamePackage();     // from packages.pack1
        Protection2 ob4 = new Protection2();     // from packages.pack2
        OtherPackage ob5 = new OtherPackage();   // from packages.pack2
    }
}
