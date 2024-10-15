package com.example.stickherogameproject;

public class GameController {
    private static GameController instance;
    private int a;
    private int b;

    private int c;

    private GameController() {
        a = 0;
        b = 0;
        c=0;
    }
    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }
    public class GameClass {
        private int filed;

        public int getFiled() {
            return filed;
        }

        public void setFiled(int filed) {
            this.filed = filed;
        }

        public GameClass(int filed) {
            this.filed = filed;
        }
    }
    public int getA() {
        return a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
