package cl.prezdev;

import cl.prezdev.listeners.LabelPomodoroMouseListener;
import cl.prezdev.model.PomodoroPrintable;
import cl.prezdev.model.Util;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter @Setter
public class MainFrame implements PomodoroPrintable {
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


}
