package com.game.domain;

public class Cell {
    private CellState state = CellState.Dead;

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
