package lessons.src.Homework.Homework_20;

import java.util.Scanner;

public class Automobile {
    private String model;
    private int year;
    private String manufacturer;
    private int power;
    private String color;
    private int price;


    public Automobile() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if (year > 1930 || year <= 2024) {
            this.year = year;
        } else {
            System.out.println("Указан неверный год выпуска!");
        }
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPower() {
        return power;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public void input(){
        Scanner input = new Scanner(System.in);
            System.out.print("Введите модель: ");
            model = input.nextLine();
            System.out.print("Введите год выпуска: ");
            year = input.nextInt();
            while (year < 1930 || year > 2024) {
                System.out.println("Неверный год выпуска! Введите заново.");
                year = input.nextInt();
            }
            System.out.print("Введите производителя: ");
            input.nextLine();
            manufacturer = input.nextLine();
            System.out.print("Введите мощность двигателя: ");
            power = input.nextInt();
            System.out.print("Введите цвет: ");
            input.nextLine();
            color = input.nextLine();
            System.out.print("Введите цену: ");
            price = input.nextInt();
            input.nextLine();
    }
    public void output(){
        System.out.println("*********** Данные автомобиля ***********");
        System.out.println("Название модели: " + model);
        System.out.println("Год выпуска: " + year);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Мощность двигателя: " + power + " л.с.");
        System.out.println("Цвет машины: " + color);
        System.out.println("Цена: " + price);
        System.out.println("=========================================");
        System.out.println();
    }
}
