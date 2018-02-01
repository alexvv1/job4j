package ru.avorotov.bank.application;

import ru.avorotov.bank.exception.AccountException;
import ru.avorotov.bank.exception.UserException;
import ru.avorotov.bank.model.Account;
import ru.avorotov.bank.model.User;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Optional;


/**
 * Банковские операции.
 */
public class Banking {
    /**
     * Карта пользоваель - счета.
     */
    private final Map<User, List<Account>> mapBanking = new HashMap<>();

    /**
     * Получить карту Пользователь-Список банковских счетов.
     *
     * @return Карта Пользователь-Список банковских счетов.
     */
    public Map<User, List<Account>> getMapBanking() {
        return mapBanking;
    }

    /**
     * Добавить пользователя.
     *
     * @param user Добовляемый пользователь.
     */
    public void addUser(User user) {
        mapBanking.put(user, new ArrayList<>());
    }

    /**
     * Удалить пользователя.
     *
     * @param user Удаляемый пользователь.
     */
    public void deleteUser(User user) {
        mapBanking.remove(user);
    }

    /**
     * Добавить счёт пользователю.
     *
     * @param passport Номер пасспорта пользователя.
     * @param account  Банковский счет.
     */
    public void addAccountToUser(String passport, Account account) {
        User user = findUser(passport);
        List<Account> accounts = mapBanking.get(user);
        accounts.add(account);
    }

    /**
     * Найти пользователя.
     *
     * @param passport Номер паспотра пользователя.
     * @return Пользователь.
     */
    public User findUser(String passport) {
        Optional<User> user = mapBanking.keySet().stream().filter(k -> k.getPassport().equals(passport)).findFirst();
        if (!user.isPresent()) {
            throw new UserException("User not found");
        }
        return user.get();
    }

    /**
     * Получить счета пользователя.
     *
     * @param user Пользователь.
     * @return Счета пользователя.
     */
    public List<Account> getAccounts(User user) {
        List<Account> accounts = mapBanking.get(user);
        if (accounts == null) {
            throw new AccountException("Account not found");
        }
        return accounts;
    }

    /**
     * Удалить один банковский счет у пользователя.
     *
     * @param passport Номер паспорта пользователя.
     * @param account  Банковский счет пользователя.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUser(passport);
        getAccounts(user).remove(account);
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     *
     * @param srcPassport   Номер паспорта отправителя денег.
     * @param srcRequisite  Банковский счет отправителя денег.
     * @param destPassport  Номер паспорта получателя денег.
     * @param destRequisite Банковский счет получателя денег.
     * @param amount        Количество переводимых денег.
     * @return Транзакция прошла успешно? false - если счёт не найден или не хватает денег на счёте srcAccount
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, int amount) {
        User srcUser = findUser(srcPassport);
        List<Account> srcAccounts = getAccounts(srcUser);
        Optional<Account> srcAccountOpt = srcAccounts.stream().filter(k -> k.getRequisites().equals(srcRequisite)).findFirst();
        if (!srcAccountOpt.isPresent()) {
            return false;
        }
        User destUser = findUser(destPassport);
        List<Account> destAccounts = getAccounts(destUser);
        Optional<Account> destAccountOpt = destAccounts.stream().filter(k -> k.getRequisites().equals(destRequisite)).findFirst();
        if (!destAccountOpt.isPresent()) {
            return false;
        }

        Account srcAccount = srcAccountOpt.get();
        Account destAccount = destAccountOpt.get();

        try {
            srcAccount.withdrawMoney(amount);
            destAccount.addMoney(amount);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
