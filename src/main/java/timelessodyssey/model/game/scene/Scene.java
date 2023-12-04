package timelessodyssey.model.game.scene;

import timelessodyssey.model.Position;
import timelessodyssey.model.game.elements.Player;
import timelessodyssey.model.game.elements.Tile;
import timelessodyssey.model.game.elements.Spike;

import javax.management.loading.ClassLoaderRepository;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private final int width;
    private final int height;
    private final int sceneCode;

    private Player player;
    private List<Tile> tiles;
    private List<Spike> spikes;
    private Position winningPosition;

    public Scene(int width, int height, int sceneCode) {
        this.width = width;
        this.height = height;
        this.sceneCode = sceneCode;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSceneCode() {
        return sceneCode;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public List<Spike> getSpikes() {
        return spikes;
    }

    public void setSpikes(List<Spike> spikes) {
        this.spikes = spikes;
    }

    public Position getWinningPosition() {
        return winningPosition;
    }

    public void setWinningPosition(Position winningPosition) {
        this.winningPosition = winningPosition;
    }

    public boolean isEmpty(Position position) {
        for (Tile tile : tiles) {
            for (int w = 0; w < 8; w++) {
                Position pos1 = new Position(tile.getPosition().x() + w, tile.getPosition().y());
                Position pos2 = new Position(tile.getPosition().x() + w, tile.getPosition().y() + 7);
                if (pos1.equals(position)) {
                    return false;
                }
                if (pos2.equals(position)) {
                    return false;
                }
            }
            for (int h = 0; h < 8; h++) {
                Position pos1 = new Position(tile.getPosition().x(), tile.getPosition().y() + h);
                Position pos2 = new Position(tile.getPosition().x() + 7, tile.getPosition().y() + h);
                if (pos1.equals(position)) {
                    return false;
                }
                if (pos2.equals(position)) {
                    return false;
                }
            }
        }
        return true;
    }
}
