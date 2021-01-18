public interface JavaInheritanceAttack {

    public void move();
    public void attack();

    //   use a default method of interface
    public default void rustle() {
        System.out.println("shu-shu-shu...");
    }

    //  use static method of interface
    public static void chew() {
        System.out.println("nyam-nyam-nyam...");
    }

}
