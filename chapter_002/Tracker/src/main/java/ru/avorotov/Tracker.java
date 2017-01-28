package ru.avorotov;

import ru.avorotov.Model.Claim;

import java.util.Arrays;

/**
 * Класс для работы с заявками.
 */
public class Tracker implements ITracker {
    /**
     * Список Заявок.
     */
    private Claim[] claims;

    /**
     * Количество заявок.
     */
    private int countClaim;

    /**
     *
     */
    private int position = 0;

    /**
     * Конструктор.
     */
    public Tracker() {
        this.claims = new Claim[0];
    }

    /**
     * Увеличивает размер хранящего массива.
     *
     * @param size Необходимый размер массива.
     */
    private void ensureCapacity(int size) {
        if (claims.length < size) {
            claims = Arrays.copyOf(claims, size);
        }
    }

    /**
     * Добавить Заявку.
     *
     * @param claim Заявка.
     * @return Добавленная заявка.
     */
    public Claim add(Claim claim) {
        claim.setId(this.generateId());
        ensureCapacity(countClaim + 1);
        claims[countClaim++] = claim;
        return claim;
    }

    /**
     * Сгенерировать уникальный идентификатор.
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
        for (int i = 0; i < countClaim; i++) {
            if (claim.getId() == this.claims[i].getId()) {
                claim.setId(this.claims[i].getId());
                this.claims[i] = claim;
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
        boolean findClaim = false;
        int oldCountClaim = this.countClaim;
        Claim[] newClaims = new Claim[--this.countClaim];
        for (int i = 0; i < oldCountClaim; i++) {

            if (findClaim) {
                newClaims[i - 1] = this.claims[i];
            } else {
                newClaims[i] = this.claims[i];
            }
            findClaim = !findClaim && this.claims[i].getId().equals(claim.getId());
        }
        this.claims = newClaims;
    }

    /**
     * Найти все заявки.
     *
     * @return Все заявки.
     */
    public Claim[] findAll() {
        Claim[] newClaims = Arrays.copyOf(claims, countClaim);
        return newClaims;
    }

    /**
     * Найти заявку по имени.
     *
     * @param name Наименование заявки.
     * @return Заявка.
     */
    public Claim[] findByName(String name) {
        Claim[] findClaim = null;
        int count = 0;
        for (int i = 0; i < this.countClaim; i++) {
            if (name.equals(claims[i].getName())) {
                count++;
            }
        }

        if (count > 0) {
            findClaim = new Claim[count];
            count = 0;
            for (int i = 0; i < this.countClaim; i++) {
                if (name.equals(claims[i].getName())) {
                    findClaim[count] = claims[i];
                    count++;
                }
            }
        }

        return findClaim;
    }

    /**
     * Найти заявку по Id.
     *
     * @param id Идентификатор заявки.
     * @return Заявка.
     */
    public Claim findById(String id) {
        Claim findClaim = null;
        for (int i = 0; i < this.countClaim; i++) {
            if (id.equals(claims[i].getId())) {
                findClaim = claims[i];
            }
            break;
        }
        return findClaim;
    }
}
