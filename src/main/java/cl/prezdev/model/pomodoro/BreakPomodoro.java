package cl.prezdev.model.pomodoro;

import cl.prezdev.model.config.Config;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BreakPomodoro extends AbstractPomodoro{

    public BreakPomodoro(PomodoroEvent pomodoroEvent) {
        super(Config.Break.minutes, Config.Break.activity, pomodoroEvent);
    }

}
