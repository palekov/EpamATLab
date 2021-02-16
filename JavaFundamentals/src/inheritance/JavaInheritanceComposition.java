package inheritance;

public class JavaInheritanceComposition {

    //  use composition (has-a) as an alternative to inheritance and (is-a)
    static class Insect {
        private int size;
        private String color;

        public Insect(int size, String color) {
            this.size = size;
            this.color = color;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    static class Bee extends Insect implements JavaInheritanceAttack {

        private JavaInheritanceAttack attack;

        public Bee(int size, String color, JavaInheritanceAttack attack) {
            super(size, color);
            this.attack = attack;
        }

        public void move() {
            attack.move();
        }

        public void attack() {
            attack.attack();
        }
    }

    static class AttackImpl implements JavaInheritanceAttack {
        private String move;
        private String attack;

        public AttackImpl(String move, String attack) {
            this.move = move;
            this.attack = attack;
        }

        @Override
        public void move() {
            System.out.println(move);
        }

        @Override
        public void attack() {
            move();
            System.out.println(attack);
        }
    }

}
