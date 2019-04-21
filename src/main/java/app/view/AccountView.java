package app.view;

import app.controller.AccountController;
import app.controller.DeveloperController;
import app.model.Account;
import app.model.Developer;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountView {
    AccountController accountController = new AccountController();
    DeveloperController developerController = new DeveloperController();
    static Scanner scanner = new Scanner(System.in);


    public void getAccountMenu() throws SQLException, ClassNotFoundException {
        System.out.println("Enter:" +"\n"+
                "'create' for adding new user" +"\n"+
                "'delete' for deleting user" +"\n"+
                "'show' for showing all the users"+"\n"+
                "'get' for for showing a certain user"+"\n"+
                "'update' for change a certain user"+"\n"+
                "'menu' for return to main menu" + "\n" +
                "'exit' for exit");

        String input = scanner.next();
        Account accountToSave = new Account();
        Developer developerToSave = new Developer();
        Integer id;

        while(!input.equals("exit")){
            switch(input){
                case "create":
                    System.out.println("All developers in system: " + developerController.findAll() + "\n");
                    System.out.println("Enter id developer...");
                    input = scanner.next();
                    developerToSave = developerController.getById(Integer.parseInt(input));
                    accountToSave.setDeveloper(developerToSave);

                    System.out.println("Enter your login for create..");
                    input = scanner.next();
                    accountToSave.setLogin(input);

                    System.out.println("Enter your developer for create..");
                    input = scanner.next();
                    accountToSave.setDeveloperData(input);

                    System.out.println("New account was successfully added!");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;

                case "delete":
                    System.out.println("Enter id of deleting user:");
                    input = scanner.next();
                    id = Integer.parseInt(input);
                    accountController.delete(id);
                    System.out.println("User was successfully deleted!");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;

                case "show":
                    System.out.println(accountController.findAll());
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "get":
                    System.out.println("Enter id of user:");
                    input = scanner.next();
                    id = Integer.parseInt(input);
                    developerController.getById(id);
                    input = scanner.next();
                    break;

                case "update":
                    System.out.println("Enter id of updating user:");
                    input = scanner.next();
                    accountToSave.setId(Integer.parseInt(input));

                    System.out.println("Enter the new login:");
                    input = scanner.next();
                    accountToSave.setLogin(input);

                    System.out.println("Enter the new developerData:");
                    input = scanner.next();
                    accountToSave.setDeveloperData(input);

                    accountController.update(accountToSave);
                    System.out.println("User was successfully changed!");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;
                case "menu":
                    ConsoleHelper consoleHelper = new ConsoleHelper();
                    consoleHelper.getMenu();

                default:
                    System.out.println("Please,make your choice!");
                    input = scanner.next();
            }
        }

    }
}
