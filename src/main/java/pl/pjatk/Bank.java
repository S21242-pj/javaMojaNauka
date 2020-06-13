package pl.pjatk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {
    private String bankId;
    private List<Account> accounts = new ArrayList<>();


    public Bank(String bankId) {
        validateBankId(bankId);
        this.bankId = bankId;
    }


    public String getBankId() {
        return bankId;
    }


    public void addAccountToBank(Account account) {
        accounts.add(account);
    }


    private void validateBankId(String bankId) {
        if (bankId.length() != 4) {
            throw new IllegalArgumentException("Nie ma 4 znaków");
        }
    }


    public Optional<Account> findAccByUserId(int userId) {
        for (Account account : accounts) {
            if (account.hasUserIdOf(userId)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }


    @Override
    public String toString() {
        return "Bank{" +
                "bankId='" + bankId + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
