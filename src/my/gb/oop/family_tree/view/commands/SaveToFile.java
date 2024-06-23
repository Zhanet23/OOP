package my.gb.oop.family_tree.view.commands;


//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class SaveToFile extends Command{

    public SaveToFile(View viewer) {
        super(viewer);
        description = "записать информацию в файл";
    }

    @Override
    public void action() {
        getConsoleUI().saveToFile();
    }
}
