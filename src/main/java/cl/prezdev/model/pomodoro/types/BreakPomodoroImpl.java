package cl.prezdev.model.pomodoro.types;

import cl.prezdev.model.config.Config;
import cl.prezdev.model.pomodoro.AbstractPomodoro;
import cl.prezdev.model.pomodoro.PomodoroEvent;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BreakPomodoroImpl extends AbstractPomodoro {

    public BreakPomodoroImpl(PomodoroEvent pomodoroEvent) {
        super(Config.Break.minutes, Config.Break.activity, pomodoroEvent);
    }
}
