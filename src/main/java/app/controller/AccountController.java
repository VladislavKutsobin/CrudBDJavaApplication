package app.controller;

import app.model.Account;
import app.repository.AccountRepository;
import app.repository.Impl.AccountRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class AccountController {
    AccountRepository accountRepository = new AccountRepositoryImpl();

    public void create(Account account) throws SQLException, ClassNotFoundException {
        if(account == null){
            throw new IllegalArgumentException();
        }else {
            accountRepository.create(account);
        }
    }

    public List<Account> findAll() throws SQLException, ClassNotFoundException {
        return accountRepository.findAll();
    }

    public void update(Account account) throws SQLException, ClassNotFoundException {
        if(account == null){
            throw  new IllegalArgumentException();
        }else accountRepository.update(account);
    }


    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        if(id == null || id < 0){
            throw new IllegalArgumentException();
        }else {
            accountRepository.delete(id);
        }
    }

    public Account getById(Integer id) throws SQLException, ClassNotFoundException {
        if(id == null || id < 0){
            throw new IllegalArgumentException();
        }else {

        }return accountRepository.getByID(id);
    }
}
