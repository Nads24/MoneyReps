package model;

/**
 * Git Repository:
 * https://github.com/Vanier-ComputerScience/420-sf3-re-assignmnet-02-2025-fall-jameshuyha.git
 *
 * @author Huy James Vien Ha (6324151)
 */
public class Runner {

    private String name;
    private String number;
    private String color;
    private double xPosition;
    private double speed;
    private boolean finished;

    public Runner(String name, String number, String color, double startX) {
        this.name = name;
        this.number = number;
        this.color = color;
        this.xPosition = startX;
        this.speed = Math.random() * 50 + 50;
        this.finished = false;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isFinished() {
        return finished;
    }

    // Sets position of runner
    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    // Defines when runner has reached the finished line
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    // Updates position based on speed and time of runner
    public void updatePosition(double time) {
        if (!finished) {
            xPosition += speed * time;
        }
    }
}
