package pl.pjatk;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        User user = new User("Szymon", "Dej", 1234);
        Account account = new Account(BigDecimal.valueOf(1000), "00000000000000000000002212", user);
        Bank bank = new Bank("BANk");

        bank.addAccountToBank(account);

        System.out.println(account);
        System.out.println(bank);

        Service service = new Service(bank);
        System.out.println(service.balanceAccount(user));

        System.out.println(service.balanceAccount(new User("asdf", "asdf",1233)));
    }



}
