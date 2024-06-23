package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class GetObjectByID extends Command{

    public GetObjectByID(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "дать полную информацию об объекте по его ID";

    }

    @Override
    public void action() {
       getConsoleUI().getObjectByID();
    }



}
