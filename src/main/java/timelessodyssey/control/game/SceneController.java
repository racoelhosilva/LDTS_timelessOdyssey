package timelessodyssey.control.game;

import timelessodyssey.Game;
import timelessodyssey.control.Controller;
import timelessodyssey.gui.GUI;
import timelessodyssey.model.game.scene.Scene;

import static timelessodyssey.gui.GUI.Action.QUIT;

public class SceneController extends Controller<Scene> {
    private final PlayerController playerController;

    public SceneController(Scene scene, PlayerController playerController) {
        super(scene);
        this.playerController = playerController;
    }

    @Override
    public void step(Game game, GUI gui, GUI.Action action, long time) {
        if (action == QUIT)
            game.setState(null);
        else
            playerController.step(game, gui, action, time);
    }
}
