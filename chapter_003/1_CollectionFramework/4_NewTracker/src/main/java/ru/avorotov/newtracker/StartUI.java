package ru.avorotov.newtracker;

/**
 * Start UI.
 */
public class StartUI {

    /**
     * Ввод/вывод.
     */
    private IInput input;

    /**
     * Tracker.
     */
    private ITracker tracker;

    /**
     * Конструктор.
     * @param input Ввод/вывод.
     * @param tracker Tracker.
     */
    StartUI(IInput input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Старт выполнения программы.
     */
    public void start() {
        MenuTracker menuTracker = new MenuTracker(this.input, tracker);
        do {
            menuTracker.show();
            int menuKey = input.ask("Выберите, пожалуйста, пункт меню: ", menuTracker.getExistKeysAction());
            menuTracker.select(menuKey);
        } while (!this.input.askBoolean("Выйти?(да) "));
    }

    /**
     * Запуск программы.
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).start();
    }
}
