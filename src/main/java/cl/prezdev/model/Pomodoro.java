package cl.prezdev.model;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Getter @Setter
public class Pomodoro extends Thread{
    private int minutes;
    private String activity;
    private PomodoroPrintable pomodoroPrintable;

    public Pomodoro(PomodoroPrintable pomodoroPrintable){
        this(pomodoroPrintable, Config.DEFAULT_POMODORO_ACTIVITY);
    }

    public Pomodoro(PomodoroPrintable pomodoroPrintable, int minutes){
        this(pomodoroPrintable, Config.DEFAULT_POMODORO_ACTIVITY);
        this.minutes = minutes;
    }

    public Pomodoro(PomodoroPrintable pomodoroPrintable, String activity) {
        this.minutes = Config.DEFAULT_POMODORO_MINUTES;
        this.activity = activity;
        this.pomodoroPrintable = pomodoroPrintable;
    }

    @Override
    @SneakyThrows
    public void run() {
        pomodoroPrintable.printPomodoroTimer(this.minutes, 0);
        Thread.sleep(1000);
        this.minutes--;

        for(int minute = this.minutes; minute >= 0 ; minute--){
            for(int second = 59; second >= 0  ; second--){
                pomodoroPrintable.printPomodoroTimer(minute, second);
                Thread.sleep(1000);
            }
        }
    }
}
