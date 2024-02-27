package lessons.src.Homework.homework_25;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(100, 150);
        System.out.println("Width: " + rect.getWidth() + ", Height: " + rect.getHeight() + "\n");
        rect.resizeWidth();
        rect.resizeHeight();
        System.out.println("Width: " + rect.getWidth() + ", Height: " + rect.getHeight() + "\n");
    }
}
