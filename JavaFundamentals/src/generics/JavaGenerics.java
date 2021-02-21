package generics;

import java.util.*;

public class JavaGenerics {

    public static class Box<T> {
        private T t;
        public void set(T t) {
            this.t = t;
        }
        public T get() {
            return t;
        }

        @Override
        public String toString() {
            return "Box{" + "t=" + t + '}';
        }
    }

    public static <T> void fill(List<T> list, T val) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, val);
    }

    public static class SomeType<T> {
        public <E> void test(Collection<E> collection) {
            for (E element : collection) {
                System.out.println(element);
            }
        }

        public void test(List<Integer> collection) {
            for (Integer element : collection) {
                System.out.println(element);
            }
        }
    }

    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void printObjects(List<Object> object) {
        for (Object elem: object)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static <T extends Number> double sumOfListT(List<T> list) {
        double s = 0.0;
        for (T n : list)
            s += n.doubleValue();
        return s;
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }



    public static void main(String[] args) {

        //  create an object of parameterized type List<Integer>, add Integer to it and get Integer from it
        SomeType<Integer> st = new SomeType<>();
        List<Integer> list = new ArrayList<>();
        list.add(235);
        list.add(386);
        list.add(118);
        st.test(list);

        //  create an object of raw type List, add Integer to it and get Integer from it
        List rawlist = new ArrayList();
        rawlist.add(100);
        rawlist.add(200);
        System.out.println((Integer) rawlist.get(0) + (Integer) rawlist.get(1));    //  outputs '300'

        //  create an object of generic type ArrayList<T> with actual
        //  type parameter Integer without and with the diamond operator
        List<Integer> genlist1 = new ArrayList();
        List<Integer> genlist2 = new ArrayList<Integer>();

        //  use the generic method Collections.emptyList without and with type inference
        List immutableList1 = Collections.emptyList();
        List<String> immutableList2 = Collections.emptyList();

        //  implement a generic class (with or without generic constructors and methods) and create an object from it
        Box<String> stringBox = new Box<>();
        stringBox.set("Старая строка");
        System.out.println(stringBox.get());
        stringBox.set("Новая строка");
        System.out.println(stringBox.get());

        //  implement a generic method in the non-generic class and create an object from it
        List<String> strings = new ArrayList<>();
        strings.add("Старая строка 1");
        strings.add("Старая строка 2");
        strings.add("Старая строка 3");
        fill(strings, "Новая строка");
        System.out.println(strings);

        //  assign object of type ArrayList<Integer> to reference of type List<Integer>
        List<Integer> genlist3 = new ArrayList<Integer>();

        //  assign object of type ArrayList<Integer> to reference of type Collection<Integer>
        Collection<Integer> genlist4 = new ArrayList<Integer>();

        //  assign objects of types ArrayList<Integer>, ArrayList<Double>, ArrayList<String>
        //  to reference of unbounded wildcard type List<?>

        List<?> listInteger;
        List<?> listDouble;
        List<?> listString;

        listInteger = new ArrayList<Integer>();
        listDouble = new ArrayList<Double>();
        listString = new ArrayList<String>();

        //  assign objects of types ArrayList<Integer>, ArrayList<Double> to reference
        //  of upper bounded wildcard type List<? extends Number>

        List<? extends Number> liext1;
        List<? extends Number> liext2;

        liext1 = new ArrayList<Integer>();
        liext2 = new ArrayList<Double>();

        //  assign objects of types ArrayList<Integer>, ArrayList<Number>, ArrayList<Object> to reference
        //  of lower bounded wildcard type List<? super Integer>

        List<? super Integer> lisup1 = new ArrayList<Integer>();
        List<? super Integer> lisup2 = new ArrayList<Number>();
        List<? super Integer> lisup3  = new ArrayList<Object>();

        //  implement a generic method with a method parameter of parameterized type List<Object>,
        //  that uses the method System.out.println to print list elements; call the method with an
        //  argument of parameterized type List<Object>

        List<Object> objlist = new ArrayList<>();
        Box<String> stringBox1 = new Box<>();
        Box<String> stringBox2 = new Box<>();
        Box<String> stringBox3 = new Box<>();

        stringBox1.set("BoxObject1");
        stringBox2.set("BoxObject2");
        stringBox3.set("BoxObject3");

        objlist.add(stringBox1);
        objlist.add(stringBox2);
        objlist.add(stringBox3);
        printObjects(objlist);
        System.out.println();

        //  implement a generic method with a method parameter of unbounded wildcard type List<?>,
        //  that uses the method System.out.println to print list elements; call the method
        //  with arguments of parameterized types List<Object>, List<Integer>, List<Double>

        List<Integer> intList = new ArrayList<>();
        intList.add(235);
        intList.add(386);
        intList.add(118);

        List<Double> douList = new ArrayList<>();
        douList.add(1.4);
        douList.add(2.6);
        douList.add(4.7);

        printList(objlist);
        printList(intList);
        printList(douList);
        System.out.println();

        //  implement a generic method with bounded type parameter <T extends Number>, with a method parameter
        //  of generic type parameter List<T>, that uses the method Number.longValue to find the sum of the list
        //  elements to an accumulator of type long; call the method with arguments of parameterized
        //  types List<Integer>, List<Long>

        List<Long> lonList = new ArrayList<>();

        lonList.add(147_500_000L);
        lonList.add(262_500_000L);
        lonList.add(478_500_000L);

        System.out.println(sumOfListT(intList));
        System.out.println(sumOfList(lonList));
        System.out.println();

        //  implement a generic method with a method parameter of upper bounded wildcard type List<? extends Number>,
        //  that uses the method Number.longValue to find the sum of the list elements to an accumulator of type long;
        //  call the method with arguments of parameterized types List<Integer>, List<Long> (PEcs: producer - extends)

        System.out.println(sumOfList(intList));
        System.out.println(sumOfList(lonList));
        System.out.println();

        //  implement a generic method with a method parameter of lower bounded wildcard type List<? super Integer>,
        //  that uses the method List.add to insert int elements to list; call the method with arguments of parameterized
        //  types List<Integer>, List<Number>, List<Object> (peCS: consumer - super)

        List<Number> numList = new ArrayList<>();

        addNumbers(intList);
        addNumbers(numList);
        addNumbers(objlist);

        //  show that impossible to use the instanceof operator with parameterized types (screenshot)
        List<?> foo;
        foo = new ArrayList<String>();
        //boolean boo = foo instanceof ArrayList<String>;

    }

    //  show that impossible to overload a method where the formal parameter types of each overload
    //  erase to the same raw type (screenshot)

    //public void print(Set<String> strSet) { }
    //public void print(Set<Integer> intSet) { }

}
