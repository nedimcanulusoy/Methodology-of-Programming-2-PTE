/*
* ToothBrush project for Methodology of Programming Course
* Purpose of this project was adding some smart features to a basic toothbrush via using java language
* Written by Nedim Can Ulusoy
* NEPTUN CODE: HUUMCJ
* DATE: 2020-10-05
*/

import java.util.Random; // To get random values
import java.util.Scanner; // To get Input

public class ToothBrush {
    private boolean isWorking = false; //Default Off
    private String cleaningSpeed = "NORMAL"; //Default speed
    private String cleaningMode = "DAILY CLEAN"; //Default mode
    private int batteryPercentage = 100; //Full battery

    public ToothBrush() {
        // calling methods on this block
        onOff();
        userProfile();
        cleaningMode();
        cleaningSpeed();
        cleaningStarts();
        pressureToTeethSensor();
        cleaningFinishes();

        System.out.println("Remaining Battery = " + batteryPercentage);
    }

    //User is able to switch on/off via this method
    public void onOff() {
        System.out.println("ON/OFF: ");
        Scanner getInput = new Scanner(System.in); //Getting user's input
        String input = getInput.nextLine(); //used to get the input string that was skipped of the scanner object

        if (input.equalsIgnoreCase("ON")) {
            isWorking = true; //If input is "on", isWorking switches to "true"
            System.out.println("IT IS ON!");
        } else {
            isWorking = false; //If input is not "on", isWorking switches to "false"
            System.out.println("IT IS OFF!");
        }
    }

    //Consume battery based on user-usage
    public void consumeBattery() {
        Random random = new Random();//Setted up random function
        int result = random.nextInt(25-10) + 10;//Getting a random integer value between 25 and 10
        batteryPercentage = batteryPercentage - result;//Subtracting a random integer from batteryPercentage to get remaining
    }

    //Takes the user's name and welcomes
    public void userProfile() {
        System.out.println("Enter your profile name: ");
        Scanner getInput = new Scanner(System.in); //Getting user's input

        System.out.println("Welcome " + getInput.nextLine() + "!"); //Returns an output with gotten user's input
    }

    //User is able to choose the cleaning speed via this method
    public void cleaningSpeed() {
        System.out.println("Choose your cleaning speed (SLOW/NORMAL/FAST): ");
        Scanner getInput = new Scanner(System.in); //Getting user's input
        String input = getInput.nextLine(); //used to get the input string that was skipped of the scanner object

        //Getting the user's choice and giving notification about selected cleaning speed
        if (input.equalsIgnoreCase("SLOW")) {
            cleaningSpeed = "SLOW";
            System.out.println("SLOW CLEANING MOD IS ACTIVATED");
        } else if (input.equalsIgnoreCase("NORMAL")) {
            cleaningSpeed = "NORMAL";
            System.out.println("NORMAL CLEANING MOD IS ACTIVATED");
        } else if (input.equalsIgnoreCase("FAST")) {
            cleaningSpeed = "FAST";
            System.out.println("FAST CLEANING MOD IS ACTIVATED");
        }
    }

    //User is able to choose the cleaning mode via this method
    public void cleaningMode() {
        System.out.println("Choose your cleaning mode (DAILY CLEAN/DEEP CLEAN/SENSITIVE CLEAN/WHITENING): ");
        Scanner getInput = new Scanner(System.in); //Getting user's input
        String input = getInput.nextLine(); //used to get the input string that was skipped of the scanner object

        //Getting the user's choice and giving notification about selected cleaning mode
        if (input.equalsIgnoreCase("DAILY CLEAN")) {
            cleaningMode = "DAILY CLEAN";
            System.out.println("DAILY CLEAN HAS CHOSEN BY USER");
        } else if (input.equalsIgnoreCase("DEEP CLEAN")) {
            cleaningMode = "DEEP CLEAN";
            System.out.println("DEEP CLEAN HAS CHOSEN BY USER");
        } else if (input.equalsIgnoreCase("SENSITIVE CLEAN")) {
            cleaningMode = "SENSITIVE CLEAN";
            System.out.println("SENSITIVE CLEAN HAS CHOSEN BY USER");
        } else if (input.equalsIgnoreCase("WHITENING")) {
            cleaningMode = "WHITENING";
            System.out.println("WHITENING CLEAN HAS CHOSEN BY USER");
        }
    }

    //Notifies the user about the cleaning has begun
    public void cleaningStarts() {
        System.out.println("Your teeth cleaning is started!");
    }

    //This method will choose a value by randomly and then it will give a notify based on chosen pressure type
    public void pressureToTeethSensor() {
        final String[] pressure = {"little", "normal", "much"};//Values to get chosen by randomly
        Random random = new Random();
        int index = random.nextInt(pressure.length);

        //Getting a random value and giving notify based on the index of random value
        switch (pressure[index]) {
            case "little" -> System.out.println("Pressure Sensor Notify: Your brushing pressure on teeth is fine!");
            case "normal" -> System.out.println("Pressure Sensor Notify: Your brushing pressure on teeth is fine!");
            case "much" -> System.out.println("Pressure Sensor Notify: WARNING!Please decrease brushing pressure on your teeth!");
        }
    }

    //Notifies the user about the cleaning has finished
    public void cleaningFinishes() {
        System.out.println("Your teeth cleaning is finished!");
        //Function starts to work at the same time with this method and end of the process, prints remaining battery
        consumeBattery();
    }

}
