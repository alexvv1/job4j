package ru.avorotov.newtracker;

import java.util.ArrayList;
import java.util.List;

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
    private final ITracker tracker;

    /**
     * Пользовательские действия.
     */
    private final List<IUserAction> actions = new ArrayList<>();

    /**
     * Контроль.
     *
     * @param input   Ввод/вывод.
     * @param tracker Tracker.
     */
    MenuTracker(IInput input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;

        fillAction();
    }

    /**
     * Выбрать пользовательское действие.
     *
     * @param key Ключ действия.
     */
    public void select(int key) {
        this.actions.stream().filter(k-> k.key() == key).findFirst().get().execute(this.input, this.tracker);
    }

    /**
     * Заполнить действия.
     */
    private void fillAction() {
        int position = 1;
        this.actions.add(new Actions.AddAction(position));
        position++;
        this.actions.add(new Actions.ShowClaimAction(position));
        position++;
        this.actions.add(new Actions.EditClaimAction(position));
        position++;
        this.actions.add(new Actions.ShowAllClaimAction(position));
        position++;
        this.actions.add(new Actions.DeleteClaimAction(position));
    }

    /**
     * Возвращает ключи доступных действий.
     *
     * @return Ключи доступных действий
     */
    public List<Integer> getExistKeysAction() {
        List<Integer> existKeysAction = new ArrayList<>();
        for (IUserAction action : actions) {
            existKeysAction.add(action.key());
        }
        return existKeysAction;
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
