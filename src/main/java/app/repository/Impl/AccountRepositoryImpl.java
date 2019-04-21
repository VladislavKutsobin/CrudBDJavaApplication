package app.repository.Impl;

import app.Connection.DBConnection;
import app.model.Account;
import app.model.Developer;
import app.repository.AccountRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public void create(Account account) throws SQLException, ClassNotFoundException {
        int account_id = 0;
        String accountQuery = "INSERT INTO accounts(login, developerData) VALUES(?, ?)";
        String accountDeveloperQuery = "INSERT INTO developers_accounts(developer_id, account_id) VALUES (?, ?)";

        try(Connection connection = DBConnection.getDBConnection();
            PreparedStatement preparedAccountStatement = connection.prepareStatement(accountQuery);
            PreparedStatement preparedDeveloperAccountStatement = connection.prepareStatement(accountDeveloperQuery)) {
            preparedAccountStatement.setString(1, "login");
            preparedAccountStatement.setString(2, "developerData");
            preparedAccountStatement.executeUpdate();

            try(ResultSet resultSet = preparedAccountStatement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    account_id = resultSet.getInt("id");
                }
            }

            for(Developer developer : account.getDevelopers()) {
                preparedDeveloperAccountStatement.setInt(1,developer.getId());
                preparedDeveloperAccountStatement.setInt(2,account_id);
                preparedDeveloperAccountStatement.executeUpdate();
            }
        }
    }

    @Override
    public List<Account> findAll() throws SQLException, ClassNotFoundException {
        List<Account> accountList = new ArrayList<>();
        String query = "SELECT * FROM accounts";

        try(Connection connection = DBConnection.getDBConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
                while(resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String login = resultSet.getString("login");
                    String developerData = resultSet.getString("developerData");
                    Account account = new Account(id, login, developerData);
                    accountList.add(account);
                }
        }
        return accountList;
    }

    @Override
    public void update(Account account) throws SQLException, ClassNotFoundException {
        String query = "UPDATE account SET login = ?, developerData = ? WHERE id = ?";

        try(Connection connection = DBConnection.getDBConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getLogin());
            preparedStatement.setString(2, account.getDeveloperData());
            preparedStatement.setInt(3, account.getId());
            preparedStatement.execute();
        }
    }

    @Override
    public void delete(Integer integer) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM account WHERE id = ?";

        try(Connection connection = DBConnection.getDBConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,integer);
            preparedStatement.execute();
        }
    }

    @Override
    public Account getByID(Integer integer) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM accounts WHERE id = ?";

        try(Connection connection = DBConnection.getDBConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)
        ){
            preparedStatement.setInt(1,integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String developerData = resultSet.getString("developerData");
                return new Account(id, login, developerData);
            }
        }
        return null;
    }
}
