package app;

import app.model.Skill;
import app.repository.Impl.SkillRepositoryImpl;
import app.repository.SkillRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Skill skill = new Skill(11, "Objective");
        SkillRepository skillRepository = new SkillRepositoryImpl();
        //skillRepository.create(skill);
        //skillRepository.update(skill);
        System.out.println(skillRepository.findAll());
    }
}
