package app.view;

import app.controller.DeveloperController;
import app.controller.SkillController;
import app.model.Developer;
import app.model.Skill;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeveloperView {
    DeveloperController developerController = new DeveloperController();
    SkillController skillController = new SkillController();
    static Scanner scanner = new Scanner(System.in);


    public void getDeveloperMenu() throws SQLException, ClassNotFoundException {
        System.out.println("Enter:" +"\n"+
                "'add' for adding new user" +"\n"+
                "'delete' for deleting user" +"\n"+
                "'show' for showing all the users"+"\n"+
                "'get' for for showing a certain user"+"\n"+
                "'edit' for change a certain user"+"\n"+
                "'menu' for return to main menu" + "\n" +
                "'exit' for exit");

        String input = scanner.next();
        Developer developerToSave = new Developer();
        Integer id;

        while(!input.equals("exit")){
            switch(input){
                case "create":
                    System.out.println("Enter the name:");
                    input = scanner.next();
                    developerToSave.setFirstName(input);

                    System.out.println("Enter the surname:");
                    input = scanner.next();
                    developerToSave.setLastName(input);

                    //--------Set of skills' logic---------------------------
                    System.out.println("Choose some skills from this list and enter its id by using ',' :" + "\n"
                            + skillController.findAll());
                    scanner.nextLine();
                    input = scanner.nextLine();

                    Set<Skill> skillSet = new HashSet<>();
                    for(Integer sId: ConsoleHelper.inputToSetId(input)){
                        Skill skillToSave = skillController.getById(sId);
                        skillSet.add(skillToSave);
                    }
                    developerToSave.setSkills(skillSet);
                    developerController.save(developerToSave);

                    System.out.println("New user was successfully added!");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;

                case "delete":
                    System.out.println("Enter id of deleting user:");
                    input = scanner.next();
                    id = Integer.parseInt(input);
                    developerController.delete(id);
                    System.out.println("User was successfully deleted!");
                    System.out.println("What do you want to do now?");
                    input = scanner.next();
                    break;

                case "show":
                    System.out.println(developerController.findAll());
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
                    developerToSave.setId(Integer.parseInt(input));

                    System.out.println("Enter the new name:");
                    input = scanner.next();
                    developerToSave.setFirstName(input);

                    System.out.println("Enter the new surname:");
                    input = scanner.next();
                    developerToSave.setLastName(input);

                    developerController.update(developerToSave);
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
