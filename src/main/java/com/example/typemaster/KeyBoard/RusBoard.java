package com.example.typemaster.KeyBoard;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class RusBoard {
    public static Rectangle rect1 = new Rectangle(311, 140, 54, 54) ; //а
    public static Rectangle rect2 = new Rectangle(597, 202, 54, 54) ; //б
    public static Rectangle rect3 = new Rectangle(249, 140, 54, 54) ; //в
    public static Rectangle rect4 = new Rectangle(486, 76, 54, 54) ; //г
    public static Rectangle rect5 = new Rectangle(629, 140, 54, 54) ; //д
    public static Rectangle rect6 = new Rectangle(360, 76, 54, 54); //е
    public static Rectangle rect7 = new Rectangle(12, 12, 54, 54); //ё
    public static Rectangle rect8 = new Rectangle(692, 140, 54, 54) ; //ж
    public static Rectangle rect9 = new Rectangle(677, 76, 54, 54); //з
    public static Rectangle rect10 = new Rectangle(407, 202, 54, 54) ; //и
    public static Rectangle rect11 = new Rectangle(107, 76, 54, 54) ; //й
    public static Rectangle rect12 = new Rectangle(296, 76, 54, 54) ; //к
    public static Rectangle rect13 = new Rectangle(565, 140, 54, 54) ; //л
    public static Rectangle rect14 = new Rectangle(345, 202, 54, 54) ; //м
    public static Rectangle rect15 = new Rectangle(424, 76, 54, 54) ; //н
    public static Rectangle rect16 = new Rectangle(502, 140, 54, 54) ; //о
    public static Rectangle rect17 = new Rectangle(375, 140, 54, 54) ; //п
    public static Rectangle rect18 = new Rectangle(439, 140, 54, 54) ; //р
    public static Rectangle rect19 = new Rectangle(281, 202, 54, 54) ; //с
    public static Rectangle rect20 = new Rectangle(470, 202, 54, 54) ; //т
    public static Rectangle rect21 = new Rectangle(234, 76, 54, 54) ; //у
    public static Rectangle rect22 = new Rectangle(123, 140, 54, 54) ; //ф
    public static Rectangle rect23 = new Rectangle(740, 76, 54, 54) ; //х
    public static Rectangle rect24 = new Rectangle(171, 76, 54, 54) ; //ц
    public static Rectangle rect25 = new Rectangle(217, 202, 54, 54) ; //ч
    public static Rectangle rect26 = new Rectangle(550, 76, 54, 54) ; //ш
    public static Rectangle rect27 = new Rectangle(614, 76, 54, 54) ; //щ
    public static Rectangle rect28 = new Rectangle(803, 76, 54, 54) ; //ъ
    public static Rectangle rect29 = new Rectangle(186, 140, 54, 54) ; //ы
    public static Rectangle rect30 = new Rectangle(534, 202, 54, 54) ; //ь
    public static Rectangle rect31 = new Rectangle(754, 140, 54, 54) ; //э
    public static Rectangle rect32 = new Rectangle(661, 202, 54, 54) ; //ю
    public static Rectangle rect33 = new Rectangle(155, 202, 54, 54) ; //я
    public static Rectangle rectSpace = new Rectangle(253, 268, 370, 50) ; //пробел
    public static Rectangle rectDot = new Rectangle(726, 202, 54, 54) ; //.

    public static Rectangle recctMin = new Rectangle(710,15,54,54);//-
    public static Rectangle rectQes = new Rectangle(456,15,54,54);//?
    public static Rectangle rectDoub = new Rectangle(391,15,54,54);//:
    public static Rectangle rectDoubDot = new Rectangle(264,15,54,54);//;
    public static Rectangle rectq = new Rectangle(139,15,54,54);//"
    public static Rectangle rectP = new Rectangle(76,15,54,54);//!


    public static Rectangle getRect(char c){
        if(c == 'а' || c == 'А')
            return rect1;
        else if(c == 'б' || c == 'Б')
            return rect2;
        else if(c == 'в' || c == 'В')
            return rect3;
        else if(c == 'г' || c == 'Г')
            return rect4;
        else if(c == 'д' || c == 'Д')
            return rect5;
        else if(c == 'е' || c == 'Е')
            return rect6;
        else if(c == 'ё' || c == 'Ё')
            return rect7;
        else if(c == 'ж' || c == 'Ж')
            return rect8;
        else if(c == 'з' || c == 'З')
            return rect9;
        else if(c == 'и' || c == 'И')
            return rect10;
        else if(c == 'й' || c == 'Й')
            return rect11;
        else if(c == 'к' || c == 'К')
            return rect12;
        else if(c == 'л' || c == 'Л')
            return rect13;
        else if(c == 'м' || c == 'М')
            return rect14;
        else if(c == 'н' || c == 'Н')
            return rect15;
        else if(c == 'о' || c == 'О')
            return rect16;
        else if(c == 'п' || c == 'П')
            return rect17;
        else if(c == 'р' || c == 'Р')
            return rect18;
        else if(c == 'с' || c == 'С')
            return rect19;
        else if(c == 'т' || c == 'Т')
            return rect20;
        else if(c == 'у' || c == 'У')
            return rect21;
        else if(c == 'ф' || c == 'Ф')
            return rect22;
        else if(c == 'х' || c == 'Х')
            return rect23;
        else if(c == 'ц' || c == 'Ц')
            return rect24;
        else if(c == 'ч' || c == 'Ч')
            return rect25;
        else if(c == 'ш' || c == 'Ш')
            return rect26;
        else if(c == 'щ' || c == 'Щ')
            return rect27;
        else if(c == 'ъ' || c == 'Ъ')
            return rect28;
        else if(c == 'ы' || c == 'Ы')
            return rect29;
        else if(c == 'ь' || c == 'Ь')
            return rect30;
        else if(c == 'э' || c == 'Э')
            return rect31;
        else if(c == 'ю' || c == 'Ю')
            return rect32;
        else if(c=='я' || c == 'Я')
            return rect33;
        else if(c=='!')
            return rectP;
        else if(c=='\"')
            return rectq;
        else if(c==';')
            return rectDoubDot;
        else if(c==':')
            return rectDoub;
        else if(c=='?')
            return rectQes;
        else if(c=='-')
            return recctMin;
        else if(c=='.' || c ==',')
            return rectDot;
        else
            return rectSpace;
    }

    public static boolean check(char c){
        if(c=='А'||c=='Б'||c=='В'||c=='Г'||c=='Д'||c=='Е'||c=='Ё'||c=='Ж'||c=='З'||c=='И'||c=='Й'||c=='К'||c=='Л'
                ||c=='М'||c=='Н'||c=='О'||c=='П'||c=='Р'||c=='С'||c=='Т'||c=='У'||c=='Ф'||c=='Х'||c=='Ц'||c=='Ч'
                ||c=='Ш'||c=='Щ'||c=='Ъ'||c=='Ы'||c=='Ь'||c=='Э'||c=='Ю'||c=='Я'||c=='!'||c=='\"'||c==';'||c==':'
                ||c=='?'||c==',')
            return true;
        else return false;
    }

}
