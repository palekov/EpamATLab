
package module011;

import java.util.Scanner;

//  Написать простейший калькулятор – консольное приложение
//  (реализовать как минимум 4 операции: сложение, вычитание, умножение, деление)
//  с вводом\выводом из консоли;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("--- Калькулятор ---");
        System.out.println("введите число[пробел]операция[пробел]число");
        System.out.println("например '3 + 2' или '2 * 5'");
        Scanner scan = new Scanner(System.in);
        String str = "";
        String oper = "";
        double result;
        double i1 , i2;
        String[] vir = new String[10];
        while(!str.equals("q")) {
            result = 0;
            i1 = 0; i2 = 0;
            System.out.println("Введите выражение для вычисления или 'q' для выхода :");
            str = scan.nextLine();
            if (str.equals("q")) break;
            String[] words = str.split(" ");

            if (words.length != 3) {
                System.out.println("некорректный ввод!");
                System.out.println("введите число[пробел]операция[пробел]число!");
                continue;
            }

            try {
                i1 = Double.parseDouble(words[0]);
            } catch (NumberFormatException e) {
                System.out.println("Ахтунг! Введено не корректное число! Программа разрушена!");
            }

            oper = words[1];

            try {
                i2 = Double.parseDouble(words[2]);
            } catch (NumberFormatException e) {
                System.out.println("Ахтунг! Введено не корректное число! Программа разрушена!");
            }

            switch (oper) {
                case "+":
                    result = i1 + i2;
                    break;
                case "-":
                    result = i1 - i2;
                    break;
                case "/":
                    result = i1 / i2;
                    break;
                case "*":
                    result = i1 * i2;
                    break;
                default:
                    System.out.println("incorrect operation! try again!");
            }
            System.out.println("Результат: " + result);
        }
    }
}
