package fanspeed;

public class Fan2 {
    private boolean isOn;
    private FanSpeed speed;

    public Fan2() {
        this.isOn = false;
        this.speed = FanSpeed.LOW;
    }

    public void switchOn() {
        if (isOn) {
            System.out.println("Fan is already ON");
        } else {
            isOn = true;
            System.out.println("Fan is ON");
        }
    }

    public void switchOff() {
        if (!isOn) {
            System.out.println("Fan is already OFF");
        } else {
            isOn = false;
            System.out.println("Fan is OFF");
        }
    }

    public void increaseSpeed() {
        if (!isOn) {
            System.out.println("Can't increase speed. Fan is OFF.");
            return;
        }

        switch (speed) {
            case LOW -> {
                speed = FanSpeed.MEDIUM;
                System.out.println("Fan speed increased to MEDIUM");
            }
            case MEDIUM -> {
                speed = FanSpeed.HIGH;
                System.out.println("Fan speed increased to HIGH");
            }
            case HIGH -> System.out.println("Fan is already at HIGH speed");
        }
    }

    public void decreaseSpeed() {
        if (!isOn) {
            System.out.println("Can't decrease speed. Fan is OFF.");
            return;
        }

        switch (speed) {
            case HIGH -> {
                speed = FanSpeed.MEDIUM;
                System.out.println("Fan speed decreased to MEDIUM");
            }
            case MEDIUM -> {
                speed = FanSpeed.LOW;
                System.out.println("Fan speed decreased to LOW");
            }
            case LOW -> System.out.println("Fan is already at LOW speed");
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public FanSpeed getSpeed() {
        return speed;
    }

    public String toString() {
        return (isOn ? "ON" : "OFF") + ", Speed: " + speed;
    }
}

