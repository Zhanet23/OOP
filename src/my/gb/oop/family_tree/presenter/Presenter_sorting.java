package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.view.View;

public class Presenter_sorting extends Presenter_getTree{
    public Presenter_sorting(View v) {
        super(v);
    }
    public void sortByYearBirthday (){
        String info = service.sortByYearBirthday().toString();
        v.printAnswer(info);
    }
    public void sortByName (){
        String info = service.sortByName().toString();
        v.printAnswer(info);
    }
    public void sortByAge (){
        String info = service.sortByAge().toString();
        v.printAnswer(info);
    }
}
