package lessons.src.Homework.homework_22;

public class Aspirant extends Student{
    private String work;

    public Aspirant(String FIO, String group, int[] marks, String work) {
        super(FIO, group, marks);
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public int grant () {
        if (averageMark() == 5) {
            return 2000;
        }
        return 1800;
    }
}
