package com.example.typemaster.GameLogic;

import com.example.typemaster.Data.Postgre;
import com.example.typemaster.Data.Sqlite;
import com.example.typemaster.Model.Result;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class ToWord {
    public static void ConvertToWord(String name) throws SQLException {
        String fileName = "report\\"+name+".docx";
        Result[] mas = Sqlite.getMyResult();

        try (XWPFDocument doc = new XWPFDocument()) {

            XWPFParagraph p1 = doc.createParagraph();
            p1.setAlignment(ParagraphAlignment.CENTER);

            // set font
            XWPFRun r1 = p1.createRun();
            r1.setBold(true);
            r1.setItalic(true);
            r1.setFontSize(22);
            r1.setFontFamily("New Roman");
            r1.setText("Мои результаты");

            XWPFTable table = doc.createTable();
            table.setTableAlignment(TableRowAlign.CENTER);
            XWPFTableRow row;
            //System.out.println("mas.length" + mas.length);
            for (int i = -1; i < mas.length; i++) {
                System.out.println("i: "+ i);
                if(i>-1) {row = table.createRow();
                    System.out.println(mas[i].date);
                    row.getCell(0).setText(mas[i].count);
                    row.getCell(1).setText(mas[i].mode);
                    row.getCell(2).setText(mas[i].score);
                    row.getCell(3).setText(mas[i].date);
                }
                //Creating first Row
                if (i == -1) {
                    row = table.getRow(0);
                    row.getCell(0).setText("#");
                    row.getCell(0).setWidth("10%");
                    row.addNewTableCell().setText("Режим");
                    row.getCell(1).setWidth("30%");
                    row.addNewTableCell().setText("Результат");
                    row.getCell(2).setWidth("30%");
                    row.addNewTableCell().setText("Дата");
                    row.getCell(3).setWidth("30%");
                }

            }
            // save it to .docx file
            try (FileOutputStream out = new FileOutputStream(fileName)) {
                doc.write(out);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
