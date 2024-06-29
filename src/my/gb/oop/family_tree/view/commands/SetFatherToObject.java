package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.View;

public class SetFatherToObject extends Command{
    public SetFatherToObject(View viewer) {
        super(viewer);
        description = "ввести информацию об отце объекта по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().setFatherToObject();
    }
}
