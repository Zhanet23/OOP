package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.model.Family_Tree.Family_tree;
import my.gb.oop.family_tree.model.Human.Human;
import my.gb.oop.family_tree.view.ConsoleUI;

public class SaveToFile extends Command{

    public SaveToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "записать информацию в файл";
    }

    @Override
    public void action() {
        getConsoleUI().saveToFile();
    }
}
