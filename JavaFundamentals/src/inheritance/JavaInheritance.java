package inheritance;

public class JavaInheritance {

    static class Crisps extends JavaInheritanceSuper {
        private int quantity;

        //  show an explicit call from subclass constructor to a superclass constructor
        Crisps(String flavour, int quantity) {
            super(flavour);                             // send flavour to the super class constructor
            this.quantity = quantity;
        }

        Crisps() {
            System.out.println("this is a subclass constructor!");
        }

        //  show that a static method in subclass hides static method in a superclass
        public static void StaticMethodSuper() {
            System.out.println("static method from subclass!");
        }

        //  show that an instance method in a subclass overrides instance method in a superclass
        public void InstanceMethodSuper() {
            System.out.println("instance method from subclass!");
        }

        //  show that an overridden method can’t have weaker access (screenshot)
//        private void InstanceMethodSuper() {
//            System.out.println("instance method from subclass!");
//        }


        //  show that an overridden method can’t throw broader checked exceptions (screenshot)
//        public void ExceptionMethodSuper(String file) throws IOException {
//        }

        //  use the super keyword with field, method, constructor
        int num = 110;
        public void printNum () {
            super.printNum();                //  outputs '880'
            System.out.println(super.num);   //  outputs '220'
            System.out.println(this.num);    //  outputs '110'
        }
    }

    static class Animal {
    }

    static class Dog extends Animal {
    }

    static class Cat extends Animal {
    }

    public static void main(String[] args) {
        //  show an implicit call from subclass constructor to a superclass constructor
        Crisps cris = new Crisps();  //  outputs this is a superclass constructor!
                                     //  outputs this is a subclass constructor!
        cris.printNum();

        Dog dog = new Dog();
        Animal anim = (Animal) dog;  //  using upcasting

        Animal anima = new Cat();    //  using downcasting
        if (anima instanceof Cat) {
            Cat cat = (Cat) anima;
        }

       //   use composition (has-a) as an alternative to inheritance and (is-a)

       JavaInheritanceComposition.Bee a = new JavaInheritanceComposition.Bee(1, "black"
               , new JavaInheritanceComposition.AttackImpl("fly", "move"));
        a.attack();     //  outputs 'fly  move'

        // if you need another implementation of move()
        // there is no need to change Insect, we can quickly use new method to attack
        JavaInheritanceComposition.Bee b = new JavaInheritanceComposition.Bee(1, "black"
                , new JavaInheritanceComposition.AttackImpl("fly", "bite"));
        b.attack();     //  outputs 'fly bite'


    }
}
