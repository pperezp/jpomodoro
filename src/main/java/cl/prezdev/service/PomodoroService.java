package cl.prezdev.service;

import cl.prezdev.model.pomodoro.AbstractPomodoro;
import cl.prezdev.model.pomodoro.types.PomodoroImpl;
import cl.prezdev.model.pomodoro.PomodoroEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PomodoroService {

    private static final Logger LOGGER = Logger.getLogger(PomodoroService.class.toString());

    private PomodoroService(){
        throw new IllegalStateException("Utility class");
    }

    private static AbstractPomodoro abstractPomodoro;

    public static void tryToCreatePomodoro(PomodoroEvent pomodoroEvent) {
        tryToStartPomodoro(new PomodoroImpl(pomodoroEvent));
    }

    public static void tryToStartPomodoro(AbstractPomodoro abstractPomodoro) {
        if(canCreatePomodoro()){
            createAndLunchPomodoro(abstractPomodoro);
        }else{
            String info = PomodoroService.abstractPomodoro.info();
            LOGGER.log(Level.INFO, "Thread is alive! : info(): {0}", info);
        }
    }

    private static boolean canCreatePomodoro() {
        return pomodoroExist() || !pomodoroIsAlive();
    }

    private static boolean pomodoroIsAlive() {
        return PomodoroService.abstractPomodoro.isAlive();
    }

    private static boolean pomodoroExist() {
        return PomodoroService.abstractPomodoro == null;
    }

    private static void createAndLunchPomodoro(AbstractPomodoro abstractPomodoro) {
        PomodoroService.abstractPomodoro = abstractPomodoro;
        PomodoroService.abstractPomodoro.start();
    }
}
