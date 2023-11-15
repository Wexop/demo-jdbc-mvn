package fr.epsi.b32324c2.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static fr.epsi.b32324c2.Main.*;

public class PersistenceManager {
    private static Connection cnx;
    public static Connection getConnection() throws Exception{
        if(cnx == null || cnx.isClosed()){
            cnx = DriverManager.getConnection(BDD_URL,USER,PASSWORD);
        }
        return cnx;
    }
    public static void closeConnection(Connection cnxToClose) throws Exception {
        if(cnx == cnxToClose && cnxToClose != null && !cnxToClose.isClosed()){
            cnx.close();
        }
    }
}
