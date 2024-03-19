package lessons.src.Homework;

import java.util.LinkedList;
import java.util.ListIterator;

public class Homework_31 {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Красный");
        colors.add("Оранжевый");
        colors.add("Желтый");
        colors.add("Зеленый");
        colors.add("Голубой");
        colors.add("Синий");
        colors.add("Фиолетовый");
        ListIterator<String> iterator = colors.listIterator();
        System.out.println("Список: " + colors.toString());
        System.out.println("\nСписок итераторов в прямом направлении: ");
        while (iterator.hasNext()) {
            System.out.println("Индекс = " + iterator.nextIndex() + ", Элемент = " + iterator.next());
        }
        System.out.println("\nСписок итераторов в обратном направлении: ");
        while (iterator.hasPrevious()) {
            System.out.println("Индекс = " + iterator.previousIndex() + ", Элемент = " + iterator.previous());

        }
    }
}
