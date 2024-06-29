package my.gb.oop.family_tree.view.commands;

import my.gb.oop.family_tree.view.View;

public class SetSpouse extends Command{
    public SetSpouse(View viewer) {
        super(viewer);
        description = "установить супружеские связи";
    }

    @Override
    public void action() {
        getConsoleUI().setSpouse();
    }
}
