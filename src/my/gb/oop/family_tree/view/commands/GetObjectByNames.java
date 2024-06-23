package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.View;

public class GetObjectByNames extends Command{

    public GetObjectByNames(View viewer) {
        super(viewer);
        description = "дать полную информацию об объекте по его names";
    }

    @Override
    public void action() {
        getConsoleUI().getObjectByNames();
    }



}
