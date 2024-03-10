package lessons.src.Homework;

import java.util.Scanner;

public class Homework_28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word1, word2;
        TheShortestWord word = new TheShortestWord() {
            @Override
            public String IsTheShortest(String word1, String word2) {
                if (word1.length() > word2.length()) {
                   return word2;
                } else {
                    return word1;
                }
            }
        };
        System.out.print("Первое слово: ");
        word1 = input.nextLine();
        System.out.print("Второе слово: ");
        word2 = input.nextLine();
        System.out.println("Самое короткое слово: " + word.IsTheShortest(word1, word2));
    }
}

interface TheShortestWord{
    String IsTheShortest(String word1, String word2);
}
