package pl.pjatk;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {


        User user = new User("Szymon", "Dej", 1234);
        Account account = new Account(BigDecimal.valueOf(1000), "00123400000000000000002212", user);
        Bank bank = new Bank("1234");

        bank.addAccountToBank(account);


        System.out.println(account);
        System.out.println(bank);

        Service service = new Service(bank);
        System.out.println(service.balanceAccount(user));

        //System.out.println(service.balanceAccount(new User("asdf", "asdf",1233)));
        System.out.println(service.checkBankAndAccountCorrelation(account));

        service.topUpAccount(BigDecimal.valueOf(1000), user);
        //System.out.println(service.balanceAccount(user));

        User user1 = new User("asdf", "asdf", 1233);
        Account account1 = new Account(BigDecimal.valueOf(2000), "00123422122212221222122212", user1);
        bank.addAccountToBank(account1);


        System.out.println(service.balanceAccount(user1));
        System.out.println(service.balanceAccount(user));
        service.transferMoney(user, user1, BigDecimal.valueOf(500));
        System.out.println(service.balanceAccount(user1));
        System.out.println(service.balanceAccount(user));
    }
}
