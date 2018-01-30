package ru.avorotov.newtracker;

import ru.avorotov.newtracker.Model.Claim;

import java.util.List;
import java.util.Optional;

/**
 * Created by SSS on 28.01.2017.
 */
public interface ITracker {

    /**
     * Добавить Заявку.
     *
     * @param claim Заявка.
     * @return Добавленная заявка.
     */
    Claim add(Claim claim);

    /**
     * Обновить заявку.
     *
     * @param claim Существующая заявка
     */
    void update(Claim claim);

    /**
     * Удалить заявку.
     *
     * @param claim Заявка.
     */
    void delete(Claim claim);

    /**
     * Найти все заявки.
     *
     * @return Все заявки.
     */
    List<Claim> findAll();

    /**
     * Найти заявку по имени.
     *
     * @param name Наименование заявки.
     * @return Заявка.
     */
    List<Claim> findByName(String name);

    /**
     * Найти заявку по Id.
     *
     * @param id Идентификатор заявки.
     * @return Заявка.
     */
    Optional<Claim> findById(String id);
}
