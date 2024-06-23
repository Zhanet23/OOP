package my.gb.oop.family_tree.view.commands;
import my.gb.oop.family_tree.view.ConsoleUI;
public class Finish extends Command{

    public Finish(ConsoleUI consoleUI) {

          super(consoleUI);
          description = "Закончить работу";
    }

    @Override
    public void action() {getConsoleUI().finish();}

}
