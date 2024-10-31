package com.africanbigcats;

import java.util.*;

/*
 * The Menu class provides a text-based interface for managing African big cats.
 * It supports various commands such as creating, listing, finding, deleting cats, 
 * and generating risk and warning reports.
 */
public class Menu {
    private Scanner input;

    /*
     * Constructor for Menu.
     * Initializes the Scanner for user input.
     */
    public Menu() {
        this.input = new Scanner(System.in);
    }

    /*
     * Prints the main menu options.
     */
    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();
        printCommand('c', "[C]reate a big cat");
        printCommand('l', "[L]ist all big cats");
        printCommand('f', "[F]ind a cat by name");
        printCommand('d', "[D]elete a cat by name");
        printCommand('r', "[R]isk report between two cats");
        printCommand('w', "[W]arning report for user location");
        printCommand('q', "[Q]uit");
        printLine();
    }

    /*
     * Prints a line separator.
     */
    private static void printLine() {
        System.out.println("----------------------------------------------------------");
    }

    /*
     * Prints a menu command with its description.
     */
    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    /*
     * Reads a command from the user.
     * Returns the first character of the input as a command.
     */
    public Character getCommand() {
        String rawInput = input.nextLine();
        return (rawInput.length() > 0) ? rawInput.toLowerCase().charAt(0) : '_';
    }

    /*
     * Executes the command based on the user's choice.
     */
    public Boolean executeCommand(Character command, LinkedList<Panthera> catList) {
        switch (command) {
            case 'c':
                executeCreate(catList);
                break;
            case 'l':
                executeList(catList);
                break;
            case 'f':
                executeFind(catList);
                break;
            case 'd':
                executeDelete(catList);
                break;
            case 'r':
                executeRiskReport(catList);
                break;
            case 'w':
                executeWarningReport(catList);
                break;
            case 'q':
                executeQuit();
                return false;
            default:
                System.out.println("ERROR: Unknown command");
                return false;
        }
        return true;
    }

    /*
     * Updates the positions of all cats in the list.
     */
    public void update(LinkedList<Panthera> catList) {
        for (Panthera cat : catList) {
            cat.move();
        }
    }

    /*
     * Quits the application and closes the Scanner.
     */
    private void executeQuit() {
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();
    }

    /*
     * Prompts user to select a cat species and creates the appropriate type of
     * Panthera.
     * Returns the created Panthera object.
     */
    public Panthera getNewCat(String name) {
        System.out.print("Select cat species (Tiger, Lion, Jaguar): ");
        String species = input.nextLine().trim().toLowerCase();

        switch (species) {
            case "tiger":
                return new Tiger(name);
            case "lion":
                return new Lion(name);
            case "jaguar":
                return new Jaguar(name);
            default:
                System.out.println("Unknown species. Defaulting to Tiger.");
                return new Tiger(name);
        }
    }

    /*
     * Creates a new cat with a unique name and adds it to the list.
     */
    public void executeCreate(LinkedList<Panthera> catList) {
        System.out.print("Enter a name for the big cat to create: ");
        String name = input.nextLine().trim();

        if (catList.stream().anyMatch(cat -> cat.name().equalsIgnoreCase(name))) {
            System.out.println("ERROR: A cat with this name already exists.");
            return;
        }

        Panthera cat = getNewCat(name);
        catList.add(cat);
        System.out.println("Created cat: " + cat);
    }

    /*
     * Lists all big cats in the list.
     */
    public void executeList(LinkedList<Panthera> catList) {
        System.out.println();
        printLine();
        System.out.println("African Big Cat List");
        printLine();

        if (catList.isEmpty()) {
            System.out.println("There are no African Big Cats. :(");
        } else {
            catList.forEach(cat -> System.out.println(cat));
        }

        System.out.println();
    }

    /*
     * Finds and prints all cats matching the user's input.
     */
    private void executeFind(LinkedList<Panthera> catList) {
        System.out.print("Enter name or part of name to find: ");
        String namePart = input.nextLine().trim().toLowerCase();

        catList.stream()
                .filter(cat -> cat.name().toLowerCase().contains(namePart))
                .forEach(System.out::println);
    }

    /*
     * Deletes a cat by name from the list.
     */
    private void executeDelete(LinkedList<Panthera> catList) {
        System.out.print("Enter the name of the cat to delete: ");
        String name = input.nextLine().trim();

        Optional<Panthera> catToRemove = catList.stream()
                .filter(cat -> cat.name().equalsIgnoreCase(name))
                .findFirst();

        if (catToRemove.isPresent()) {
            catList.remove(catToRemove.get());
            System.out.println("Deleted cat: " + name);
        } else {
            System.out.println("ERROR: Cat with name " + name + " not found.");
        }
    }

    /*
     * Calculates and prints the distance between two specified cats.
     */
    public void executeRiskReport(LinkedList<Panthera> catList) {
        System.out.print("Enter the name of the first cat: ");
        String name1 = input.nextLine().trim();
        System.out.print("Enter the name of the second cat: ");
        String name2 = input.nextLine().trim();

        Panthera cat1 = catList.stream().filter(cat -> cat.name().equalsIgnoreCase(name1)).findFirst().orElse(null);
        Panthera cat2 = catList.stream().filter(cat -> cat.name().equalsIgnoreCase(name2)).findFirst().orElse(null);

        if (cat1 != null && cat2 != null) {
            double distance = Math.sqrt(
                    Math.pow(cat1.longitude() - cat2.longitude(), 2) + Math.pow(cat1.latitude() - cat2.latitude(), 2));
            System.out.println("Distance between " + name1 + " and " + name2 + " is " + distance);
        } else {
            System.out.println("One or both cats not found.");
        }
    }

    /*
     * Finds and prints the closest cat to the user's specified location.
     */
    public void executeWarningReport(LinkedList<Panthera> catList) {
        System.out.print("Enter your longitude: ");
        float userLongitude = Float.parseFloat(input.nextLine());
        System.out.print("Enter your latitude: ");
        float userLatitude = Float.parseFloat(input.nextLine());

        Panthera closestCat = catList.stream()
                .min(Comparator.comparingDouble(cat -> Math.sqrt(
                        Math.pow(cat.longitude() - userLongitude, 2) + Math.pow(cat.latitude() - userLatitude, 2))))
                .orElse(null);

        if (closestCat != null) {
            System.out.println("Closest cat to your location: " + closestCat);
        } else {
            System.out.println("No cats available.");
        }
    }
}
