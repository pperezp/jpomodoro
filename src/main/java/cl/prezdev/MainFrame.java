package cl.prezdev;

import cl.prezdev.model.config.Config;
import cl.prezdev.model.config.theme.themes.Theme;
import cl.prezdev.model.pomodoro.types.BreakPomodoroImpl;
import cl.prezdev.model.pomodoro.types.PomodoroImpl;
import cl.prezdev.view.listeners.LabelPomodoroMouseListener;
import cl.prezdev.model.pomodoro.AbstractPomodoro;
import cl.prezdev.model.pomodoro.PomodoroEvent;
import cl.prezdev.model.util.Util;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter @Setter
public class MainFrame implements PomodoroEvent {
    private JPanel containerPanel;
    private JLabel pomodoroLabel;
    private Theme theme;

    public MainFrame(){
        theme = Config.DEFAULT_THEME;
        pomodoroLabel.addMouseListener(new LabelPomodoroMouseListener(this));
        pomodoroLabel.setText("Start!");
        containerPanel.setBackground(theme.getPanelBackground());
    }

    @Override
    public void preStartPomodoro(AbstractPomodoro abstractPomodoro) {
        if(abstractPomodoro instanceof PomodoroImpl){
            pomodoroLabel.setForeground(theme.getNormalPomodoroForeground());
        }else if(abstractPomodoro instanceof BreakPomodoroImpl){
            pomodoroLabel.setForeground(theme.getBreakPomodoroForeground());
        }
    }

    @Override
    public void printPomodoroTimer(int minute, int second) {
        String formatMinute = Util.format(minute);
        String formatSecond = Util.format(second);

        pomodoroLabel.setText(formatMinute + ":" + formatSecond);
    }

    @Override
    public void pomodoroFinished(AbstractPomodoro pomodoroImpl) {
        JOptionPane.showMessageDialog(null,"Pomodoro terminado");
    }
}
