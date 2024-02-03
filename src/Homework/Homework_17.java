package Homework;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String password = input.nextLine();
        String pattern = "^[\\w\\@\\-]{6,18}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(password);
                if (matcher.find() == true) {
                    System.out.println("Пароль одобрен. Добро пожаловать!");
            } else {
                System.out.println("Введен недопустимый символ, количество символов меньше 6 или больше 18");
                }
    }
}
