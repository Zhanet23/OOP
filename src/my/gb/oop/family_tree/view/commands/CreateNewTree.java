package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class CreateNewTree extends Command{

    public CreateNewTree(View viewer) {
        super(viewer);
        description = "создать новое дерево";
    }

    @Override
    public void action() {
        getConsoleUI().getNewTree();
    }
}
