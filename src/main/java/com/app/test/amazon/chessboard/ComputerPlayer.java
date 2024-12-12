package com.app.test.amazon.chessboard;

public class ComputerPlayer extends Player {

    public ComputerPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
    }
}
