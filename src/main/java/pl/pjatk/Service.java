package pl.pjatk;

import java.math.BigDecimal;
import java.util.Optional;

public class Service {
    private Bank bank;


    public Service(Bank bank) {
        this.bank = bank;
    }


    public BigDecimal balanceAccount(User user) {
        Optional<Account> accountOptional = getAccountForUser(user);
        if (accountOptional.isPresent()) {
            //System.out.println("Znaleziono account");
            Account account = accountOptional.get();
            return account.getBalanceAccount();
        } else {
            // System.out.println("Nie odnaleziono account");
            return BigDecimal.ZERO;
        }
    }


    public Optional<Account> getAccountForUser(User user) {
        return bank.findAccByUserId(user.getUserId());
    }


    public boolean checkBankAndAccountCorrelation(Account account) {
        String accountNumber = account.getAccountNumber();
        String checkAccountNumber = accountNumber.substring(2, 6);
        return checkAccountNumber.equals(bank.getBankId());
    }


    public BigDecimal topUpAccount(BigDecimal topUpAmount, User user) {
        Optional<Account> accountOptional = getAccountForUser(user);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setBalanceAccount(topUpAmount);
            return topUpAmount;
        } else {
            return BigDecimal.ZERO;
        }
    }


    public BigDecimal transferMoney(User fromUser, User toUser, BigDecimal amount) {
        if (!hasAccount(fromUser) || !hasAccount(toUser)) {
            return BigDecimal.ZERO;
        }
        BigDecimal fromUserBalance = balanceAccount(fromUser);
        BigDecimal toUserBalance = balanceAccount(toUser);
        if (fromUserBalance.doubleValue() < amount.doubleValue()) {
            return BigDecimal.ZERO;
        }

        // Account accountFrom = getAccountForUser(fromUser).get();
        // Account accountTo = getAccountForUser(toUser).get();

        topUpAccount(fromUserBalance.subtract(amount), fromUser);
        topUpAccount(toUserBalance.add(amount), toUser);

        return amount;
    }


    public boolean hasAccount(User user) {
        return getAccountForUser(user).isPresent();
    }
}
