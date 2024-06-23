package my.gb.oop.family_tree.view.commands;

//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class GetObjectByIDwithSublins extends Command{

    public GetObjectByIDwithSublins(View viewer) {
        super(viewer);
        description = "дать полную информацию об объекте (в т.ч. о сестрах/братьях) по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().getObjectByID_withSublins();
    }

}

