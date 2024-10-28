package com.africanbigcats;

import java.util.*;

public class Menu {
    private Scanner input;

    public Menu() {
        this.input = new Scanner(System.in);
    }

    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();
        printCommand('c', "[C]reate a big cat");
        printCommand('l', "[L]ist all big cats");
        printCommand('f', "[F]ind a cat by name");
        printCommand('d', "[D]elete a cat by name");
        printCommand('q', "[Q]uit");
        printLine();
    }

    private static void printLine() {
        System.out.println("----------------------------------------------------------");
    }

    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    public Character getCommand() {
        String rawInput = input.nextLine();
        return (rawInput.length() > 0) ? rawInput.toLowerCase().charAt(0) : '_';
    }

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
            case 'q':
                executeQuit();
                return false;
            default:
                System.out.println("ERROR: Unknown command");
                return false;
        }
        return true;
    }

    public void update(LinkedList<Panthera> catList) {
        for (Panthera cat : catList) {
            cat.move();
        }
    }

    private void executeQuit() {
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();
    }

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

    private void executeFind(LinkedList<Panthera> catList) {
        System.out.print("Enter name or part of name to find: ");
        String namePart = input.nextLine().trim().toLowerCase();

        catList.stream()
                .filter(cat -> cat.name().toLowerCase().contains(namePart))
                .forEach(System.out::println);
    }

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
}
