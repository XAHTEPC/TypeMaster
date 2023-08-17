package com.example.typemaster.Model;

public class Result {
    public String count;
    public String login;
    public String mode1;
    public String mode2;
    public String mode3;
    public String summa;
    public String date;
    public String score;
    public String mode;

    public Result(String count, String login, String mode1, String mode2, String mode3, String summa) {
        this.count = count;
        this.login = login;
        this.mode1 = mode1;
        this.mode2 = mode2;
        this.mode3 = mode3;
        this.summa = summa;
    }

    public Result(String count, String date, String score, String mode) {
        this.count = count;
        this.date = date;
        this.score = score;
        this.mode = mode;
    }
}
