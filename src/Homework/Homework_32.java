package lessons.src.Homework;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Homework_32 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println("Введите 5 целых чисел:");
        while (treeSet.size() < 5) {
            treeSet.add(Input(treeSet));
        }
        System.out.println("Наименьший элемент в TreeSet: " + Min(treeSet));
    }

    public static int Input(TreeSet treeSet) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.print("-> ");
        number = input.nextInt();
        if (treeSet.contains(number)) {
            System.out.println("Повторяющееся значение! Введите другое число!");
            return Input(treeSet);
        } else {
            return number;
        }
    }

    public static int Min(TreeSet treeSet) {
        int min = Integer.MAX_VALUE;
        int current = 0;
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            current = iterator.next();
            if ( current < min){
                min = current;
            }
        }
        return min;
    }
}
