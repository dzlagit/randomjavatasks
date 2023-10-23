public class Droid {
  int battery; 
  String name;
    
  public String performTask(String task) {
    return name + " is performing " + task + "!" + " Battery level is now: " + (battery - 10);
  }
  
  public String toString() {
    return "Hello, I’m the droid:" + name;
  }
  
  public Droid(String droidName, int batteryLevel) {
    name = droidName;
    battery = batteryLevel;
    } 
  public static void main(String[] args) {
    Droid robot = new Droid("Robot", 100);
    System.out.println("The robot " + (robot.name) + " has a battery level of: " + (robot.battery) +  "%");
    System.out.println(robot.performTask("eating"));
  }
}
