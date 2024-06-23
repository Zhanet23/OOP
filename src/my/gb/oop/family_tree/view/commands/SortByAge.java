package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class SortByAge extends Command{
    public SortByAge(View viewer) {
        super(viewer);
        description = ("отсортировать по возрасту");
    }

    @Override
    public void action() {
        getConsoleUI().sortByAge();
    }
}
