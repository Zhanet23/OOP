package my.gb.oop.family_tree;

import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.ConsoleUI_ext;
import my.gb.oop.family_tree.view.DeskTop;
import my.gb.oop.family_tree.view.View;

public class Main {
    public static void main(String[] args) {

        //View v = new DeskTop();
        //View v = new ConsoleUI();
        View v = new ConsoleUI_ext();
        v.start();

    }
}

