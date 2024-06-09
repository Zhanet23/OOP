package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class AddObject extends Command{

    public AddObject(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "добавить объект в дерево";
    }

    @Override
    public void action() {
        getConsoleUI().addObject();
    }
}
