package com.example.typemaster.Data;

import com.example.typemaster.Front;
import com.example.typemaster.Model.Result;

import java.sql.*;

public class Sqlite {
    public static Connection conn;
    public static Statement statmt;

    public static ResultSet resSet;
    public static void Conn() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Data.db");
        System.out.println("База Подключена!");
        statmt = conn.createStatement();
    }

    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists Result (\n" +
                "    id    INTEGER PRIMARY KEY,\n" +
                "    login TEXT,\n" +
                "    mode  TEXT,\n" +
                "    score TEXT,\n" +
                "    date  TEXT\n" +
                ");\n");
        System.out.println("Таблица создана или уже существует.");
    }

    public static void addResult(String login, String mode, String score, String date) throws SQLException {
        statmt.execute("INSERT INTO 'Result' ('login', 'mode', 'score', 'date') VALUES ('"+ login+"', '" + mode +
                "', '" + score + "', '" + date + "');");
    }

    public static String getMaxResult(String mode) throws SQLException {
        resSet=statmt.executeQuery("select max(score) from Result "  +
                " where mode ='"+ mode + "' and login = '"+ Front.login+"';");
        String ans = resSet.getString("max(score)");
        return ans;
    }

    public static String getCount() throws SQLException {
        resSet = statmt.executeQuery("Select count(id) from Result WHERE login = '"+ Front.login+"';");
        String ans = resSet.getString("count(id)");
        return ans;
    }

    public static Result[] getMyResult() throws SQLException {
        String kol = getCount();
        int k = Integer.parseInt(kol);
        Result[] results = new Result[k];
        int count = 1;
        int i=0;
        resSet = statmt.executeQuery("SELECT * FROM Result WHERE login = '"+ Front.login+"' ORDER BY score desc;");
        while (resSet.next()){
            String mode = resSet.getString("mode");
            String date = resSet.getString("date");
            String score = resSet.getString("score");
            results[i] = new Result(String.valueOf(count),date,score,mode);
            i++;
            count++;
        }
        return results;
    }
}
