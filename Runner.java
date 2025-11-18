package model;

/**
 * GitHub:
 * https://github.com/Vanier-ComputerScience/420-sf3-re-assignmnet-02-2025-fall-Nads24
 *
 * Author: Nads
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

    public void setXPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void updatePosition(double time) {
        if (!finished) {
            xPosition += speed * time;
        }
    }
}
