package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class GetTreeInfo extends Command{
    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "дать полную информацию о дереве";
    }

    @Override
    public void action() {

         getConsoleUI().getTreeInfo();
    }
}
