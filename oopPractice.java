public class Fan {
    // Constants
    public static final int SLOW = 0;
    public static final int MEDIUM = 1;
    public static final int FAST = 2;

    // Private data fields
    private int speed;
    private boolean on;
    private double radius;
    private String colour;

    // Default constructor
    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5.0;
        this.colour = "blue";
    }

    // Getter and setter methods for speed
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Getter and setter methods for on
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    // Getter and setter methods for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter and setter methods for colour
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    // toString method
    public String toString() {
        return "Fan [speed=" + speed + ", on=" + on + ", radius=" + radius + ", colour=" + colour + "]";
    }
    
}
