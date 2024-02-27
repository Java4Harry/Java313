package lessons.src.Homework.homework_25;

import java.util.Scanner;

public class Rectangle implements Resize{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int resizeWidth() {
        this.width = inputWidth();
        while (this.width < MIN_WIDTH) {
            System.out.println("Ширина не может быть отрицательной. Повторите ввод!");
            this.width = inputWidth();
        }
        return this.width;
    }

    @Override
    public int resizeHeight() {
        this.height = inputHeight();
        while (this.height < MIN_HEIGHT) {
            System.out.println("Высота не может быть отрицательной. Повторите ввод!");
            this.height = inputHeight();
        }
        return this.height;
    }

    @Override
    public int inputWidth() {
        Scanner input = new Scanner(System.in);
        System.out.print("Задайте новую ширину объекта: ");
        return this.width = input.nextInt();
    }

    @Override
    public int inputHeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("Задайте новую высоту объекта: ");
        return this.height = input.nextInt();
    }
}
