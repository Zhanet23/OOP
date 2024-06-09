package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.view.ConsoleUI;

public class FindObjectByID extends Command{

    public FindObjectByID(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "дать полную информацию об объекте по его ID";

    }

    @Override
    public void action() {
       getConsoleUI().findObjectByID();
    }



}
