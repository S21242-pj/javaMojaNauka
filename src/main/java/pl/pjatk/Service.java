package pl.pjatk;

import java.math.BigDecimal;
import java.util.Optional;

public class Service {
    private Bank bank;

    public Service(Bank bank) {
        this.bank = bank;
    }



    public BigDecimal balanceAccount(User user){
        Optional<Account> accountOptional = bank.findAccByUserId(user.getUserId());
        if (accountOptional.isPresent()){
            System.out.println("Znaleziono account");
            Account account = accountOptional.get();
            return account.getBalanceAccount();
        } else {
            System.out.println("Nie odnaleziono account");
            return BigDecimal.ZERO;
        }
    }

    public Optional<Account> getAccountForUser(User user){
        return bank.findAccByUserId(user.getUserId());
    }

    /**
    public boolean checkBankAndAccountCorrelation(Account account){

    }
*/

}
