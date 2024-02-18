package lessons.src.Homework.homework_22;

public class Student {
    private String FIO;
    private String Group;
    private int[] marks;

    public Student(String FIO, String group, int[] marks) {
        this.FIO = FIO;
        this.Group = group;
        this.marks = marks;
    }

    public String getFIO() {
        return FIO;
    }
    public String getGroup() {
        return Group;
    }
    public int[] getMarks() {
        return marks;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }
    public void setGroup(String group) {
        Group = group;
    }
    public void setMarks(int[] marks) {
        for (int i: marks) {
            if (marks[i] >= 1 && marks[i] <= 5) {
                this.marks[i] = marks[i];
            }
        }
    }

    public double averageMark() {
        int average = 0;
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            average += marks[i];
            count++;
        }
        return average / count;
    }

    public int grant () {
        if (averageMark() == 5) {
            return 1000;
        }
        return 800;
    }
}
