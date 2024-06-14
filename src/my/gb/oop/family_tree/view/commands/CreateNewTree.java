package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class CreateNewTree extends Command{

    public CreateNewTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "создать новое дерево";
    }

    @Override
    public void action() {
        getConsoleUI().getNewTree();
    }
}
