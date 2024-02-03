package Homework;

public class Homework_2 {
    public static void main(String[] args) {
      int number = 41194;
      int n1, n2, n3, n4, n5;
      double average;
        System.out.printf("Введенное число = %d %n", number);
        n1 = number % 10;
        n2 = (number / 10) % 10;
        n3 = (number / 100) % 10;
        n4 = (number / 1000) % 10;
        n5 = (number / 10000) % 10;
        number = n1 * n2 * n3 * n4 * n5;
        System.out.printf("n1 = %d, n2 = %d, n3 = %d, n4 = %d, n5 = %d %n", n1, n2, n3, n4, n5);
        System.out.printf("Произведение цифр = %d %n", number);
        average = (n1 + n2 + n3 + n4 + n5) / 5.;
        System.out.printf("Среднее арифметическое = %.1f", average);
    }
}