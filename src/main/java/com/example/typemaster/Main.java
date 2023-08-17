package com.example.typemaster;

import com.example.typemaster.Data.EngWord;
import com.example.typemaster.Data.Postgre;
import com.example.typemaster.Data.RusWord;
import com.example.typemaster.Data.Sqlite;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, ParseException, InterruptedException {
        Postgre postgre = new Postgre();
        Sqlite.Conn();
        Sqlite.CreateDB();
        //System.out.println(Integer.parseInt("111"));
        Front.main(args);
    }
}
