package Service.impl;

import Model.Account;
import Service.AccountService;
import Service.AplicationService;

import java.util.Scanner;



public class EwalletAplicationServiceImpl implements AplicationService {

    private AccountService accountService = new AccountServiceImpl();
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello welcome :)");
        int counter = 0;
        boolean exit = false;

        while(true){
            System.out.println("pls enter what you need to do ?");
            System.out.println("1.login   2.sign up   3.exit");
            int choose = scanner.nextInt();

            switch (choose){
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.out.println("have a nice day");
                    exit = true;
                    break;

                default:
                    System.out.println("invalid choose :(");
                    counter++;
            }
            if(exit){
                break;
            }
            if(counter == 4){
                System.out.println("many invalid times !! pls contact with admin");
                break;

            }

        }
    }
    private void signup(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("pls enter username.");
        String userName = scanner.next();

        System.out.println("pls enter password.");
        String password = scanner.next();

        System.out.println("pls enter phone number.");
        String phoneNumber = scanner.next();

        System.out.println("pls enter age.");
        float age = scanner.nextFloat();

        Account account = new Account(userName,phoneNumber,password,age);
        boolean isAccountCreated = accountService.CreateAccount(account);
        if(isAccountCreated){
            mainProfile();
        } else {
            System.out.println("account faild because there exist account with same username :(");
        }
    }
    private void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("pls enter username.");
        String userName = scanner.next();

        System.out.println("pls enter password.");
        String password = scanner.next();

        Account account = new Account(userName,password);

        boolean isAccountExist = accountService.isAccountExistByUsernameAndPassword(account);
        if(isAccountExist){
            // TODO main profail
            mainProfile();
        } else {
            System.out.println("account faild because there exist account with same username :(");
        }
    }
    private void mainProfile(){
        System.out.println("1.deposit  2.withdraw  3.logout");
    }
}
