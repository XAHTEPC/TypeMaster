package com.example.typemaster.View;

import com.example.typemaster.Data.Postgre;
import com.example.typemaster.Data.Sqlite;
import com.example.typemaster.Front;
import com.example.typemaster.GameLogic.Score;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreFront {
    public static Button tryAgain;
    public static Button ToMain;
    public static Button ToRes;
    public static Pane getScoreFront(int fl) throws FileNotFoundException, SQLException {
        Pane pane = new Pane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        FileInputStream Url;
        if(Front.theme == 1)
            Url = new FileInputStream("png/score_day.png");
        else
            Url = new FileInputStream("png/score_night.png");
        Image url = new Image(Url);
        ImageView front = new ImageView(url);
        front.setX(0);
        front.setY(0);
        pane.getChildren().add(front);

        AddUpdateScore(fl);

        Text text_score = new Text();
        text_score.setText(Score.text_score.getText());
        text_score.setLayoutX(810);
        text_score.setLayoutY(400);
        if(Front.theme == 1)
            text_score.setFill(Color.rgb(255,184,0));
        else
            text_score.setFill(Color.rgb(169,110,228));
        text_score.setFont(Font.font("Joast", 100));
        pane.getChildren().add(text_score);

        tryAgain = new Button();
        tryAgain.setLayoutX(39);
        tryAgain.setLayoutY(742);
        tryAgain.setMaxSize(335, 21);
        tryAgain.setMinSize(335, 21);
        tryAgain.setBackground(null);
        pane.getChildren().add(tryAgain);

        ToMain = new Button();
        ToMain.setLayoutX(455);
        ToMain.setLayoutY(742);
        ToMain.setMaxSize(271, 21);
        ToMain.setMinSize(271, 21);
        ToMain.setBackground(null);
        pane.getChildren().add(ToMain);

        ToRes = new Button();
        ToRes.setLayoutX(807);
        ToRes.setLayoutY(742);
        ToRes.setMaxSize(353, 21);
        ToRes.setMinSize(353, 21);
        ToRes.setBackground(null);
        pane.getChildren().add(ToRes);

        tryAgain.setOnAction(t ->{
            if(fl==0)
                Front.startRus();
            else if(fl==1)
                Front.startEng();
            else
                Front.startText();
        });
        ToMain.setOnAction(t ->{
            Front.mainMenu();
        });
        ToRes.setOnAction(t ->{
            Front.result();
        });
        return pane;
    }

    public static void AddUpdateScore(int fl) throws SQLException {
        if(fl==0){
            String score = String.valueOf(Score.text_score.getText());
            Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date date = new Date();
            String string = formatter.format(date);
            Sqlite.addResult(Front.login,"Русские символы",score,string);
            String max = Sqlite.getMaxResult("Русские символы");
            Postgre.UpdateMode1(max);
        }
        else if(fl==1){
            String score = String.valueOf(Score.text_score.getText());
            Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date date = new Date();
            String string = formatter.format(date);
            Sqlite.addResult(Front.login,"Английские символы",score,string);
            String max = Sqlite.getMaxResult("Английские символы");
            Postgre.UpdateMode2(max);
        }
        else {
            String score = String.valueOf(Score.text_score.getText());
            Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date date = new Date();
            String string = formatter.format(date);
            Sqlite.addResult(Front.login,"Русский текст",score,string);
            String max = Sqlite.getMaxResult("Русский текст");
            Postgre.UpdateMode3(max);
        }

    }

}
