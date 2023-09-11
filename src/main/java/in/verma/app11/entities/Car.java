package in.verma.app11.entities;

public class Car implements Runnable {
    private final String name;
    private final int distance;
    private final Object raceMonitor;

    public Car(String name, int distance, Object raceMonitor) {
        this.name = name;
        this.distance = distance;
        this.raceMonitor = raceMonitor;
    }

    @Override
    public void run() {
        int totalDistance = 0;
        while (totalDistance < distance) {
            int speed = (int) (Math.random() * 5) + 1; // скорость от 1 до 5
            totalDistance += speed;

            System.out.println(name + " проехал " + totalDistance + " метров");

            try {
                Thread.sleep(1000); // пауза в 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (raceMonitor) {
            System.out.println(name + " финишировал!");
            raceMonitor.notifyAll(); // уведомить всех о завершении гонки
        }
    }
}
