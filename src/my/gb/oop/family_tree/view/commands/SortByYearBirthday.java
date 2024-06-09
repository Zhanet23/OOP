package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class SortByYearBirthday extends Command{
    public SortByYearBirthday(ConsoleUI consoleUI) {
        super(consoleUI);
        description = ("отсортировать по году рождения");
    }

    @Override
    public void action() {
        getConsoleUI().sortByYearBirthday();
    }
}
