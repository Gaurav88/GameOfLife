package com.game.domain;

public enum CellState {
    Live("X"),
    Dead("-"),
    Tic("*");

    private String desc;

    CellState(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
