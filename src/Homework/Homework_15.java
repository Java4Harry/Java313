package Homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Homework_15 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Какой номер задачи будем решать (1 или 2)? ");
        if (input.hasNextByte()) {
            int number = input.nextByte();
            switch (number) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                default:
                    System.out.println("Вы ввели неверный номер задачи! Попробуйте снова.");
            }
        } else {
            System.out.println("Вы ввели символ, букву или дробное число! Попробуйте снова.");
        }
    }
    public static void task1() {
        input.nextLine();
        System.out.print("Введите два слова через пробел: ");
        String words = input.nextLine();
            String[] array = words.split(" ");
            try {
                if (array.length > 2) {
                    System.out.println("Ошибка ввода! Вы ввели больше двух слов!");
                } else {
                    words = String.join(" ", array[1], array[0]);
                    System.out.println("Результат: " + words);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка ввода! Вы ввели одно слово или ничего.");
            }
    }
    public static void task2(){
        input.nextLine();
        System.out.print("Введите строку: ");
        // Замените в этой строке все появления буквы "о" на букву "О", кроме первого и последнего вхождения.
        String words = input.nextLine();
        String replaceWords = words.substring((words.indexOf('о') + 1), words.lastIndexOf('о'));
        replaceWords = replaceWords.replace('о','О');
        System.out.println("Результат: " + words.substring(0,(words.indexOf('о') +1 )) + replaceWords + words.substring(words.lastIndexOf('о'), words.length()));
    }
}
