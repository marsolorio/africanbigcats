package com.africanbigcats;

import java.util.LinkedList;

/*
 * Main application class for the African Big Cats app.
 * This class initializes the menu and handles the command loop.
 */
public class App {
    public static void main(String[] args) {
        Menu appMenu = new Menu();
        LinkedList<Panthera> catList = new LinkedList<>();
        Character command = '_';

        // Loop until the user chooses to quit
        while (command != 'q') {
            appMenu.print();
            System.out.print("Enter a command: ");
            command = appMenu.getCommand();
            appMenu.executeCommand(command, catList);
            appMenu.update(catList);
        }
    }
}
