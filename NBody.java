import java.io.*;
import java.util.*;
import java.lang.*;

public class NBody {

    private int capt;
    private int delt;
    private int planetNum;
    private double unvRad;
    private String imgName;
    Planet[] planetInfo;
    public NBody(int duration, int timeincrement, String imageName){
        capt = duration;
        delt = timeincrement;
        imgName = imageName;
    }

    public void readPlanets(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        planetNum = sc.nextInt();
        unvRad = sc.nextDouble();
        planetInfo = new Planet[5];
        int counter = 0;
        while(counter < planetNum){
            Planet newPlanet = new Planet(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()),
                    Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()),
                    sc.next());
            planetInfo[counter] = newPlanet;
            counter++;
        }
    }

    public void step(){
        double[] xAccPl = new double[planetNum];
        double[] yAccPl = new double[planetNum];
        for(int i = 0; i < planetNum; i++){
            double xForce = 0;
            double yForce = 0;
            for(int j = 0; j < planetNum; j++){
                if (i != j){
                    double forces = planetInfo[i].getBdMass() * planetInfo[j].getBdMass();
                    forces = forces * Math.pow(10, -11) * 6.67;
                    double delx = planetInfo[i].getXpos() - planetInfo[j].getXpos();
                    double dely = planetInfo[i].getYpos() - planetInfo[j].getYpos();
                    double r = Math.sqrt(delx*delx + dely*dely);
//                    System.out.println(planetInfo[i].getImageFileName() + " to " + planetInfo[j].getImageFileName()
//                            + ": delx" + delx + " ; dely" + dely);
                    xForce += forces/r/r*delx/r;
                    yForce += forces/r/r*dely/r;
                }
            }
            xAccPl[i] = xForce/planetInfo[i].getBdMass();
            yAccPl[i] = yForce/planetInfo[i].getBdMass();

        }
        for(int i = 0; i < planetNum; i++){
            planetInfo[i].setXvel(planetInfo[i].getXvel() + delt*xAccPl[i]);
            planetInfo[i].setYvel(planetInfo[i].getYvel() + delt*yAccPl[i]);
            planetInfo[i].setXpos(planetInfo[i].getXpos() + delt*planetInfo[i].getXvel());
            planetInfo[i].setYpos(planetInfo[i].getYpos() + delt*planetInfo[i].getYvel());
        }
    }

    public void runSimulation() throws InterruptedException {
        animatePlanets();
        StdAudio.play("2001.wav");
        for (int i = 0; i < capt; i+= delt){

            step();
            animatePlanets();
            Thread.sleep(1000);
        }
        for(int i = 0; i < planetNum; i ++){
            planetInfo[i].toString();
        }
    }
    public void animatePlanets(){
        StdDraw.setCanvasSize(500, 500);
        StdDraw.picture(0,0, imgName);
        for(int i = 0; i < planetNum; i++){
            Planet planet = planetInfo[i];
            double xpos = planet.getXpos();
            double ypos = planet.getYpos();
            double bdMass = planet.getBdMass();
            String imgName = planet.getImageFileName();
            StdDraw.picture(0.5+xpos/unvRad/2, 0.5+ypos/unvRad/2, imgName);
        }

    }

}
