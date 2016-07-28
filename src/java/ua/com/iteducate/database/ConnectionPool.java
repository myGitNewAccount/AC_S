/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.database;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

/**
 *
 * @author Anton
 */
public class ConnectionPool {
    public static Connection createConnection() throws NamingException, SQLException {
        DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/WebMoney");
        return ds.getConnection();
    }
}
