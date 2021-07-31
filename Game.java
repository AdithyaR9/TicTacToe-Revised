import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {

    private Canvas canvas;
    double X = 0;
    double Y = 0;
    private boolean XplayerTurn = true;
    private int winner = -1; // 0 is for O, 1 is for X
    private boolean gameOver = false;
    private boolean isTieGame = false;
    private int xWins = 0;
    private int oWins = 0;
    private int tieGames = 0;

    private char[][] board = {{'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // setting the window title
        primaryStage.setTitle("Tic Tac Toe");
        // creating new group
        Group group = new Group();
        // creating a new Canvas of 400 by 400 pixels
        canvas = new Canvas(400, 400);

        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                X = event.getX();
                Y = event.getY();

                // System.out.println("X value: " + X);
                // System.out.println("Y value: " + Y);
                // System.out.println(XplayerTurn);

                // if game is still going,
                if (!gameOver) {
                    // place player move
                    place(X, Y);

                    // check if game is over
                    if (isGameOver()) {
                        drawStuff(canvas.getGraphicsContext2D());
                    } else {
                        // switch player turn
                        XplayerTurn = !XplayerTurn;
                    }
                }

            }
        });
        // resets game with 'n'
        canvas.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String key = event.getCharacter();
                if (key.equals("n")) {
                    // reset game
                    if (gameOver) {
                        reset();
                    }
                }
            }
        });

        // adding 'canvas' to the project group
        group.getChildren().add(canvas);
        // creating a new scene with 'group'
        Scene scene = new Scene(group);
        // setting the scene of the project stage to 'scene'
        primaryStage.setScene(scene);

        // drawing on Canvas
        drawStuff(canvas.getGraphicsContext2D());

        canvas.requestFocus();
        // display the project
        primaryStage.show();
    }

    private void place(double X, double Y) {
        // X player's turn
        if (XplayerTurn) {
            // if clicked first column
            if (70 < X && X < 145) {
                // clicked top box
                if (70 < Y && Y < 145) {
                    if (board[0][0] == '-') {
                        board[0][0] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked middle box
                else if (145 < Y && Y < 255) {
                    if (board[1][0] == '-') {
                        board[1][0] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked bottom box
                else if (255 < Y && Y < 330) {
                    if (board[2][0] == '-') {
                        board[2][0] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
            }
            // if clicked middle column
            else if (145 < X && X < 255) {
                // clicked top box
                if (70 < Y && Y < 145) {
                    if (board[0][1] == '-') {
                        board[0][1] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked middle box
                else if (145 < Y && Y < 255) {
                    if (board[1][1] == '-') {
                        board[1][1] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked bottom box
                else if (255 < Y && Y < 330) {
                    if (board[2][1] == '-') {
                        board[2][1] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
            }
            // if clicked last column
            else if (255 < X && X < 330) {
                // clicked top box
                if (70 < Y && Y < 145) {
                    if (board[0][2] == '-') {
                        board[0][2] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked middle box
                else if (145 < Y && Y < 255) {
                    if (board[1][2] == '-') {
                        board[1][2] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked bottom box
                else if (255 < Y && Y < 330) {
                    if (board[2][2] == '-') {
                        board[2][2] = 'X';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
            }
        }
        // O player's turn
        else {
            // if clicked first column
            if (70 < X && X < 145) {
                // clicked top box
                if (70 < Y && Y < 145) {
                    if (board[0][0] == '-') {
                        board[0][0] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked middle box
                else if (145 < Y && Y < 255) {
                    if (board[1][0] == '-') {
                        board[1][0] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked bottom box
                else if (255 < Y && Y < 330) {
                    if (board[2][0] == '-') {
                        board[2][0] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
            }
            // if clicked middle column
            else if (145 < X && X < 255) {
                // clicked top box
                if (70 < Y && Y < 145) {
                    if (board[0][1] == '-') {
                        board[0][1] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked middle box
                else if (145 < Y && Y < 255) {
                    if (board[1][1] == '-') {
                        board[1][1] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked bottom box
                else if (255 < Y && Y < 330) {
                    if (board[2][1] == '-') {
                        board[2][1] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
            }
            // if clicked last column
            else if (255 < X && X < 330) {
                // clicked top box
                if (70 < Y && Y < 145) {
                    if (board[0][2] == '-') {
                        board[0][2] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked middle box
                else if (145 < Y && Y < 255) {
                    if (board[1][2] == '-') {
                        board[1][2] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
                // clicked bottom box
                else if (255 < Y && Y < 330) {
                    if (board[2][2] == '-') {
                        board[2][2] = 'O';
                        drawStuff(canvas.getGraphicsContext2D());
                    }
                }
            }
        }
    }

    private boolean isGameOver() {
        // rows
        for (int r = 0; r < 3; r++) {
            if (board[r][0] != '-' && (board[r][0] == board[r][1] && board[r][0] == board[r][2])) {
                gameOver = true;
                if (XplayerTurn) {
                    winner = 1;
                    xWins++;
                } else {
                    winner = 0;
                    oWins++;
                }
                return true;
            }
        }
        // columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c] != '-' && (board[0][c] == board[1][c] && board[0][c] == board[2][c])) {
                gameOver = true;
                if (XplayerTurn) {
                    winner = 1;
                    xWins++;
                } else {
                    winner = 0;
                    oWins++;
                }
                return true;
            }
        }
        // diagonals
        if ((board[0][0] != '-' && ((board[0][0] == board[1][1] && board[0][0] == board[2][2]))) ||
                board[0][2] != '-' && ((board[0][2] == board[1][1] && board[0][2] == board[2][0]))) {
            gameOver = true;
            if (XplayerTurn) {
                winner = 1;
                xWins++;
            } else {
                winner = 0;
                oWins++;
            }
            return true;
        }
        // checks for tie game
        int filledSpots = 0;
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++) {
                if (board[r][c] != '-') {
                    filledSpots++;
                }
            }
        if (filledSpots == 9) {
            isTieGame = true;
            gameOver = true;
            tieGames++;
            return true;
        }
        return false;
    }

    private void reset() {
        // reset all game variables
        X = 0;
        Y = 0;
        XplayerTurn = !XplayerTurn;
        winner = -1; // 0 is for O, 1 is for X
        gameOver = false;
        isTieGame = false;
        board = new char[][]{{'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}};
        // redraw canvas to reflect reset
        drawStuff(canvas.getGraphicsContext2D());
    }

    private void drawStuff(GraphicsContext gc) {
        // making background black
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 400, 400);

        // making the board lines (white)
        gc.setStroke(Color.WHITE);
        // vertical lines
        gc.strokeLine(157, 70, 157, 330);
        gc.strokeLine(243, 70, 243, 330);
        // horizontal lines
        gc.strokeLine(70, 157, 330, 157);
        gc.strokeLine(70, 243, 330, 243);

        // Win amounts Text
        gc.strokeText("X Wins: " + xWins, 300, 15);
        gc.strokeText("O Wins: " + oWins, 300, 35);
        gc.strokeText("Ties: " + tieGames, 300, 55);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == 'X') {
                    gc.setStroke(Color.RED);
                    double x1 = 88 + (87 * c);
                    double y1 = 88 + (87 * r);
                    gc.strokeLine(x1, y1, x1 + 50, y1 + 50);
                    gc.strokeLine(x1 + 50, y1, x1, y1 + 50);
                } else if (board[r][c] == 'O') {
                    gc.setStroke(Color.BLUE);
                    double x = 88 + (87 * c);
                    double y = 88 + (87 * r);
                    gc.strokeOval(x, y, 50, 50);
                }

            }
        }
        // if the game is over
        if (gameOver) {
            // its a tie game
            if (isTieGame) {
                gc.setStroke(Color.WHITE);
                gc.strokeText("It's a Tie! \n Press N to play again", 125, 25);
            }
            // display winner
            else if (winner == 0) {
                gc.setStroke(Color.WHITE);
                gc.strokeText("Player O has won! \n Press N to play again", 125, 25);
            } else {
                gc.setStroke(Color.WHITE);
                gc.strokeText("Player X has won! \n Press N to play again", 125, 25);
            }
        }


    }

}
