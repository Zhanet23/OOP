package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class GetSublins extends Command {

    public GetSublins(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "дать информацию о братьях/сестрах объекта по его ID";

    }

    @Override
    public void action() {
        getConsoleUI().getSublinsByIDObject();
    }
}
