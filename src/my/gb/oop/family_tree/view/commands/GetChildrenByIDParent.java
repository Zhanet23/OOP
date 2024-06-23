package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class GetChildrenByIDParent extends Command {

    public GetChildrenByIDParent(View viewer) {
        super(viewer);
        description = "дать информацию о детях объекта по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().getChildrenByIDParent();
    }
}
