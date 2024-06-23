package my.gb.oop.family_tree.view;

import my.gb.oop.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandlist;
    public MainMenu(View view){

        commandlist = new ArrayList<>();

        commandlist.add(new GetTreeInfo(view));
        commandlist.add(new GetObjectByID(view));
        commandlist.add(new GetObjectByNames(view));
        commandlist.add(new GetObjectByIDwithSublins(view));
        commandlist.add(new SorttByName(view));
        commandlist.add(new SortByAge(view));
        commandlist.add(new SortByYearBirthday(view));
        commandlist.add(new GetParentsByIDChild(view));
        commandlist.add(new GetChildrenByIDParent(view));
        commandlist.add(new GetSublins(view));
        commandlist.add(new AddObject(view));
        commandlist.add(new GetTreeFromHear(view));
        commandlist.add(new ExtractFromFile(view));
        commandlist.add(new SaveToFile(view));
        commandlist.add(new CreateNewTree(view));
        commandlist.add(new Finish(view));
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
