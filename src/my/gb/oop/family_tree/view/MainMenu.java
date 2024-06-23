package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandlist;
    public MainMenu(ConsoleUI consoleUI){

        commandlist = new ArrayList<>();

        commandlist.add(new GetTreeInfo(consoleUI));
        commandlist.add(new GetObjectByID(consoleUI));
        commandlist.add(new GetObjectByIDwithSublins(consoleUI));
        commandlist.add(new SorttByName(consoleUI));
        commandlist.add(new SortByAge(consoleUI));
        commandlist.add(new SortByYearBirthday(consoleUI));
        commandlist.add(new GetParentsByIDChild(consoleUI));
        commandlist.add(new GetChildrenByIDParent(consoleUI));
        commandlist.add(new GetSublins(consoleUI));
        commandlist.add(new AddObject(consoleUI));
        commandlist.add(new GetTreeFromHear(consoleUI));
        commandlist.add(new ExtractFromFile(consoleUI));
        commandlist.add(new SaveToFile(consoleUI));
        commandlist.add(new CreateNewTree(consoleUI));
        commandlist.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < commandlist.size(); k++){
            sb.append(k+1).append(". ").append(commandlist.get(k).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void action (int choice){
        Command command = commandlist.get(choice - 1);
        command.action();
    }
    public int getSize(){
        return commandlist.size();
    }


}
