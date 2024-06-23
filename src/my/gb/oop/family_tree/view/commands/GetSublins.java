package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class GetSublins extends Command {

    public GetSublins(View viewer) {
        super(viewer);
        description = "дать информацию о братьях/сестрах объекта по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().getSublinsByIDObject();
    }
}
