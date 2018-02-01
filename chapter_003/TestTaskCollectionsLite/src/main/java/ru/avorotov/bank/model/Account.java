package ru.avorotov.bank.model;

import ru.avorotov.bank.exception.AccountException;

import java.util.Objects;

/**
 * Банковский счет.
 */
public class Account {

    /**
     * Количество денегна счете.
     */
    private int value;
    /**
     * Реквизиты счёта.
     */
    private String requisites;

    /**
     * Конструктор.
     *
     * @param requisites Реквизиты счёта.
     * @param value      Количество денег на счете.
     */
    public Account(String requisites, int value) {

        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Положить указаную сумму на счет.
     *
     * @param value Сумма денег которую нужно положить на счет.
     * @return Итоговая сумма.
     */
    public int addMoney(int value) {
        if (value <= 0) {
            throw new AccountException("value must be greater than zero");
        }
        this.value += value;
        return this.value;
    }

    /**
     * Снять деньги со счета.
     * @param value Сумма для снятия.
     * @return Итоговая сумма.
     */
    public int withdrawMoney(int value) {
        if (value <= 0) {
            throw new AccountException("value must be greater than zero");
        }
        if (this.value < value) {
            throw new AccountException("Not enough money on the account");
        }
        this.value -= value;
        return this.value;
    }

    /**
     * Количество денег на счете.
     *
     * @return Количество денег на счете.
     */
    public int getValue() {
        return value;
    }

    /**
     * Реквизиты счёта.
     *
     * @return Реквизиты счёта.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     *  Indicates whether some other object is "equal to" this one.
     *
     * @param   obj   the reference object with which to compare.
     * @return  {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return Objects.equals(requisites, account.requisites)
                && value == account.value;
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     *
     * @return {@code true} if this object is the same as the obj
     *          argument; {@code false} otherwise.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    /**
     * Строковое представление объета.
     * @return Строковое представление объета.
     */
    @Override
    public String toString() {
        return "Account{"
                + "value=" + value
                + ", requisites='" + requisites + '\''
                + '}';
    }
}
