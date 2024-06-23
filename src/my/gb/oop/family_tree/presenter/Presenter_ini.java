package my.gb.oop.family_tree.presenter;

import my.gb.oop.family_tree.model.Service.Service;
import my.gb.oop.family_tree.view.View;

public class Presenter_ini {
    protected View v;  protected Service service;

    public Presenter_ini(View v) {
        this.v = v;
        service = new Service();
    }
}
