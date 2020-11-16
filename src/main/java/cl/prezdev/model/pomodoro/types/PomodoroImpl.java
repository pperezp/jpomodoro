package cl.prezdev.model.pomodoro.types;

import cl.prezdev.model.config.Config;
import cl.prezdev.model.pomodoro.AbstractPomodoro;
import cl.prezdev.model.pomodoro.PomodoroEvent;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PomodoroImpl extends AbstractPomodoro {

    public PomodoroImpl(PomodoroEvent pomodoroEvent) {
        super(Config.Pomodoro.minutes, Config.Pomodoro.activity, pomodoroEvent);
    }
}
