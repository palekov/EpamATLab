public class JavaInheritanceCovariant {

    //  show covariant return type in an overridden method
    class Parent {

        public Parent methodName() {
            return new Parent();
        }
    }

    class Child extends Parent
    {
        @Override
        public Parent methodName()
        {
           return new Child();              //  covariant return
        }
    }
}
