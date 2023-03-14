package com.example.rentapi;

import java.sql.*;
import org.json.*;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

public class baseConnection {
    static Connection conn = null;

    public static void connect() {
        try {
             String url = "jdbc:postgresql://rogue.db.elephantsql.com/fatthupg";
             String user = "fatthupg";
             String password = "Irg29IwQslA9grsy56gAY5mpmUs6SN-U";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public ResultSet getAllUsers()
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getAllUsers()");

            if(rst.next())
            {
                return rst;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }
}
