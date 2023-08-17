package com.example.typemaster.View;

import com.example.typemaster.Data.Postgre;
import com.example.typemaster.Front;
import com.example.typemaster.GameLogic.ToWord;
import com.example.typemaster.Model.Result;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ResultFront {
    static Text[][] text_result = new Text[12][6];
    public static Pane getStartFront() throws FileNotFoundException, SQLException {
        Pane pane = new Pane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        FileInputStream Url;
        if(Front.theme ==1)
            Url = new FileInputStream("png/result_day.png");
        else
            Url = new FileInputStream("png/result_night.png");
        Image url = new Image(Url);
        ImageView front = new ImageView(url);
        front.setX(0);
        front.setY(0);
        pane.getChildren().add(front);

        Result[] results = Postgre.getTop10();
        int y = 180;
        for (int i = 0, j=-1; i < 10; i++, y += 53, j++) {
            if (i == 0) {
                text_result[i][0] = new Text();
                text_result[i][0].setText("#");
                text_result[i][0].setX(120);
                text_result[i][0].setY(y);
                text_result[i][0].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][0]);

                text_result[i][1] = new Text();
                text_result[i][1].setText("Логин");
                text_result[i][1].setX(200);
                text_result[i][1].setY(y);
                text_result[i][1].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][1]);

                text_result[i][2] = new Text();
                text_result[i][2].setText("Русские символы");
                text_result[i][2].setX(350);
                text_result[i][2].setY(y);
                text_result[i][2].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][2]);

                text_result[i][3] = new Text();
                text_result[i][3].setText("Английские символы");
                text_result[i][3].setX(550);
                text_result[i][3].setY(y);
                text_result[i][3].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][3]);

                text_result[i][4] = new Text();
                text_result[i][4].setText("Русский текст");
                text_result[i][4].setX(800);
                text_result[i][4].setY(y);
                text_result[i][4].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][4]);

                text_result[i][5] = new Text();
                text_result[i][5].setText("Σ");
                text_result[i][5].setX(1020);
                text_result[i][5].setY(y);
                text_result[i][5].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][5]);

            } else if(results[j] != null) {
                text_result[i][0] = new Text();
                text_result[i][0].setText(results[j].count);
                text_result[i][0].setX(110);
                text_result[i][0].setY(y);
                text_result[i][0].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][0]);

                text_result[i][1] = new Text();
                text_result[i][1].setText(results[j].login);
                text_result[i][1].setX(200);
                text_result[i][1].setY(y);
                text_result[i][1].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][1]);

                text_result[i][2] = new Text();
                text_result[i][2].setText(results[j].mode1);
                text_result[i][2].setX(400);
                text_result[i][2].setY(y);
                text_result[i][2].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][2]);

                text_result[i][3] = new Text();
                text_result[i][3].setText(results[j].mode2);
                text_result[i][3].setX(640);
                text_result[i][3].setY(y);
                text_result[i][3].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][3]);

                text_result[i][4] = new Text();
                text_result[i][4].setText(results[j].mode3);
                text_result[i][4].setX(840);
                text_result[i][4].setY(y);
                text_result[i][4].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][4]);

                text_result[i][5] = new Text();
                text_result[i][5].setText(results[j].summa);
                text_result[i][5].setX(1010);
                text_result[i][5].setY(y);
                text_result[i][5].setFont(Font.font("Constania", 20));
                pane.getChildren().add(text_result[i][5]);
            }
        }
        y+=53;
        Result myRes = Postgre.getMyResult();
        text_result[11][0] = new Text();
        text_result[11][0].setText(myRes.count);
        text_result[11][0].setX(110);
        text_result[11][0].setY(y);
        text_result[11][0].setFont(Font.font("Constania", 20));
        pane.getChildren().add(text_result[11][0]);

        text_result[11][1] = new Text();
        text_result[11][1].setText(myRes.login);
        text_result[11][1].setX(200);
        text_result[11][1].setY(y);
        text_result[11][1].setFont(Font.font("Constania", 20));
        pane.getChildren().add(text_result[11][1]);

        text_result[11][2] = new Text();
        text_result[11][2].setText(myRes.mode1);
        text_result[11][2].setX(400);
        text_result[11][2].setY(y);
        text_result[11][2].setFont(Font.font("Constania", 20));
        pane.getChildren().add(text_result[11][2]);

        text_result[11][3] = new Text();
        text_result[11][3].setText(myRes.mode2);
        text_result[11][3].setX(640);
        text_result[11][3].setY(y);
        text_result[11][3].setFont(Font.font("Constania", 20));
        pane.getChildren().add(text_result[11][3]);

        text_result[11][4] = new Text();
        text_result[11][4].setText(myRes.mode3);
        text_result[11][4].setX(840);
        text_result[11][4].setY(y);
        text_result[11][4].setFont(Font.font("Constania", 20));
        pane.getChildren().add(text_result[11][4]);

        text_result[11][5] = new Text();
        text_result[11][5].setText(myRes.summa);
        text_result[11][5].setX(1010);
        text_result[11][5].setY(y);
        text_result[11][5].setFont(Font.font("Constania", 20));
        pane.getChildren().add(text_result[11][5]);

        Button export = new Button();
        export.setLayoutX(1100);
        export.setLayoutY(745);
        export.setMaxSize(40,40);
        export.setMinSize(40,40);
        export.setBackground(null);
        pane.getChildren().add(export);

        Button back = new Button();
        back.setLayoutX(100);
        back.setLayoutY(44);
        back.setMaxSize(200,100);
        back.setMinSize(200,100);
        back.setBackground(null);
        pane.getChildren().add(back);

        back.setOnAction(t ->{
            Front.mainMenu();
        });

        export.setOnAction(t1->{
            try {
                ToWord.ConvertToWord(Front.login);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });




        return pane;
    }


}
