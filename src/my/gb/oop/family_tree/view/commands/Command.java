package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.model.Family_Tree.FamilyTreeItem;
import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.view.ConsoleUI;

public abstract class Command {
    protected String description;
    private ConsoleUI consoleUI;
    private Family_tree ft;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }
     public String getDescription(){
        return description;
     }

     public abstract void action();

    //дефолтный модификатор - видимость только наследникам этого класса в пакете commands
     ConsoleUI getConsoleUI() {return consoleUI;}

    public Family_tree getFt() {
        return ft;
    }
}
