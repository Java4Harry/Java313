package lessons.src.Homework.homework_22;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        Student students[] = new Student[n];
        students[0] = new Student("Петров Василий Анатольевич", "Php100", new int[]{5, 4, 5, 5, 5});
        students[1] = new Aspirant("Алешин Григорий Нилович", "Python300", new int[]{5, 5, 5, 5, 5}, "ProjectBase");
        students[2] = new Student("Морковкина Светлана Геннадьевна", "Java200", new int[]{5, 3, 3, 3, 4});
        students[3] = new Student("Савин Антон Георгиевич", "Php100", new int[]{3, 5, 3, 5, 5});
        students[4] = new Aspirant("Егоров Леонид Васильевич", "Java200", new int[]{5, 5, 4, 4, 5}, "ProjectIntermediate");
        students[5] = new Student("Лаврентьева Анна Игоревна", "Php100", new int[]{5, 5, 5, 5, 5});
        students[6] = new Aspirant("Анисимова Снежана Петровна", "Java200", new int[]{5, 2, 5, 5, 5}, "ProjectPreIntermediate");
        students[7] = new Student("Данилкин Станислав Борисович", "Python300", new int[]{5, 5, 5, 5, 5});
        students[8] = new Aspirant("Александрова Елизавета Дмитриевна", "Java200", new int[]{5, 5, 5, 5, 4}, "ProjectProgressive");
        students[9] = new Aspirant("Тонких Иван Сергеевич", "Python300", new int[]{5, 5, 5, 5, 5}, "ProjectMaster");
        for (int i = 0; i < students.length; i++) {
            if (students[i] instanceof Aspirant) {
                System.out.println(students[i].getFIO() + ", группа " + students[i].getGroup() + ", тема работы: '" + ((Aspirant) students[i]).getWork() + "'" + ", сумма стипендии: " + (double) students[i].grant());
            } else {
                System.out.println(students[i].getFIO() + ", группа " + students[i].getGroup() + ", сумма стипендии: " + (double) students[i].grant());
            }
        }
    }
}
