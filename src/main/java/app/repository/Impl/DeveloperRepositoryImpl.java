package app.repository.Impl;

import app.Connection.DBConnection;
import app.model.Developer;
import app.model.Skill;
import app.repository.DeveloperRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {
    @Override
    public void create(Developer developer) throws SQLException, ClassNotFoundException {
        int developerId = 0;
        String developerQuery = "INSERT INTO developers(firstname, lastname) VALUES (?, ?)";
        String developerSkillsQuery = "INSERT INTO developers_skills(developer_id, skill_id) VALUES (?, ?))";

        try(Connection connection = DBConnection.getDBConnection();
            PreparedStatement preparedStatementDeveloper = connection.prepareStatement(developerQuery, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement preparedStatementDeveloperSkills = connection.prepareStatement(developerSkillsQuery)) {
            preparedStatementDeveloper.setString(1,developer.getFirstName());
            preparedStatementDeveloper.setString(2,developer.getLastName());
            preparedStatementDeveloper.executeUpdate();

            try(ResultSet resultSet = preparedStatementDeveloper.getGeneratedKeys()) {
                if(resultSet.next()) {
                    developerId = resultSet.getInt(1);
                }
            }

            for(Skill skill : developer.getSkills()) {
                preparedStatementDeveloperSkills.setInt(1, developerId);
                preparedStatementDeveloperSkills.setInt(2,skill.getId());
                preparedStatementDeveloperSkills.executeUpdate();
            }

        }
    }

    @Override
    public List<Developer> findAll() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM developers";
        List<Developer> developerList = new ArrayList<>();

        try(Connection connection = DBConnection.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getNString("lastName");
                Developer developer = new Developer(id, firstName, lastName);
                developerList.add(developer);
            }
        }
        return developerList;
    }

    @Override
    public void update(Developer developer) throws SQLException, ClassNotFoundException {
        String query = "UPDATE developers SET firstName = ?, lastName = ? WHERE id = ?";

        try(Connection connection = DBConnection.getDBConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setInt(3, developer.getId());
            preparedStatement.execute();
        }
    }

    @Override
    public void delete(Integer integer) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM developers WHERE id = ?";
        try(Connection connection = DBConnection.getDBConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,integer);
            preparedStatement.execute();
        }
    }

    @Override
    public Developer getByID(Integer integer) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM developers WHERE id = ?";

        try(Connection connection = DBConnection.getDBConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                return new Developer(id, firstName, lastName);
            }
        }
        return null;
    }
}
