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

        public int deleteCar(int car_id)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT deleteCar("+car_id+");");
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

        public int insertCar(String new_name, String new_licenceplate, int new_garage_id, int new_klilometers)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT insertCar('"+new_name+"', '"+new_licenceplate+"', "+new_garage_id+", "+new_klilometers+");");
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

        public int insertUser(String new_firstname, String new_surname, String new_birth, int new_city_id, String new_email, String new_username, String new_password)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT insertUser('"+new_firstname+"', '"+new_surname+"', '"+new_birth+"', "+new_city_id+", '"+new_email+"', '"+new_username+"', '"+new_password+"');");
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

        public int deleteUser(int user_id)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT deleteUser("+user_id+");");
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

        public int resetPassword(String old_username, String new_password)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT resetPassword('"+old_username+"', '"+new_password+"');");
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


        public ResultSet getAllCities()
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getAllCities()");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public ResultSet getSpecCity(int id)
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getSpecCity("+id+")");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public int updateCity(String old_name, String new_name, int new_post)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT updateCity('"+old_name+"', '"+new_name+"', "+new_post+");");
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

        public int insertCity(String new_name, int new_post)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT insertCity('"+new_name+"', "+new_post+");");
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

        public int deleteCity(int city_id)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT deleteCity("+city_id+");");
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












        public ResultSet getAllConfirmedRents()
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getAllConfirmedrents()");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public ResultSet getSpecConfirmedRent(int id)
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getSpecConfirmedrent("+id+")");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public int updateConfirmedRent(int new_id, int new_car_id, int new_kilometersmade, String new_comment, int new_rent_id)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT updateConfirmedrent("+new_id+", "+new_car_id+", "+new_kilometersmade+", '"+new_comment+"', "+new_rent_id+");");
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

        public int insertConfirmedRent(int new_car_id, int new_kilometersmade, String new_comment, int new_rent_id)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT insertConfirmedrent("+new_car_id+", "+new_kilometersmade+", '"+new_comment+"', "+new_rent_id+");");
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

        public int deleteConfirmedRent(int confirmedrent_id)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT deleteConfirmedRent("+confirmedrent_id+");");
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







        public ResultSet getAllRents()
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getAllrents()");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public ResultSet getSpecRent(int id)
    {
        ResultSet rst = null;
        try
        {
            Statement stmt = conn.createStatement();

            rst = stmt.executeQuery("SELECT * FROM getSpecRent("+id+")");

            return rst;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return rst;
    }

    public int updateRent(int new_id, int new_user_id, int new_car_id, String new_fromdate, String new_todate, int new_completed)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT updateRent("+new_id+", "+new_user_id+", "+new_car_id+", '"+new_fromdate+"', '"+new_todate+"', "+new_completed+");");
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

        public int insertRent(int new_user_id, int new_car_id, String new_fromdate, String new_todate)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT insertRent("+new_user_id+", "+new_car_id+", '"+new_fromdate+"', '"+new_todate+"');");
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

        public int deleteRent(int rent_id)
        {
            int success = 0;
            try
            {
                Statement stmt = conn.createStatement();

                success = stmt.executeUpdate("SELECT deleteRent("+rent_id+");");
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
