package com.sistemi.informativi.connection;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

//4 metodi: binding, opening, usage and closing of connections;
public class ConnectionManager implements DbParameters {
    public static Connection getConnection;
    private static Connection con;

    /**
     *
     * @return a connection object
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection GetConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName(dbDriver);
            return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        }
        return con;
    }

    /**
     *
     * @param sql, script that has the sql query
     * @return a Prepared statement necessary for the execution of the query
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static PreparedStatement GetPrepareStatement(String sql) throws SQLException, ClassNotFoundException {
        return GetConnection().prepareStatement(sql);
    }

    /**
     *
     * @param sql,  script that has the sql query
     * @return data structure that has the result of the query
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static ResultSet GetStatement(String sql) throws SQLException, ClassNotFoundException {
        return GetConnection().createStatement().executeQuery(sql);
    }

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void CloseConnection() throws SQLException, ClassNotFoundException {
        GetConnection().close();
    }

}
