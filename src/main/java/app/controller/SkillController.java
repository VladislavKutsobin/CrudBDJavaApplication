package app.controller;

import app.model.Skill;
import app.repository.Impl.SkillRepositoryImpl;
import app.repository.SkillRepository;

import java.sql.SQLException;
import java.util.List;

public class SkillController {
    SkillRepository skillRepository = new SkillRepositoryImpl();

    public void create(Skill skill) throws ClassNotFoundException, SQLException {
        if(skill == null){
            throw new IllegalArgumentException();
        }else {
            skillRepository.create(skill);
        }
    }

    public List<Skill> findAll() throws SQLException, ClassNotFoundException {
        return skillRepository.findAll();
    }

    public void update(Skill skill) throws SQLException, ClassNotFoundException {
        if(skill == null){
            throw  new IllegalArgumentException();
        }else skillRepository.update(skill);
    }

    public void delete(Integer id) throws ClassNotFoundException, SQLException {
        if(id == null || id < 0){
            throw new IllegalArgumentException();
        }else {
            skillRepository.delete(id);
        }
    }

    public Skill getById(Integer id) throws SQLException, ClassNotFoundException {
        if(id == null || id < 0){
            throw new IllegalArgumentException();
        }else {

        }return skillRepository.getByID(id);
    }

}
