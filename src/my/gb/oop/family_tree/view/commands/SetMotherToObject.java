package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.View;

public class SetMotherToObject extends Command{
    public SetMotherToObject(View viewer) {
        super(viewer);
        description = "ввести информацию о матери объекта по его ID";
    }

    @Override
    public void action() {
        getConsoleUI().setMotherToObject();
    }
}
