package ru.avorotov;

/**
 * Пользовательское действие.
 */
public interface IUserAction {
    /**
     * Идентификатор действия.
     * @return Идентификатор действия.
     */
    int key();

    /**
     * Выполнить действие.
     * @param input Объект для ввода/вывода.
     * @param tracker Объект для работы с заявками
     */
    void execute(IInput input, ITracker tracker);

    /**
     * Информация о действии.
     * @return Информация о действии.
     */
    String info();
}
