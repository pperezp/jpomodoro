package cl.prezdev.model.pomodoro;

import cl.prezdev.model.config.Config;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pomodoro extends AbstractPomodoro{

    public Pomodoro(PomodoroEvent pomodoroEvent) {
        super(Config.Pomodoro.minutes, Config.Pomodoro.activity, pomodoroEvent);
    }

}
