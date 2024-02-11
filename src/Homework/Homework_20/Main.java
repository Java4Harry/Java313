package lessons.src.Homework.Homework_20;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Данные какого количества автомобилей добавляем? ");
        byte number = input.nextByte();
        Automobile auto[] = new Automobile[number];
        for (int i = 0; i < number; i++) {
            auto[i] = new Automobile();
            System.out.println("Введите данные " + (i + 1) + "-ой машины");
            auto[i].input();
            System.out.println();
        }
        for (int i = 0; i < number; i++) {
            auto[i].output();
        }
    }
}
