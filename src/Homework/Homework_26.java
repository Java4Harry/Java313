package lessons.src.Homework;

public class Homework_26 {
    public static void main(String[] args) {
        System.out.println("Скорость самолета составляет " + Vehicle.AIRPLANE.getSpeed() + " миль в час.");
        System.out.println();
        System.out.println("Скорости транспортных средств:");
        for (Vehicle vehicle : Vehicle.values()) {
            System.out.println(vehicle.toString());
        }
    }
}

enum Vehicle{
    CAR("CAR", 65),
    TRUCK("TRUCK", 55),
    AIRPLANE("AIRPLANE", 600),
    TRAIN("TRAIN", 70),
    BOAT("BOAT", 22);

    private String type;
    private int speed;

    Vehicle(String type, int speed) {
        this.type = type;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return this.type + " типичная скорость составляет " + this.speed + " миль в час.";
    }
}
