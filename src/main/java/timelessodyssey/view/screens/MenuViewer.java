package timelessodyssey.view.screens;

import com.googlecode.lanterna.TextColor;
import timelessodyssey.gui.GUI;
import timelessodyssey.model.menu.Entry;
import timelessodyssey.model.menu.Menu;
import timelessodyssey.view.menu.EntryViewer;

import java.io.IOException;
import java.util.List;

public class MenuViewer extends ScreenViewer<Menu> {
    private static final TextColor.RGB unselectedColor = new TextColor.RGB(234,234,234);
    private static final TextColor.RGB selectedColor = new TextColor.RGB(255,234,69);
    private static final TextColor.RGB backgroundColor = new TextColor.RGB(28, 28, 70);
    private static final TextColor.RGB frameColor = new TextColor.RGB(255, 255, 255);

    private final EntryViewer entryViewer;

    public MenuViewer(Menu model) throws IOException {
        super(model);
        this.entryViewer = new EntryViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawBackgroundAndFrame(gui);
        drawEntries(gui, getModel().getEntries());
        gui.refresh();
    }

    private void drawBackgroundAndFrame(GUI gui) {
        gui.drawRectangle(0, 0, gui.getWidth(), 1, frameColor);
        gui.drawRectangle(0, gui.getHeight() - 1, gui.getWidth(), 1, frameColor);
        gui.drawRectangle(0, 1, 1, gui.getHeight() - 2, frameColor);
        gui.drawRectangle(gui.getWidth() - 1, 1, 1, gui.getHeight() - 2, frameColor);
        gui.drawRectangle(1, 1, gui.getWidth() - 2, gui.getHeight() - 2, backgroundColor);
    }

    private void drawEntries(GUI gui, List<Entry> entries) throws IOException {
        for (int idx = 0; idx < entries.size(); idx++){
            entryViewer.draw(entries.get(idx), gui, getModel().isSelected(idx) ? selectedColor : unselectedColor);
        }
    }
}
