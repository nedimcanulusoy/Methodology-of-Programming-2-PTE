/*
 * ToothBrush project for Methodology of Programming Course
 * Purpose of this project was adding some smart features to a basic toothbrush via using java language
 * Written by Nedim Can Ulusoy
 * NEPTUN CODE: HUUMCJ
 * DATE: 2020-10-05 -> Updated to the OOP
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ToothBrush implements Serializable {
    private boolean isWorking = false; //Default Off
    private CleaningSpeed cleaningSpeed = CleaningSpeed.NORMAL; //Default speed
    private CleaningMode cleaningMode = CleaningMode.DAILY; //Default mode
    private User user; //User variable
    private Battery battery = new Battery(); //Battery
    private Sensor sensor = new Sensor(); //Sensor

    public ToothBrush() {
        // calling methods on this block
        onOff();
        makeUser();
        cleaningMode();
        cleaningSpeed();
        cleaningStarts();
        pressureToTeethSensor();
        cleaningFinishes();

        System.out.println("Remaining Battery = " + battery.getPercentage());
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

    //Takes the user's name and welcomes
    public void makeUser() {
        System.out.println("Enter your profile name: ");
        Scanner getInput = new Scanner(System.in); //Getting user's input
        String name = getInput.nextLine(); //Getting user's profile name from user input

        user = new User(name);
        System.out.println("Welcome " + user.getName().toUpperCase() + "!"); //Returns an output with gotten user's input
    }

    //User is able to choose the cleaning speed via this method
    public void cleaningSpeed() {
        System.out.println("Choose your cleaning speed (SLOW / NORMAL / FAST): ");
        Scanner getInput = new Scanner(System.in); //Getting user's input
        String input = getInput.nextLine(); //used to get the input string that was skipped of the scanner object

        //Getting the user's choice and giving notification about selected cleaning speed
        if (input.equalsIgnoreCase(CleaningSpeed.SLOW.toString())) {
            cleaningSpeed = CleaningSpeed.SLOW;
            System.out.println("SLOW CLEANING MOD IS ACTIVATED");
        } else if (input.equalsIgnoreCase(CleaningSpeed.NORMAL.toString())) {
            cleaningSpeed = CleaningSpeed.NORMAL;
            System.out.println("NORMAL CLEANING MOD IS ACTIVATED");
        } else if (input.equalsIgnoreCase(CleaningSpeed.FAST.toString())) {
            cleaningSpeed = CleaningSpeed.FAST;
            System.out.println("FAST CLEANING MOD IS ACTIVATED");
        }
    }

    //User is able to choose the cleaning mode via this method
    public void cleaningMode() {
        System.out.println("Choose your cleaning mode (DAILY / DEEP / SENSITIVE / WHITENING): ");
        Scanner getInput = new Scanner(System.in); //Getting user's input
        String input = getInput.nextLine(); //used to get the input string that was skipped of the scanner object

        //Getting the user's choice and giving notification about selected cleaning mode
        if (input.equalsIgnoreCase(CleaningMode.DAILY.toString())) {
            cleaningMode = CleaningMode.DAILY;
            System.out.println("DAILY CLEAN HAS CHOSEN BY " + user.getName().toUpperCase());
        } else if (input.equalsIgnoreCase(CleaningMode.DEEP.toString())) {
            cleaningMode = CleaningMode.DEEP;
            System.out.println("DEEP CLEAN HAS CHOSEN BY " + user.getName().toUpperCase());
        } else if (input.equalsIgnoreCase(CleaningMode.SENSITIVE.toString())) {
            cleaningMode = CleaningMode.SENSITIVE;
            System.out.println("SENSITIVE CLEAN HAS CHOSEN BY " + user.getName().toUpperCase());
        } else if (input.equalsIgnoreCase(CleaningMode.WHITENING.toString())) {
            cleaningMode = CleaningMode.WHITENING;
            System.out.println("WHITENING CLEAN HAS CHOSEN BY " + user.getName().toUpperCase());
        }
    }

    //Notifies the user about the cleaning has begun with current time stamp
    public void cleaningStarts() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Your teeth cleaning is started at " + dtf.format(now) + "!");
    }

    //This method will choose a value by randomly and then it will give a notify based on chosen pressure type
    public void pressureToTeethSensor() {

        //Getting a random value and giving notify based on the index of random value
        if (sensor.getPressure() == Pressure.LITTLE) {
            System.out.println("Pressure Sensor Notify: Your brushing pressure on teeth is fine!");
        } else if (sensor.getPressure() == Pressure.NORMAL) {
            System.out.println("Pressure Sensor Notify: Your brushing pressure on teeth is fine!");
        } else if (sensor.getPressure() == Pressure.MUCH) {
            System.out.println("Pressure Sensor Notify: WARNING! Please decrease brushing pressure on your teeth!");
        }
    }

    //Notifies the user about the cleaning has finished
    public void cleaningFinishes() {
        System.out.println("Your teeth cleaning is finished!");
        //Function starts to work at the same time with this method and end of the process, prints remaining battery
        battery.consume();
    }

}
