// Amanda Brock
// April 19, 2026
// Purpose: Defines a Fan object with designated attributes.
// Displays the fan's current state in a readable format.

public class Fan {

    // Constants
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Fields
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // Defaults
    public Fan() {
        speed = STOPPED;
        on = false;
        radius = 6;
        color = "white";
    }

    // Argument constructor
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    // Getters and Setters
    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public boolean isOn() { return on; }
    public void setOn(boolean on) { this.on = on; }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // Speed
    public String getSpeedString() {
        switch (speed) {
            case SLOW: return "SLOW";
            case MEDIUM: return "MEDIUM";
            case FAST: return "FAST";
            default: return "STOPPED";
        }
    }

    // toString method
    @Override
    public String toString() {
        if (on) {
            return "Fan is ON\nSpeed: " + getSpeedString() +
                   "\nRadius: " + radius +
                   "\nColor: " + color;
        } else {
            return "Fan is OFF\nRadius: " + radius +
                   "\nColor: " + color;
        }
    }
}