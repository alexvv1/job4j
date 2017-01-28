package ru.avorotov;

/**
 * Меню.
 */
public class MenuTracker {

    /**
     * Ввод/вывод.
     */
    private final IInput input;
    /**
     * Tracker.
     */
    private final Tracker tracker;
    /**
     * Количество действий.
     */
    private final int countUserAction = 6;

    /**
     * Пользовательские действия.
     */
    private final IUserAction[] actions = new IUserAction[countUserAction];
    /**
     * Позиция пользовательского действия.
     */
    private int position = 1;

    /**
     * Контроль.
     * @param input Ввод/вывод.
     * @param tracker Tracker.
     */
    public MenuTracker(IInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;

        fillAction();
    }

    /**
     * Выбрать пользовательское действие.
     * @param key Ключ действия.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Заполнить действия.
     */
    private void fillAction() {
        this.actions[position] = new Actions.AddAction(position);
        position++;
        this.actions[position] = new Actions.ShowClaimAction(position);
        position++;
        this.actions[position] = new Actions.EditClaimAction(position);
        position++;
        this.actions[position] = new Actions.ShowAllClaimAction(position);
        position++;
        this.actions[position] = new Actions.DeleteClaimAction(position);
    }

    /**
     * Показать меню.
     */
    public void show() {
        for (IUserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
