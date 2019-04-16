package by.novicov.project.dao;

import by.novicov.project.dbconnector.DBCloseConnection;
import by.novicov.project.dbconnector.DBConnector;
import by.novicov.project.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private final static Logger LOG = Logger.getLogger(UserDAOImpl.class);
    @Override
    public User getById(int id) {
        User user = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnector.getConnection();
            LOG.debug("Connection start");
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE user_id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setUserId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error("Select From user is failed", e);
        } finally {
            DBCloseConnection.closeConnection(resultSet, preparedStatement, connection);
            LOG.debug("Connection close");
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
            LOG.info("Connection start");
            statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM user");
            resultSet = statement.getResultSet();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setSurname(resultSet.getString(3));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error("Select From user is failed");
        } finally {
            DBCloseConnection.closeConnection(resultSet, statement, connection);
            LOG.info("Connection close");
        }
        return users;
    }

    @Override
    public User getRichestUser() {
        User user = new User();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBConnector.getConnection();
            LOG.debug("Connection start");
            statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM user INNER JOIN account ON user.user_id = account.user_id " +
                    "WHERE account = (SELECT MAX(account) FROM account)");
            resultSet = statement.getResultSet();
            resultSet.next();
            user.setUserId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setSurname(resultSet.getString(3));
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error("Select Max fail");
        } finally {
            DBCloseConnection.closeConnection(resultSet, statement, connection);
            LOG.debug("Connection close");
        }
        return user;
    }
}

