package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class GetParentsByIDChild extends Command {

    public GetParentsByIDChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "дать информацию о родителях объекта по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().getParentsByIDChild();
    }
}


