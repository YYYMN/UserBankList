package by.novicov.project.service;

import by.novicov.project.dao.UserDAO;
import by.novicov.project.dbconnector.DBConnector;
import by.novicov.project.entity.User;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User getById(int id) {
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setUserId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurName(resultSet.getString(3));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection(resultSet, preparedStatement, connection);
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnector.getConnection();
            statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM user");
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setSurName(resultSet.getString(3));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection(resultSet, statement, connection);
        }
        return users;
    }

    private void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getRichestUser() {
        User user = new User();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnector.getConnection();
            statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM user INNER JOIN account ON user.user_id = account.user_id " +
                    "WHERE account = (SELECT MAX(account) FROM account)");
            resultSet = statement.getResultSet();
            resultSet.next();
            user.setUserId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurName(resultSet.getString(3));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection(resultSet, statement, connection);
        }
        return user;
    }
}

