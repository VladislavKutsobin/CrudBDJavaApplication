package app.view;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleHelper {
    Scanner scanner = new Scanner(System.in);

    SkillView skillView = new SkillView();
    DeveloperView developerView = new DeveloperView();
    AccountView accountView = new AccountView();

    public void start() throws SQLException, ClassNotFoundException {
        getMenu();
    }

    public static Set<Integer> inputToSetId(String input) {
        String [] arrayOfId = input.split(",");
        Set<String> idSetString = new HashSet<>(Arrays.asList(arrayOfId));
        Set<Integer> idSetInteger = new HashSet<>();
        for(String sId : idSetString){
            idSetInteger.add(Integer.parseInt(sId));
        }
        return idSetInteger;
    }

    public void getMenu() throws SQLException, ClassNotFoundException {
        System.out.println("MAIN MENU");
        System.out.println("Enter: 'S' - for Skill, 'D' - for Developer, 'A' - for Account");
        System.out.println("--------------------------------------------------------------------------------------------");
        String choosingEntity = scanner.next();

        switch(choosingEntity){
            case "S":
                skillView.getSkillMenu();
                break;
            case "D":
                developerView.getDeveloperMenu();
                break;
            case "A":
                accountView.getAccountMenu();
                break;
            default:
                System.out.println("Your choice is not right!");
                choosingEntity = scanner.next();
        }
    }
}
