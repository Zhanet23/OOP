package my.gb.oop.family_tree.view.commands;
//import my.gb.oop.family_tree.view.ConsoleUI;
import my.gb.oop.family_tree.view.View;

public class Finish extends Command{

    public Finish(View viewer) {

          super(viewer);
          description = "Закончить работу";
    }

    @Override
    public void action() {getConsoleUI().finish();}

}
