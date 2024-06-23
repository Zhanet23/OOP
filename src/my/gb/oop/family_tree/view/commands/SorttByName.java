package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class SorttByName extends Command{
    public SorttByName(View viewer) {
        super(viewer);
        description = "отсортировать по имени";
    }

    @Override
    public void action() {
        getConsoleUI().sortByName();
    }
}
