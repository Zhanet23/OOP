package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.ConsoleUI;

public class GetTreeFromHear extends Command{

    public GetTreeFromHear(ConsoleUI consoleUI) {
          super(consoleUI);
          description = "извлечь информацию из этой программы";
    }

    @Override
    public void action() {
        getConsoleUI().getTreeFromHear();
    }
}