package my.gb.oop.family_tree.view.commands;


import my.gb.oop.family_tree.view.View;


public class AddObject extends Command{
    public AddObject(View viewer) {

        super(viewer);

        description = "добавить объект в дерево";
    }

    @Override
    public void action() {getConsoleUI().addObject();}

}
