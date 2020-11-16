package cl.prezdev.model.config.theme.themes;

import cl.prezdev.model.config.theme.ThemeName;

import java.awt.*;

public class DarkTheme implements Theme{
    @Override
    public ThemeName getThemeName() {
        return ThemeName.DARK;
    }

    @Override
    public Color getNormalPomodoroForeground() {
        return Color.decode("#C14A36");
    }

    @Override
    public Color getBreakPomodoroForeground() {
        return Color.decode("#36C138");
    }

    @Override
    public Color getPanelBackground() {
        return Color.decode("#3C3E40");
    }
}
