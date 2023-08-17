package com.example.typemaster.Data;

import com.example.typemaster.Front;
import com.example.typemaster.Model.Result;

import java.io.FileNotFoundException;
import java.sql.*;

public class Postgre {

    static Connection connection;
    static Statement statmt;

    static ResultSet resultSet;

    public Postgre() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kefir","postgres","123");
        statmt = connection.createStatement();
    }

    public  static void addUser(String login, String password) throws SQLException, FileNotFoundException, ClassNotFoundException {
        statmt = connection.createStatement();
        statmt.execute("INSERT INTO public.\"Result\"(\n" +
                "\tlogin, password)\n" +
                "\tVALUES ('" + login + "', '" + password + "');");
        Front.id = getID(login,password);
        Front.login = login;
    }

    public static Boolean checkLogin(String login) throws SQLException {
        String s = "true";
        resultSet = statmt.executeQuery("SELECT id FROM public.\"Result\" WHERE login = '" + login +"';");
        while (resultSet.next()){
            s = resultSet.getString("id");
        }
        if(s.equals("true"))
            return true;
        else
            return false;
    }

    public static String getID(String login, String password) throws SQLException {
        String id="error";
        resultSet = statmt.executeQuery("SELECT * FROM public.\"Result\" WHERE login = '" + login +
                "' and password ='" + password+"';");
        while(resultSet.next()){
            id = resultSet.getString("id");
        }
        return id;
    }

    public static void UpdateMode1(String res) throws SQLException {
        statmt.execute("UPDATE public.\"Result\"\n" +
                "\tSET mode1 = '" + res + "'\n" +
                "\tWHERE id = "+ Front.id +";");
    }

    public static void UpdateMode2(String res) throws SQLException {
        statmt.execute("UPDATE public.\"Result\"\n" +
                "\tSET mode2 = '" + res + "'\n" +
                "\tWHERE id = "+ Front.id +";");
    }

    public static void UpdateMode3(String res) throws SQLException {
        statmt.execute("UPDATE public.\"Result\"\n" +
                "\tSET mode3 = '" + res + "'\n" +
                "\tWHERE id = "+ Front.id +";");
    }

    public static Result[] getTop10() throws SQLException {
        Result[] mas = new Result[10];
        int i =0;
        resultSet = statmt.executeQuery("Select login, mode1, mode2, mode3, mode1+mode2+mode3 as summa from \"Result\"\n" +
                "ORDER BY summa desc\n" +
                "LIMIT 10\n" +
                ";");
        while(resultSet.next()){
            String login;
            String mode1;
            String mode2;
            String mode3;
            String summa;
            String count = String.valueOf(i+1);
            login = resultSet.getString("login");
            mode1 = resultSet.getString("mode1");
            mode2 = resultSet.getString("mode2");
            mode3 = resultSet.getString("mode3");
            summa = resultSet.getString("summa");
            mas[i] = new Result(count,login,mode1,mode2,mode3,summa);
            i++;
        }
        return mas;
    }

    public static Result getMyResult() throws SQLException {
        resultSet = statmt.executeQuery("Select login, mode1, mode2, mode3, mode1+mode2+mode3 as summa from \"Result\"\n" +
                "where login = '" + Front.login +"';");
        Result mas = null;
        while(resultSet.next()){
            String count;
            String login;
            String mode1;
            String mode2;
            String mode3;
            String summa;
            login = resultSet.getString("login");
            mode1 = resultSet.getString("mode1");
            mode2 = resultSet.getString("mode2");
            mode3 = resultSet.getString("mode3");
            summa = resultSet.getString("summa");
            count = getPlace(summa);
            int t = Integer.parseInt(count);
            t++;
            mas = new Result(String.valueOf(t),login,mode1,mode2,mode3,summa);
        }
        return mas;
    }
    public static String getPlace(String summa) throws SQLException {
        resultSet = statmt.executeQuery("SELECT count(id) from \"Result\" \n" +
                "WHERE mode1+mode2+mode3 > '" + summa +"';");
        String res ="";
        while(resultSet.next()){
            res =resultSet.getString("count");
        }
        return res;
    }
}
