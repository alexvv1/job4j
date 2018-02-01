package ru.avorotov.bank.application;

import org.junit.Test;
import ru.avorotov.bank.model.Account;
import ru.avorotov.bank.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Тест банковских операций.
 */
public class BankingTest {

    /**
     *
     */
    private void addUsersFromBanking() {
        banking.addUser(user1);
        banking.addUser(user2);
        banking.addUser(user3);
    }


    /**
     * Тест Добавления пользователя.
     */
    @Test
    public void whenAddUserThenMapBankingContainsNewUser() {
        //Arrange
        User user = new User("name", "6756WW657547");
        //Act
        banking.addUser(user);
        //Assert
        assertThat(banking.getMapBanking().keySet(), hasItem(user));
    }

    /**
     * Тест удаления пользователя.
     */
    @Test
    public void whenDeleteUserThenMapBankingNotContainsNewUser() {
        //Arrange
        addUsersFromBanking();
        //Act
        banking.deleteUser(user2);
        //Assert
        Set<User> actual = banking.getMapBanking().keySet();
        assertThat(actual, allOf(hasItem(user1), hasItem(user3)));
        assertThat(banking.getMapBanking().keySet(), not(hasItem(user2)));
    }

    /**
     * Тест Добавление банковского счета.
     */
    @Test
    public void whenAddAccountUserWhenAddedAccountUser() {
        //Arrange
        addUsersFromBanking();
        //Act
        banking.addAccountToUser(passportUser2, account1);
        //Assert
        Optional<Map.Entry<User, List<Account>>> first = banking.getMapBanking()
                .entrySet().stream()
                .filter(k -> k.getKey().getPassport().equals(passportUser2)).findFirst();
        assertThat("User not found", true, is(first.isPresent()));
        assertThat(first.get().getValue(), hasItem(account1));
    }

    /**
     * Тест Удалить один банковский счет у пользователя.
     */
    @Test
    public void whenDeleteAccountFromUserThenDeletedAccountFromUser() {
        //Arrange
        addUsersFromBanking();
        banking.addAccountToUser(passportUser2, account1);
        //Act
        banking.deleteAccountFromUser(passportUser2, account1);
        //Arrange
        User user = banking.findUser(passportUser2);
        List<Account> accounts = banking.getAccounts(user);
        assertThat(accounts, not(hasItem(account1)));
    }

    /**
     * Тест Метод для перечисления денег с одного счёта на другой счёт.
     */
    @Test
    public void whenTransferMoneyThenMoneyTransferredSuccess() {
        //Arrange
        addUsersFromBanking();

        banking.addAccountToUser(passportUser1, account1);
        final int oldValue1 = account1.getValue();
        banking.addAccountToUser(passportUser2, account2);
        final int oldValue2 = account2.getValue();
        //Act
        final int transferAmount = 4598;
        boolean resultTrans = banking.transferMoney(passportUser1, requisitesAccount1, passportUser2, requisitesAccount2, transferAmount);
        //Assert
        User user1 = banking.findUser(passportUser1);
        User user2 = banking.findUser(passportUser2);
        List<Account> accountsUser1 = banking.getAccounts(user1);
        List<Account> accountsUser2 = banking.getAccounts(user2);
        Account accountUser1 = accountsUser1.stream().filter(k -> k.getRequisites().equals(requisitesAccount1)).findFirst().get();
        Account accountUser2 = accountsUser2.stream().filter(k -> k.getRequisites().equals(requisitesAccount2)).findFirst().get();

        assertThat(true, is(resultTrans));
        assertThat(oldValue1 - transferAmount, is(accountUser1.getValue()));
        assertThat(oldValue2 + transferAmount, is(accountUser2.getValue()));
    }

    /**
     * Номер паспорта первого пользователя.
     */
    private final String passportUser1 = "1455WW789456";
    /**
     * Номер паспорта второго пользователя.
     */
    private final String passportUser2 = "3458WW754490";
    /**
     * Номер паспорта третьего пользователя.
     */
    private final String passportUser3 = "6947WW546456";
    /**
     * Пользователь №1.
     */
    private final User user1 = new User("name1", passportUser1);
    /**
     * Пользователь №2.
     */
    private final User user2 = new User("name2", passportUser2);
    /**
     * Пользователь №3.
     */
    private final User user3 = new User("name3", passportUser3);
    /**
     * Реквизиты 1-го счёта.
     */
    private final String requisitesAccount1 = "8564560";
    /**
     * Реквизиты 2-го счёта.
     */
    private final String requisitesAccount2 = "cbm49854";
    /**
     * Банковский счет №1.
     */
    private final Account account1 = new Account(requisitesAccount1, 14002);
    /**
     *Банковский счет №2.
     */
    private final Account account2 = new Account(requisitesAccount2, 5008);
    /**
     * Банковские операции.
     */
    private Banking banking = new Banking();

}