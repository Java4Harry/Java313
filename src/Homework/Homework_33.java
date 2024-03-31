package lessons.src.Homework;

import java.util.HashMap;
import java.util.Map;

public class Homework_33 {
    public static void main(String[] args) {
        String[] colors = new String[]{"red", "orange", "aqua", "pink", "gray", "blue", "white", "black", "yellow", "brown"};
        HashMap<String, Color> colorMap = new HashMap<>();
        int j = 0;
        for (int i = 0; i < colors.length; i++) {
            colorMap.put(colors[i], Color.ColorModify(colors[i]));
        }
        for (Map.Entry<String, Color> entry : colorMap.entrySet()) {
            j++;
            System.out.println(j + ") " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
class Color{
    private String name;

    public Color(String name) {
        this.name = name;
    }

    public static Color ColorModify(String name) {
        Color nameUpper = new Color(name.toUpperCase());
        return  nameUpper;
    }

    @Override
    public String toString() {
        return name;
    }
}
