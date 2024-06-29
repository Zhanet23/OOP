package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.model.Service.Service;
import my.gb.oop.family_tree.view.View;
import my.gb.oop.family_tree.model.Service.WorkWithTreeInfo;

import java.time.LocalDate;

    public class Presenter extends Presenter_funcTree{

        public Presenter(View v) {
            super(v);
        }

    public void getObjectByNames(String name,String middleName,String secondName) {

        String info;
        if (service.getObjectByNames(name, middleName,secondName) != null) {
            info = service.getObjectByNames(name, middleName, secondName).toString();
        }
        else info = "Такого объекта нет в базе";
        v.printAnswer(info);
    }
}
