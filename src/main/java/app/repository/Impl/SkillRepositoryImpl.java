package app.repository.Impl;

import app.util.UtilConnection;
import app.model.Skill;
import app.repository.SkillRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {
    public void create(Skill skill) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO skills(name) VALUES (?)";

        try(Connection connection = UtilConnection.getUtilConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, skill.getName());
            preparedStatement.execute();
        }
    }

    public List<Skill> findAll() throws SQLException, ClassNotFoundException {
        List<Skill> skillList = new ArrayList<>();
        String query = "SELECT * FROM skills";
        try(Connection connection = UtilConnection.getUtilConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
            while(resultSet.next()) {
                Integer skill_id = resultSet.getInt("id");
                String skillName = resultSet.getString("name");
                Skill skill = new Skill(skill_id, skillName);
                skillList.add(skill);
            }
        }
        return skillList;
    }

    public void update(Skill skill) throws SQLException, ClassNotFoundException {
        String query = "UPDATE skills SET name = ? WHERE id = ?";

        try(Connection connection = UtilConnection.getUtilConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,skill.getName());
            preparedStatement.setInt(2,skill.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer integer) throws SQLException, ClassNotFoundException {
        String query = "DELETE from skills WHERE id = ?";

        try(Connection connection = UtilConnection.getUtilConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, integer);
            preparedStatement.execute();
        }
    }

    @Override
    public Skill getByID(Integer integer) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM skills WHERE id = ?";
        try(Connection connection = UtilConnection.getUtilConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, integer);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return new Skill(resultSet.getInt("id"), resultSet.getString("name"));
            }
        }
        return null;
    }


}
