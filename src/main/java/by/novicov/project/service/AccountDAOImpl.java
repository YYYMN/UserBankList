package by.novicov.project.service;

import by.novicov.project.dao.AccountDAO;
import by.novicov.project.dbconnector.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAOImpl implements AccountDAO{
    @Override
    public int sumOfAllBankAccounts() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int sum = 0;
        try {
            connection = DBConnector.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT SUM(account) FROM account");
            resultSet.next();
            sum = resultSet.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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

        return sum;
    }
}
