package com.sistemi.informativi.connection;
import java.sql.*;

public class ConnectionManager implements com.sistemi.informativi.connection.DbParamateres {
    private static Connection con;
    //apre la connessione
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(con==null){
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
        }
        return con;
    }



    //restituisce PrepareredStatemant
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return con.prepareStatement(sql);

    }

    //restituisce statemant
    private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String dbUrl = "jdbc:mysql://localhost:3306/openjob";
    private static final String dbUser = "root";
    private static final String dbPass = "";



    //chiude la connessione
    public void closeConnection() throws SQLException, ClassNotFoundException {
        getConnection().close();
    }




}