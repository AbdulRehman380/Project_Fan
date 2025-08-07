import fanspeed.Fan2;
import java.util.Scanner;

public class FanSpeedTest {
    public static void main(String[] args) {
        Fan2 fan = new Fan2();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("=== Fan Controller ===");
        //System.out.println("Available commands: 1-On Fan, 2-OffFan, 3-IncreaseFanspeed, 4-DecreaseFanSpeed, 5-Status, 6-ExitProgram");

        while (true) {
            System.out.println("Available commands: \n1-On Fan, \n2-OffFan, \n3-IncreaseFanspeed, \n4-DecreaseFanSpeed, \n 5-Status, \n6-ExitProgram");

            System.out.print("Enter command: ");
            input = scanner.nextLine();//.trim().toLowerCase();

            switch (input) {
                case "1":
                    fan.switchOn();
                    break;
                case "2":
                    fan.switchOff();
                    break;
                case "3":
                    fan.increaseSpeed();
                    break;
                case "4":
                    fan.decreaseSpeed();
                    break;
                case "5":
                    System.out.println("Fan is " + (fan.isOn() ? "ON" : "OFF"));
                    System.out.println("Fan speed is " + fan.getSpeed());
                    break;
                case "6":
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}
