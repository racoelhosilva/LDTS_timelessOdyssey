package timelessodyssey.states;

import timelessodyssey.control.Controller;
import timelessodyssey.control.game.PlayerController;
import timelessodyssey.control.game.SceneController;
import timelessodyssey.control.menu.MenuController;
import timelessodyssey.model.menu.Menu;
import timelessodyssey.view.screens.GameViewer;
import timelessodyssey.view.screens.MenuViewer;
import timelessodyssey.view.screens.ScreenViewer;

public class MenuState extends State<Menu>{

    public MenuState(Menu model) { super(model);}

    @Override
    protected ScreenViewer<Menu> getScreenViewer() {
        return new MenuViewer(model);
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(model);
    }

}
