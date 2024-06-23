package my.gb.oop.family_tree.view.commands;


//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class GetTreeInfo extends Command{
    public GetTreeInfo(View viewer) {
          super(viewer);
          description = "дать полную информацию о дереве";
    }

    @Override
    public void action() {
         getConsoleUI().getTreeInfo();
    }
}
