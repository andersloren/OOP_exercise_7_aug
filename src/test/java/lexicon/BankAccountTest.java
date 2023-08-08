package lexicon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @ParameterizedTest
    @ValueSource(doubles = {-1.0})
    void balanceThrowsIfSetNegative(double balanceSet) {
        BankAccount bankAccount = new BankAccount();

        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.setBalance(balanceSet));
    }

    @ParameterizedTest
    @CsvSource({
            // balance, deposit, expected
            "100.0, 50.0, 150.0",
            "0.0, 25.0, 25,0"
    })
    void depositShouldAddDepositAmountAndBalance(double balance, double depositAmount, double expected) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setBalance(balance);
        bankAccount.deposit(depositAmount);

        assertEquals(expected, bankAccount.getBalance());
    }

    @ParameterizedTest
    @CsvSource({
            "-1.0",
            "-100.0",
            "-0.000001"
    })
    void depositThrowsIfNegative(double depositAmount) {
        BankAccount bankAccount = new BankAccount();

        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.deposit(depositAmount));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0",
            "100.0",
            "0.000001",
    })
    void depositTrueIfDepositLargerOrEqualToZero(double depositAmount) {
        BankAccount bankAccount = new BankAccount();

        assertDoesNotThrow(
                () -> bankAccount.deposit(depositAmount));
    }

    @ParameterizedTest
    @CsvSource({
            // balance, withdraw, expected
            "100.0, 50.0, true",
            "50.0, 100.0, false"
    })
    void checkBalanceIsFalseIfWithdrawGreaterThanBalanceElseTrue(double balance, double withdrawAmount, boolean expected) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setBalance(balance);
        boolean balanceGreaterThanWithdrawal = bankAccount.checkBalance(withdrawAmount);

        assertEquals(expected, balanceGreaterThanWithdrawal);
    }

    @ParameterizedTest
    @CsvSource({
            "-1.0",
            "-100.0",
            "-0.000001"
    })
    void withdrawThrowsIfNegative(double depositAmount) {
        BankAccount bankAccount = new BankAccount();

        assertThrows(IllegalArgumentException.class,
                () -> bankAccount.withdraw(depositAmount));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0",
            "100.0",
            "0.000001",
    })
    void withdrawThrowsNotIfPositive(double depositAmount) {
        BankAccount bankAccount = new BankAccount();

        assertDoesNotThrow(
                () -> bankAccount.withdraw(depositAmount));
    }

    @ParameterizedTest
    @CsvSource({
            "1.0,2.0",
    })
    void falseIfBalanceNotSufficient(double balance, double withdraw) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setBalance(balance);

        assertFalse(bankAccount.checkBalance(withdraw));
    }
}
