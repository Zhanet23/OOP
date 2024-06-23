package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class GetParentsByIDChild extends Command {

    public GetParentsByIDChild(View viewer) {
        super(viewer);
        description = "дать информацию о родителях объекта по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().getParentsByIDChild();
    }
}


