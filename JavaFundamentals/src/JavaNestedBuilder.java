
// implement Builder design pattern: make a constructor of the enclosing class private
// and use a static nested class to pass mandatory and optional parameters

public class JavaNestedBuilder {
    public final int a;
    public final int b;

    //   Реализация Builder через статический внутренний класс
    public static class Builder {
        public int a;
        public int b;

        //   Конструктор с обязательными параметрами
        public Builder(int a, int b) {
            this.a = a;
            this.b = b;
        }

        //   Метод с возвращающим типом JavaNestedBuilder для генерации объекта
        public JavaNestedBuilder build() {
            return new JavaNestedBuilder(this);
        }
    }

    //  Приватный конструктор
    private JavaNestedBuilder(Builder builder) {
        a = builder.a;
        b = builder.b;
    }

    public static void main(String[] args) {
        JavaNestedBuilder good = new JavaNestedBuilder.Builder(40, 20).build();
    }
}