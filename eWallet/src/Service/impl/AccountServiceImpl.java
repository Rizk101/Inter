package Service.impl;

import Model.Account;
import Model.EwalletSystem;
import Service.AccountService;

public class AccountServiceImpl implements AccountService {

    private EwalletSystem ewalletSystem = new EwalletSystem();
    @Override
    public boolean CreateAccount(Account account) {
        boolean isAccountExist = ewalletSystem.getAccounts().stream().anyMatch(acc -> acc.getUserName().equals(account.getUserName()));
        ewalletSystem.getAccounts().add(account);
        if(isAccountExist){
            return false;
        }
        return true;
    }

    @Override
    public boolean isAccountExistByUsernameAndPassword(Account account) {
        boolean isAccountExist = ewalletSystem.getAccounts().stream().anyMatch(acc -> acc.getUserName().equals(account.getUserName())
                && acc.getPassword().equals(account.getPassword()));
        ewalletSystem.getAccounts().add(account);
        if(isAccountExist){
            return true;
        }
        return false;
    }
}
