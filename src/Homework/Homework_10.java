package Homework;


public class Homework_10 {
    public static void main(String[] args) {
        int [] array1 = new int[6];
        int [][] array2 = new int [6][6];
        System.out.println("Двумерный массив:");
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                array2[j][i] = (int) (Math.random() * 12);
                System.out.print(array2[j][i] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nОдномерный массив:");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 12);
            System.out.print(array1[i] + "\t");
        }
        System.out.println("\n\nПолученный массив:");
        for (int i = 0; i <array2.length; i++) {
                for (int j = 0; j < array1.length;j++) {
                    if (i % 2 == 1) {
                        array2[j][i] = array1[j];
                    }
                        System.out.print(array2[j][i] + "\t");
              }
            System.out.println();
        }
    }
}
