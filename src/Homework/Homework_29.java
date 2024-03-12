package lessons.src.Homework;

import java.util.Scanner;
import java.util.function.Predicate;

public class Homework_29 {
    public static void main(String[] args) {
        int num = inputNumber();
        Predicate<Integer> isSimple = number -> {
                int count = 0;
                for (int i = 1; i <= number; i++) {
                    if (number % i == 0) {
                        count++;
                    }
                }
                if (count == 2) return true;
                else return false;
        };
        System.out.println(num + " является простым числом: " + isSimple.test(num));
    }

    public static int inputNumber(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число для проверки: ");
        return input.nextInt();
    }
}
