package ru.avorotov.newtracker;

/**
 * Базовый класс для действия.
 */
public abstract class BaseAction implements IUserAction {

    /**
     * Имя действия.
     */
    private String name;

    /**
     * Идентификатор действия.
     */
    private int key;

    /**
     * Конструктор.
     * @param name Наименование операции.
     * @param key Идентификатор действия.
     */
    BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * Информация о действии.
     *
     * @return Информация о действии.
     */
    @Override
    public String info() {
        return String.format("%s.) %s", key, name);
    }

    /**
     * Идентификатор действия.
     *
     * @return Идентификатор действия.
     */
    @Override
    public int key() {
        return key;
    }
}
