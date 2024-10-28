package com.africanbigcats;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        Menu appMenu = new Menu();
        Character command = '_';
        LinkedList<Panthera> catList = new LinkedList<>();

        while (command != 'q') {
            appMenu.print();
            System.out.print("Enter a command: ");
            command = appMenu.getCommand();
            appMenu.executeCommand(command, catList);
            appMenu.update(catList);
        }
    }
}
