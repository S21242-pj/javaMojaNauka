package pl.pjatk;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balanceAccount;
    private String accountNumber;
    private User user;


    public Account(BigDecimal balanceAccount, String accountNumber, User user) {
        validateAccountNumber(accountNumber);
        this.balanceAccount = balanceAccount;
        this.accountNumber = accountNumber;
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalanceAccount() {
        return balanceAccount;
    }

    public void setBalanceAccount(BigDecimal balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    public boolean hasUserIdOf(int userId) {
        return user.getUserId() == userId;
    }


    private void validateAccountNumber(String accountNumber) {
        if (accountNumber.length() != 26) {
            throw new IllegalArgumentException("Account number =! 26, actuall is:" + accountNumber.length());
        }
        char[] symbols = accountNumber.toCharArray();
        for (char symbol : symbols) {
            if (!Character.isDigit(symbol)) {
                throw new IllegalArgumentException("Znaki w numerze konta..");
            }
        }
    }


    @Override
    public String toString() {
        return "Account{" +
                "balanceAccount=" + balanceAccount +
                ", accountNumber='" + accountNumber + '\'' +
                ", user=" + user +
                '}';
    }
}
