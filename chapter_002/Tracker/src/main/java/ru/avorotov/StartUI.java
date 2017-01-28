package ru.avorotov;

/**
 * Start UI.
 */
public class StartUI {

    /**
     * Ввод/вывод.
     */
    private IInput input;

    /**
     * Конструктор.
     * @param input Ввод/вывод.
     */
    public StartUI(IInput input) {
        this.input = input;
    }

    /**
     * Старт выполнения программы.
     */
    public void start() {
        Tracker tracker = new Tracker();
        MenuTracker menuTracker = new MenuTracker(this.input, tracker);
        do {
            menuTracker.show();
            int menuKey = Integer.valueOf(input.ask("Выберите, пожалуйста, пункт меню: "));
            menuTracker.select(menuKey);
        } while (!this.input.askBoolean("Выйти?(да) "));
    }

    /**
     * Запуск программы.
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).start();
    }
}
