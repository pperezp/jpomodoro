package cl.prezdev;

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

    public MainFrame(){
        pomodoroLabel.addMouseListener(new LabelPomodoroMouseListener(this));
    }

    @Override
    public void printPomodoroTimer(int minute, int second) {
        String formatMinute = Util.format(minute);
        String formatSecond = Util.format(second);

        pomodoroLabel.setText(formatMinute + ":" + formatSecond);
    }

    @Override
    public void pomodoroFinished(AbstractPomodoro pomodoroImpl) {

    }
}
