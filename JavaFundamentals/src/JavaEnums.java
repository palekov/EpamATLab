import java.util.Arrays;
import java.util.Locale;

public class JavaEnums {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(Season.values()));   //  using toString method

        Season[] seasons = Season.values();                     //  get list of all enum constants
        for (Season s : seasons) { System.out.println(s); }

        NumEnum[] numbers = NumEnum.values();
        for (NumEnum n : numbers) { System.out.println(n); }   //  using enum with override toString

        Season ss;
        ss = Season.SPRING;
        switch (ss) {
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


    }

    enum Season { WINTER, SPRING, SUMMER, AUTUMN }

    enum NumEnum {  NUM_ONE("NUM_ONE"), NUM_TWO("NUM_TWO"), NUM_THREE("NUM_THREE");

        private String value;

        NumEnum(String value) {
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
    }



