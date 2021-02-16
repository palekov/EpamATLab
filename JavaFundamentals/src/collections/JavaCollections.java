package collections;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class JavaCollections {
    public static void main(String[] args) {

        //  convert array to String with toString and with Arrays.toString
        String[] strArray = {"one", "two", "three"};
        String joinedString = Arrays.toString(strArray);
        System.out.println(joinedString);                   //  outputs '[one, two, three]'

        //  use Collection methods on ArrayList object
        ArrayList<String> arrlist = new ArrayList<>();
        arrlist.add("Hello");
        arrlist.add(0, "Amigo");
        ArrayList<String> secondList = new ArrayList<>();
        secondList.addAll(arrlist);
        System.out.println("Первое добавление: " + secondList);     //  outputs 'Первое добавление: [Amigo, Hello]'
        secondList.addAll(1, arrlist);
        System.out.println("Второе добавление в середину: " + secondList);
                                                // outputs 'Второе добавление в середину: [Amigo, Amigo, Hello, Hello]'
        ArrayList<String> copyOfSecondList = (ArrayList<String>) secondList.clone();
        secondList.clear();
        System.out.println(copyOfSecondList);   //  outputs '[Amigo, Amigo, Hello, Hello]'
        System.out.println(copyOfSecondList.contains("Hello"));     //  outputs 'true'
        System.out.println(copyOfSecondList.contains("Check"));     //  outputs 'false'

        //  implement Iterator and Iterable
        Iterator iterator = arrlist.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //  create List from an array with Arrays.asList
        List<String> wordsList = Arrays.asList("I ", "love ", "learning");
        System.out.print(wordsList);    //  outputs '[I , love , learning]'

        //  create ArrayList by different constructors
        ArrayList<String> list = new ArrayList<>();

        ArrayList<String> list2 = new ArrayList<>(list);
        ArrayList<String> list3 = new ArrayList<>(10000);

        //  try to add null into ArrayList (JUnit)
        list.add("Hello");
        list.add(null);
        System.out.println(list);   // outputs '[Hello, null]'

        //  create LinkedList by different constructors
        LinkedList<Integer> li_list = new LinkedList<>();
        LinkedList<Integer> li_list2 = new LinkedList<>(li_list);

        //  show that LinkedList implements List, Queue, Deque
        //public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable

        //  use Collections methods: emptyList, singletonList, unmodifiableList
        List<String> emlist = Collections.emptyList();
        System.out.println(emlist);     //  outputs '[]'

        String initList[] = {"One", "Two", "Four", "One"};
        List sinlist = new ArrayList(Arrays.asList(initList));
        System.out.println("List value before: " + sinlist);    //  outputs 'List value before: [One, Two, Four, One]'
        // create singleton list
        sinlist = Collections.singletonList("OnlyOneElement");
        list.add("five");
        System.out.println("List value after: " + sinlist);     //  outputs 'List value after: [OnlyOneElement]'

        try {
            List<Character> unlist = new ArrayList<Character>();
            unlist.add('X');
            unlist.add('Y');
            System.out.println("Initial list: " + unlist);
            List<Character> immutablelist = Collections.unmodifiableList(unlist);
            System.out.println("\nTrying to modify" + " the unmodifiablelist");
            immutablelist.add('Z');
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception thrown : " + e);
            //  outputs 'Exception thrown : java.lang.UnsupportedOperationException'
        }

        //  create HashSet by different constructors
        HashSet h = new HashSet();
        HashSet h1 = new HashSet(1000);
        HashSet h2 = new HashSet(1500, 0.78f);
        HashSet h3 = new HashSet(h);

        //  try to add null to HashSet (JUnit)
        h.add(null);

        //  create LinkedHashSet by different constructors
        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

        //  show that LinkedHashSet iterates elements in insertion order
        Set<Integer> linkedHashSet = new LinkedHashSet<>(Set.of(1, 5, 0, 8, 6, 2, 3));
        linkedHashSet.forEach(e -> System.out.printf("%d ", e));   //   outputs '5 3 2 1 0 8 6'
        System.out.println();

        Iterator<Integer> iter = linkedHashSet.iterator();
        while (iter.hasNext()) {
            System.out.printf("%d ", iter.next());    //   outputs '5 3 2 1 0 8 6'
        }
        System.out.println();

        //  create TreeSet by different constructors
        TreeSet t1 = new TreeSet ();
        TreeSet t2 = new TreeSet (arrlist);

        SortedSet sortedSet = new TreeSet();
        Comparator comparator = sortedSet.comparator();
        TreeSet t3 = new TreeSet (comparator);

        TreeSet t4 = new TreeSet (sortedSet) ;

        //  try to add an object that not implements Comparable into TreeSet (JUnit)
        TreeSet<StringBuffer> ts = new TreeSet<StringBuffer>();
        //ts.add(new StringBuffer("A"));   //  NullPointerException

        //  show that TreeSet iterates elements in sorted order
        TreeSet<String> states = new TreeSet<String>();
        states.add("Germany");
        states.add("France");
        states.add("Belgium");
        states.add("Italy");
        states.add("Armenia");
        states.add("Great Britain");
        for(String state : states){
            System.out.println(state);
        }

        //  implement a class, override equals, hashCode methods, use it with HashSet
        //  implement a class, override equals, hashCode, compareTo methods, use it with TreeSet

        //  use Collections methods: emptySet, singleton, unmodifiableSet
        Set<String> emset = Collections.emptySet();
        System.out.println(emset);     //  outputs '[]'

        // create singleton set
        Set<String> sinset = new HashSet<String>();
        sinset = Collections.singleton("OnlyOneElement");

        //  create unmodifiableSet
        Set<String> immutableset = Collections.unmodifiableSet(states);

        //  create HashMap by different constructors
        HashMap<Integer, String> passportsAndNames = new HashMap<>();
//        HashMap<K, V> hm = new HashMap<K, V>(int initialCapacity);
//        HashMap<K, V> hm = new HashMap<K, V>(int initialCapacity, int  loadFactor);
//        HashMap<K, V> hm = new HashMap<K, V>(Map map);


        passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(162348, "Иван Михайлович Серебряков");
        passportsAndNames.put(8082771, "Дональд Джон Трамп");

        //  try to add null to HashMap as key and value (JUnit)
        passportsAndNames.put(null, null);
        System.out.println(passportsAndNames);
            // outputs '{null=null, 212133=Лидия Аркадьевна Бубликова, 8082771=Дональд Джон Трамп, 162348=Иван Михайлович Серебряков}'

        //  use Map methods on HashMap object
        Map<Integer, String> countries = new HashMap<Integer, String>();
        countries.put(1, "Germany");
        countries.put(2, "Spain");
        countries.put(4, "France");
        countries.put(3, "Italy");

        // получим объект по ключу 2
        String first = countries.get(2);
        System.out.println(first);
        // получим весь набор ключей
        Set<Integer> keys = countries.keySet();
        // получить набор всех значений
        Collection<String> values = countries.values();
        //заменить элемент
        countries.replace(1, "Poland");
        // удаление элемента по ключу 2
        countries.remove(2);
        // перебор элементов
        for (Map.Entry<Integer, String> item : countries.entrySet()) {
            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        }
        Map<String, Person> people = new HashMap<String, Person>();
        people.put("1240i54", new Person("Tom"));
        people.put("1564i55", new Person("Bill"));
        people.put("4540i56", new Person("Nick"));

        for (Map.Entry<String, Person> item : people.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }

        //  create LinkedHashMap by different constructors

//        LinkedHashMap<K, V> lhm1 = new LinkedHashMap<K, V>();
//        LinkedHashMap<K, V> lhm2 = new LinkedHashMap<K, V>(int capacity);
//        LinkedHashMap<K, V> lhm3 = new LinkedHashMap<K, V>(Map<? extends K, ? extends V> map);
//        LinkedHashMap<K, V> lhm4 = new LinkedHashMap<K, V>(int capacity, float fillRatio);
//        LinkedHashMap<K, V> lhm5 = new LinkedHashMap<K, V>(int capacity, float fillRatio, boolean Order);

        //  create TreeMap by different constructors
        TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();
        Comparator comparator1 = tree_map.comparator();
        TreeMap<String, Integer> tree_map1 = new TreeMap<String, Integer>(comparator1);
        TreeMap<Integer, String> tree_map2 = new TreeMap<Integer, String>(countries);
        SortedMap<Integer, String> sorted_map = new ConcurrentSkipListMap<Integer, String>();
        TreeMap<Integer, String> tree_map3 = new TreeMap<Integer, String>(sorted_map);

        //  use non-inherited Queue methods on LinkedList object
        Queue queueA = new LinkedList();
        queueA.add("element 0");
        queueA.add("element 1");
        queueA.add("element 2");
        //access via Iterator
        Iterator iterator5 = queueA.iterator();
        while(iterator.hasNext()) {
            String element =(String) iterator.next();
        }
        //access via new for-loop
        for(Object object : queueA) {
            String element =(String) object;
        }

        //  use non-inherited Deque methods on ArrayDeque object
        ArrayDeque<String> statesq = new ArrayDeque<String>();

        statesq.add("Germany");
        statesq.addFirst("France"); // добавляем элемент в самое начало
        statesq.push("Great Britain"); // добавляем элемент в самое начало
        statesq.addLast("Spain"); // добавляем элемент в конец коллекции
        statesq.add("Italy");

        String sFirst = statesq.getFirst();
        System.out.println(sFirst);     // Great Britain
        String sLast = statesq.getLast();
        System.out.println(sLast);      // Italy
        System.out.printf("Queue size: %d \n", statesq.size());  // 5

        while(statesq.peek()!=null){
            System.out.println(statesq.pop());
        }

    }

    static class Person {
        private String name;

        public Person(String value) {
            name = value;
        }

        String getName() {
            return name;
        }
    }
}
