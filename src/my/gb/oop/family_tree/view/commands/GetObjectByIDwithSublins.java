package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class GetObjectByIDwithSublins extends Command{

    public GetObjectByIDwithSublins(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "дать полную информацию об объекте (в т.ч. о сестрах/братьях) по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().getObjectByID_withSublins();
    }

}

