package cl.prezdev.model.config.theme;

import java.awt.*;

public class LightTheme implements Theme{
    @Override
    public ThemeName getThemeName() {
        return ThemeName.LIGHT;
    }

    @Override
    public Color getNormalPomodoroForeground() {
        return Color.RED;
    }

    @Override
    public Color getBreakPomodoroForeground() {
        return Color.GREEN;
    }

    @Override
    public Color getPanelBackground() {
        return Color.WHITE;
    }
}
