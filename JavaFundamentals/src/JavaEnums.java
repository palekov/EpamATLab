import java.util.*;

enum Season { WINTER, SPRING, SUMMER, AUTUMN }    //  simple enum
enum Season2 { WINTER, SPRING, SUMMER, AUTUMN }

enum Currency { USD, AUD, GBP, EUR }



enum NumEnum {                                    //  enum with with field, method, private constructor and the overridden 'toString'

    NUM_ONE("NUM_ONE"), NUM_TWO("NUM_TWO"), NUM_THREE("NUM_THREE");

    private String value;

    private NumEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue().toLowerCase(Locale.ROOT).replace("_", "");
    }
}

interface Food {                                  //  enum that implements an interface
    enum Appetizer implements Food {
        SALAD, SOUP, ROLLS;
    }
    enum Dessert implements Food {
        TIRAMISU, FRUIT, CREME_CARAMEL;
    }
    enum Coffee implements Food {
        BLACK_COFFEE, ESPRESSO, LATTE, CAPPUCCINO;
    }
}

enum AlarmPoints { OFFICE1, OFFICE2, OFFICE3, LOBBY, KITCHEN, UTILITY }  // enum for using in EnumSet and EnumMap

interface Command {  void action();  }           //  interface for using in EnumMap

enum MySingleton {                               //  enum Singleton
    INSTANCE;

    private MySingleton() {
        System.out.println("Here");
    }
}

/*
         --- MAIN CLASS ---
 */

public class JavaEnums {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Season.values()));   //  using toString method

        Season[] seasons = Season.values();                     //  get list of all enum constants and their ordinals
        for (Season s : seasons) {
            System.out.println(s.ordinal() + " " + s);
        }
                                                                //  equals by value (equals) and by reference (==)
        Season se1 = Season.AUTUMN;
        Season se2 = Season.SPRING;
        Season se3 = Season.AUTUMN;
        Season2 se4 = Season2.AUTUMN;
        System.out.println(se1 == se2);                         // outputs false
        System.out.println(se1 == se3);                         // outputs true
        // System.out.println(se1 == se4);                      // it cannot be applied between two different enums
        System.out.println(se1.equals(se2));                    // outputs false
        System.out.println(se1.equals(se3));                    // outputs true
        System.out.println(se1.equals(se4));                    // outputs false because 'AUTUMN' from two different enums

        NumEnum[] numbers = NumEnum.values();                   //  using enum with the overridden 'toString'
        for (NumEnum n : numbers) {
            System.out.println(n);
        }
                                                                //  converting String to Enum
        String usd = "USD";
        Enum currency = Enum.valueOf(Currency.class, usd);

        currency = Currency.valueOf(usd);

        System.out.println("String to Enum Example : " + currency);

        Season ss;
        Season str = Season.valueOf("WINTER");                 //  using valueOf(String)
        System.out.println(str);                               //  outputs 'WINTER'
        // str = Season.valueOf("WEATHER");                    //  IllegalArgumentException

        Food food = Food.Appetizer.SALAD;                      //  using enum with interface;
        food = Food.Dessert.TIRAMISU;
        food = Food.Coffee.LATTE;

        ss = Season.SPRING;
        switch (ss) {                                          //  using enum in switch statement
            case WINTER:
                System.out.println("Зима");
                break;
            case SPRING:
                System.out.println("Весна");
                break;
            case SUMMER:
                System.out.println("Лето");
                break;
            case AUTUMN:
                System.out.println("Осень");
                break;
        }
                                                              //  implement Singleton design pattern with enum
        System.out.println(MySingleton.INSTANCE);             //  outputs 'Here INSTANCE'

        EnumSet<AlarmPoints> points;                          //  use the classes: EnumSet, EnumMap
        points = EnumSet.allOf(AlarmPoints.class);
        System.out.println(points);                           //  outputs  '[OFFICE1, OFFICE2, OFFICE3, LOBBY, KITCHEN, UTILITY]'

        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("Kitchen fire!!!");
            }
        });
        em.put(AlarmPoints.UTILITY, new Command() {
            @Override
            public void action() {
                System.out.println("Utility room alert!!!");
            }
        });
        for(Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.print(e.getKey() + ": ");                    //  outputs 'KITCHEN: Kitchen fire!!!'
            e.getValue().action();                                  //          'UTILITY: Utility room alert!!!'
        }
    }

}



