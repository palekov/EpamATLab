
public class JavaProgrammingObjectClass {

    public static class BlackBox {
        int varA;
        int varB;

        BlackBox(int varA, int varB){
            this.varA = varA;
            this.varB = varB;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + varA;
            result = prime * result + varB;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            BlackBox other = (BlackBox) obj;
            if (varA != other.varA)
                return false;
            if (varB != other.varB)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "BlackBox{" +
                    "varA=" + varA +
                    ", varB=" + varB +
                    '}';
        }
    }

    public static void main(String[] args) {
        Class<?> classObj;

        BlackBox object1 = new BlackBox(5, 10);
        BlackBox object2 = new BlackBox(5, 10);
        BlackBox object3 = new BlackBox(7, 15);
        BlackBox object4 = null;

        System.out.println(object1.equals(object2));
        System.out.println(object1.hashCode() == object2.hashCode());
        System.out.println(object1.equals(object3));
        System.out.println(object1.hashCode() == object3.hashCode());

        System.out.println(object1.getClass());
        System.out.println(object2.getClass());
        System.out.println(object3.getClass());

        System.out.println(object1);
        System.out.println(object2);
        System.out.println(object3);

        classObj = object1.getClass();
        System.out.println(classObj.getName());
        System.out.println(classObj.getPackage());

        System.out.println(object4.toString());
    }
}
