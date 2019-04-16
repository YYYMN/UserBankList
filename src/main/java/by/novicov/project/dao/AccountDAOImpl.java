package by.novicov.project.dao;

import by.novicov.project.dbconnector.DBCloseConnection;
import by.novicov.project.dbconnector.DBConnector;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAOImpl implements AccountDAO {
    private final static Logger LOG = Logger.getLogger(AccountDAOImpl.class);
    @Override
    public int sumOfAllBankAccounts() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int sum = 0;
        try {
            connection = DBConnector.getConnection();
            LOG.debug("Connection start");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT SUM(account) FROM account");
            resultSet.next();
            sum = resultSet.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            LOG.error("Select SUM is failed", e);
        } finally {
            DBCloseConnection.closeConnection(resultSet, statement, connection);
            LOG.debug("Connection close");
        }
        return sum;
    }
}
