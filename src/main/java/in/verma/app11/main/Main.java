package in.verma.app11.main;
import in.verma.app11.entities.Car;

public class Main {
    public static void main(String[] args) {
        final int distance = 100; // расстояние в метрах
        Object raceMonitor = new Object();

        Thread car1 = new Thread(new Car("Car1", distance, raceMonitor));
        Thread car2 = new Thread(new Car("Car2", distance, raceMonitor));

        car1.start();
        car2.start();
    }
}
