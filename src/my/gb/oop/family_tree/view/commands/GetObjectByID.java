package my.gb.oop.family_tree.view.commands;
//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class GetObjectByID extends Command{

    public GetObjectByID(View viewer) {
        super(viewer);
        description = "дать полную информацию об объекте по его ID";
    }

    @Override
    public void action() {
       getConsoleUI().getObjectByID();
    }



}
