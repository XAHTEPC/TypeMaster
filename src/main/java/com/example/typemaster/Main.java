package com.example.typemaster;

import com.example.typemaster.Data.Postgre;
import com.example.typemaster.Data.Sqlite;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, ParseException, InterruptedException {
        Postgre postgre = new Postgre();
        Sqlite.Conn();
        Sqlite.CreateDB();
        //System.out.println(Integer.parseInt("111"));
        Front.main(args);
    }
}
