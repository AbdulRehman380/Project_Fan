import fanspeed.Fan2;
import java.util.ArrayList;
import java.util.Scanner;

public class FanSpeedTest {
    public static void main(String[] args) {
        ArrayList<Fan2> fans = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            fans.add(new Fan2());
        }

        Scanner sc = new Scanner(System.in);
        int selectedFanIndex = -1;

        while (true) {
            System.out.println("\nSelected Fan: " + (selectedFanIndex == -1 ? "None" : selectedFanIndex));
            System.out.println("Commands:");
            System.out.println("0 - Select Fan (0 to 9)");
            System.out.println("1 - Switch ON selected fan");
            System.out.println("2 - Switch OFF selected fan");
            System.out.println("3 - Increase speed");
            System.out.println("4 - Decrease speed");
            System.out.println("5 - Show selected fan status");
            System.out.println("6 - Show ALL fans status");
            System.out.println("7 - Exit");
            System.out.println("8 - Show fans that are ON "); // New option
            System.out.print("Enter command: ");

            String input = sc.nextLine();

            switch (input) {
                case "0" -> {
                    System.out.print("Enter fan number (0-9): ");
                    try {
                        int index = Integer.parseInt(sc.nextLine());
                        if (index >= 0 && index < fans.size()) {
                            selectedFanIndex = index;
                            System.out.println("Fan " + index + " selected.");
                        } else {
                            System.out.println("Invalid fan number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                }
                case "1" -> {
                    if (isValidSelection(selectedFanIndex)) {
                        fans.get(selectedFanIndex).switchOn();
                        System.out.println("Fan " + selectedFanIndex + " switched ON.");
                    }
                }
                case "2" -> {
                    if (isValidSelection(selectedFanIndex)) {
                        fans.get(selectedFanIndex).switchOff();
                        System.out.println("Fan " + selectedFanIndex + " switched OFF.");
                    }
                }
                case "3" -> {
                    if (isValidSelection(selectedFanIndex)) {
                        fans.get(selectedFanIndex).increaseSpeed();
                        System.out.println("Fan " + selectedFanIndex + " speed increased.");
                    }
                }
                case "4" -> {
                    if (isValidSelection(selectedFanIndex)) {
                        fans.get(selectedFanIndex).decreaseSpeed();
                        System.out.println("Fan " + selectedFanIndex + " speed decreased.");
                    }
                }
                case "5" -> {
                    if (isValidSelection(selectedFanIndex)) {
                        System.out.println("Fan " + selectedFanIndex + ": " + fans.get(selectedFanIndex));
                    }
                }
                case "6" -> {
                    System.out.println("\n--- All Fans Status ---");
                    for (int j = 0; j < fans.size(); j++) {
                        System.out.println("Fan " + j + ": " + fans.get(j));
                    }
                }
                case "7" -> {
                    System.out.println("Exiting.");
                    return;
                }
                case "8" -> {
                    System.out.println("\n--- Fans That Are ON ---");
                    boolean anyOn = false;
                    for (int j = 0; j < fans.size(); j++) {
                        if (fans.get(j).isOn()) {
                            System.out.println("Fan " + j + ": " + fans.get(j));
                            anyOn = true;
                        }
                    }
                }
                default -> System.out.println("Invalid command.");
            }
        }
    }
    private static boolean isValidSelection(int index) {
        if (index == -1) {
            System.out.println("Please select a fan first (option 0).");
            return false;
        }
        return true;
    }
}
