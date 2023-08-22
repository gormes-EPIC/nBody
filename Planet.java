
public class Planet {
    private double xpos;
    private double ypos;
    private double xvel;
    private double yvel;
    private double bdMass;
    private String imageFileName;


    public Planet (double xposition, double yposition, double xvelocity, double yvelocity, double bodyMass, String fileName){
        xpos = xposition;
        ypos = yposition;
        xvel = xvelocity;
        yvel = yvelocity;
        bdMass = bodyMass;
        imageFileName = fileName;
    }

    public void setXpos(double xpos) {
        this.xpos = xpos;
    }

    public double getXpos(){
        return xpos;
    }

    public void setYpos(double ypos) {
        this.ypos = ypos;
    }

    public double getYpos() {
        return ypos;
    }

    public void setXvel(double xvel) {
        this.xvel = xvel;
    }

    public double getXvel() {
        return xvel;
    }

    public void setYvel(double yvel) {
        this.yvel = yvel;
    }

    public double getYvel() {
        return yvel;
    }

    public void setBdMass(double bdMass) {
        this.bdMass = bdMass;
    }

    public double getBdMass() {
        return bdMass;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public String toString(){
        String planetReturn = "";
        planetReturn += xpos + "; " + ypos  + "; " + xvel  + "; " + yvel  + "; " + bdMass  + "; " + imageFileName + "\n";
        return planetReturn;
    }

}
