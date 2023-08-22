import java.io.FileNotFoundException;

public class NBodySimulator {
    public static void main(String[] args){
        NBody solarSystem = new NBody(4000000, 400000, "C:\\Users\\gormes\\Documents\\nBody\\stars.jpg");
        try {
            solarSystem.readPlanets("C:\\Users\\gormes\\Documents\\nBody\\planets.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            solarSystem.runSimulation();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
