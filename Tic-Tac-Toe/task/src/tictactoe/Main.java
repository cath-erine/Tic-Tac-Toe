package tictactoe;

import java.util.Scanner;

public class Main {

    private static String boardState(char[][] board) {
        byte xCount = 0;
        byte oCount = 0;

        byte[] xRow = new byte[3];
        byte[] oRow = new byte[3];

        byte[] xCol = new byte[3];
        byte[] oCol = new byte[3];

        byte xDiagL = 0;
        byte xDiagR = 0;

        byte oDiagL = 0;
        byte oDiagR = 0;

        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    xCount++;
                    xCol[j]++;
                    xRow[i]++;
                    if (i == j) {
                        xDiagL++;
                    }
                    if (2 - i == j) {
                        xDiagR++;
                    }
                } else if (board[i][j] == 'O') {
                    oCount++;
                    oCol[j]++;
                    oRow[i]++;
                    if (i == j) {
                        oDiagL++;
                    }
                    if (2 - i == j) {
                        oDiagR++;
                    }
                }
            }
        }

        String state = null;

        if (Math.abs(xCount - oCount) > 1) {
            state = "Impossible";
        } else {
            if (xRow[0] == 3 || xRow[1] == 3 || xRow[2] == 3 || xCol[0] == 3 || xCol[1] == 3 || xCol[2] == 3 || xDiagR == 3 || xDiagL == 3) {
                state = "X wins";
            }

            if (oRow[0] == 3 || oRow[1] == 3 || oRow[2] == 3 || oCol[0] == 3 || oCol[1] == 3 || oCol[2] == 3 || oDiagR == 3 || oDiagL == 3) {
                if (state != null) {
                    state = "Impossible";
                } else {
                    state = "O wins";
                }
            }

            if (xCount + oCount == 9) {
                if (state == null) {
                    state = "Draw";
                }
            } else {
                if (state == null) {
                    state = "Game not finished";
                }
            }
        }
        return state;
    }

    private static void printBoard(char[][] board) {
        System.out.println("---------");
        for (byte i = 0; i < 3; i++) {
            System.out.print("| ");
            for (byte j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    private static void getMove(char[][] board, boolean turn, Scanner sc) {


        boolean happy = false;
        byte x;
        byte y;

        while (!happy) {
            System.out.print("Enter the coordinates: ");
            try {
                x = sc.nextByte();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                sc.nextLine();
                continue;
            }

            try {
                y = sc.nextByte();
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                sc.nextLine();
                continue;
            }

            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (board[x - 1][y - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            board[x - 1][y - 1] = turn ? 'X' : 'O';
            happy = true;
        }
    }

    public static void main(String[] args) {

        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

        printBoard(board);

        String state = "Game not finished";
        boolean turn = true; // true - 'X' false - 'O'
        Scanner sc = new Scanner(System.in);

        while (state.equals("Game not finished")) {
            getMove(board, turn, sc);
            printBoard(board);
            turn = !turn;
            state = boardState(board);
        }

        sc.close();

        System.out.println(state);
    }
}
