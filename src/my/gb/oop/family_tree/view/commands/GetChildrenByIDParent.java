package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class GetChildrenByIDParent extends Command {

    public GetChildrenByIDParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "дать информацию о детях объекта по его ID";

    }

    @Override
    public void action() {
        getConsoleUI().getChildrenByIDParent();
    }
}
