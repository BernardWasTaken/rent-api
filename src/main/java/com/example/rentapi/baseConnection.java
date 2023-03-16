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

            
            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public ResultSet getSpecUser(String username)
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getUserInfo3('"+username+"')");

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

    public ResultSet getAllCars()
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getAllCars()");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public ResultSet getSpecCar(int id)
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getSpecCar("+id+")");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public int updateUser(String old_username, String new_username, String new_firstname, String new_surname, String new_password)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT updateUser('"+old_username+"', '"+new_username+"', '"+new_password+"', '"+new_firstname+"', '"+new_surname+"');");
                if(success > 0)
                {
                    return 1;
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            return 0;
        }


        public int updateCar(int car_id, String new_name, String new_licenceplate, int new_garage_id, int new_klilometers)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT updateCar("+car_id+", '"+new_name+"', '"+new_licenceplate+"', "+new_garage_id+", "+new_klilometers+");");
                if(success > 0)
                {
                    return 1;
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            return 0;
        }

    
}
