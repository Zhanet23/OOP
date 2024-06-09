package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class SorttByName extends Command{
    public SorttByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "отсортировать по имени";
    }

    @Override
    public void action() {
        getConsoleUI().sortByName();
    }
}
