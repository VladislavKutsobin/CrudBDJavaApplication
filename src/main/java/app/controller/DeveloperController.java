package app.controller;

import app.model.Developer;
import app.repository.DeveloperRepository;
import app.repository.Impl.DeveloperRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class DeveloperController {
    DeveloperRepository developerRepository = new DeveloperRepositoryImpl();

    public void save(Developer developer) throws SQLException, ClassNotFoundException {
        if(developer == null){
            throw new IllegalArgumentException();
        }else {
            developerRepository.create(developer);
        }
    }

    public List<Developer> findAll() throws SQLException, ClassNotFoundException {
        return developerRepository.findAll();
    }

    public void update(Developer developer) throws SQLException, ClassNotFoundException {
        if(developer == null){
            throw  new IllegalArgumentException();
        }else developerRepository.update(developer);
    }


    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        if(id == null || id < 0){
            throw new IllegalArgumentException();
        }else {
            developerRepository.delete(id);
        }
    }

    public Developer getById(Integer id) throws SQLException, ClassNotFoundException {
        if(id == null || id < 0){
            throw new IllegalArgumentException();
        }else {

        }return developerRepository.getByID(id);
    }
}
