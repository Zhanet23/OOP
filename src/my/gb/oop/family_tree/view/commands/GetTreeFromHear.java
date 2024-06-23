package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class GetTreeFromHear extends Command{

    public GetTreeFromHear(View viewer) {
          super(viewer);
          description = "извлечь информацию из этой программы";
    }

    @Override
    public void action() {
        getConsoleUI().getTreeFromHear();
    }
}