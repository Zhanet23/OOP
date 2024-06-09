package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = ("отсортировать по возрасту");
    }

    @Override
    public void action() {
        getConsoleUI().sortByAge();
    }
}
