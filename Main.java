import java.io.IOException;

public class Main {

    static int[][] MAP = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    static int ballX = 20;
    static int ballY = 6;
    static int ballDx = 1;
    static int ballDy = 0;
    static int paddle1X = 1;
    static int paddle1Y = 6;
    static int paddle2X = 29;
    static int paddle2Y = 6;

    public static void main(String[] args) throws IOException {

        while (true) {

            draw();

            if (ballX == 0 || ballX == 31) {
                gameOver();
            }

            int key = System.in.read();

            if (key == 113) { //113 - q
                System.exit(0);
            }

            if (key == 97 || key == 100) { //97 - a, 100 - d
                player1Input(key);
            }

            if (key == 106 || key == 108) { //106 - j, 108 - l
                player2Input(key);
            }

            moveBall();

        }
    }

    private static void draw() {
        for (int y = 0; y < MAP.length; y++) {
            for (int x = 0; x < MAP[0].length; x++) {
                if (x == ballX && y == ballY) {
                    System.out.print("O");
                }
                else if (x == paddle1X && y == paddle1Y) {
                    System.out.print("|");
                }
                else if (x == paddle2X && y == paddle2Y) {
                    System.out.print("|");
                }
                else if (MAP[y][x] == 1) {
                    System.out.print("X");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void gameOver() {
        System.out.println("Game over!");
        System.exit(0);
    }

    private static void player1Input(int key) {
        switch (key) {
            case 97:
                if (MAP[paddle1Y - 1][paddle1X] == 0) {
                    paddle1Y -= 1;
                }
                break;
            case 100:
                if (MAP[paddle1Y + 1][paddle1X] == 0) {
                    paddle1Y += 1;
                }
                break;
        }
    }

    private static void player2Input(int key) {
        switch (key) {
            case 108:
                if (MAP[paddle2Y - 1][paddle2X] == 0) {
                    paddle2Y -= 1;
                }
                break;
            case 106:
                if (MAP[paddle2Y + 1][paddle2X] == 0) {
                    paddle2Y += 1;
                }
                break;
        }
    }

    private static void moveBall() {

        int newX = ballX - ballDx;
        int newY = ballY - ballDy;

        if (newX == paddle1X && newY == paddle1Y || newX == paddle2X && newY == paddle2Y) {
            ballDx *= -1;
            ballDy *= -1;
        }
        else {
            ballX = newX;
            ballY = newY;
        }
    }
}
