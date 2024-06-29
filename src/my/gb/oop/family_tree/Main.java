package my.gb.oop.family_tree;

import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class Main {
    public static void main(String[] args) {

        //View v = new DeskTop();
        View v = new ConsoleUI();
        v.start();

    }
}

