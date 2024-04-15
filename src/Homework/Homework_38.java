package lessons.src.Homework;

public class Homework_38 {
    public static void main(String[] args) {
        int n = 10;
        TrafficLights trafficLights = new TrafficLights("RED");
        for (int i = 0; i < n; i++) {
            new Thread(() -> trafficLights.lightsChange()).start();
        }
    }
}
class TrafficLights{
    private String color;

    public TrafficLights(String color) {
        this.color = color;
    }
    public synchronized void lightsChange(){
        if (this.color == "RED") {
            try {
                System.out.println("RED");
                Thread.sleep(4000);
                this.color = "GREEN";
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        } else if (this.color == "YELLOW"){
            try {
                System.out.println("YELLOW");
                Thread.sleep(1000);
                this.color = "RED";
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        } else if (this.color == "GREEN"){
            try {
                System.out.println("GREEN");
                Thread.sleep(7000);
                this.color = "YELLOW";
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
