package app;

import app.model.Skill;
import app.repository.Impl.SkillRepositoryImpl;
import app.repository.SkillRepository;
import app.view.ConsoleHelper;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        consoleHelper.start();
    }
}
