package ru.avorotov.newtracker;

import ru.avorotov.newtracker.Model.Claim;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс для работы с заявками.
 */
public class Tracker implements ITracker {
    /**
     * Список Заявок.
     */
    private List<Claim> claims;

    /**
     *
     */
    private int position = 0;

    /**
     * Конструктор.
     */
    Tracker() {
        this.claims = new ArrayList<>();
    }

    /**
     * Добавить Заявку.
     *
     * @param claim Заявка.
     * @return Добавленная заявка.
     */
    public Claim add(Claim claim) {
        claim.setId(this.generateId());
        claims.add(claim);
        return claim;
    }

    /**
     * Сгенерировать уникальный идентификатор.
     *
     * @return Уникальный идентификатор.
     */
    private String generateId() {
        return String.valueOf(++position);
    }

    /**
     * Обновить заявку.
     *
     * @param claim Существующая заявка
     */
    public void update(Claim claim) {
        for (int i = 0; i < this.claims.size(); i++) {
            String claimId = this.claims.get(i).getId();
            if (claim.getId().equals(claimId)) {
                claim.setId(claimId);
                this.claims.set(i, claim);
                break;
            }
        }
    }

    /**
     * Удалить заявку.
     *
     * @param claim Заявка.
     */
    public void delete(Claim claim) {
        claims.remove(claim);
    }

    /**
     * Найти все заявки.
     *
     * @return Все заявки.
     */
    public List<Claim> findAll() {
        return new ArrayList<>(claims);
    }

    /**
     * Найти заявку по имени.
     *
     * @param name Наименование заявки.
     * @return Заявка.
     */
    public List<Claim> findByName(String name) {
        return claims.stream().filter(k -> k.getName().equals(name)).collect(Collectors.toList());
    }

    /**
     * Найти заявку по Id.
     *
     * @param id Идентификатор заявки.
     * @return Заявка.
     */
    public Optional<Claim> findById(String id) {
        return claims.stream().filter(k -> k.getId().equals(id)).findFirst();
    }
}
