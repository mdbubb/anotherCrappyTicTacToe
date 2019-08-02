import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String[][] board = new String[3][3];
    public static int[] calculate = new int[9];
    public static HashMap<String, Integer> name = new HashMap<>();
    public static ArrayList<Integer> tempListX = new ArrayList<>();
    public static ArrayList<Integer> tempListY = new ArrayList<>();
    public static int a = 0;

    public static boolean gameNotOver() {
        boolean returnThis = false;
        if (win()) {
            System.out.println(XorO() + " Wins!");
            returnThis = true;
        }
        return !returnThis;

    }

    public static boolean win() {
        int sum = 0;
        ArrayList<String> next = new ArrayList<>();
        for (int i = 0; i < returnTempList().size(); i++) {
            sum += returnTempList().get(i);
        }
        for (int i = 0; i < board.length; i++) {
            String rowString = "";
            for (int j = 0; j < board.length; j++) {
                rowString += board[i][j];

            }
            next.add(rowString);
        }


        getBoard(board, next);
        return sum % 3 == 0 && returnTempList().size() >= 3;
    }

    public static String[][] getBoard(String[][] board, ArrayList<String> test) {
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i));
            System.out.println();
        }
        ;
        return board;
    }


    public static void createBoard(String board[][]) {
        int b = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Integer.toString(b);
                System.out.print("| (" + i + "," + j + ") |");
                name.put(i + "," + j, b);
                calculate[b] = b;
                b++;
            }
            System.out.println();
        }

    }

    public static void getInput() {
        System.out.println("Player " + XorO() + ", Type the ordered pair of your move ie. 1,1");
        Scanner input = new Scanner(System.in);
        String pair = input.next();
        int x = Integer.parseInt(pair.substring(0, pair.indexOf(",")));
        int y = Integer.parseInt(pair.substring(pair.indexOf(",") + 1));
        if (validateInput(board, x, y)) {
            for (Map.Entry<String, Integer> entry : name.entrySet()) {
                if (pair.equals(entry.getKey())) {
                    returnTempList().add(entry.getValue());

                }
            }
        }
        insert(board, x, y);
    }

    public static ArrayList<Integer> returnTempList() {
        if (XorO().equals("X")) {
            return tempListX;
        } else {
            return tempListY;
        }
    }

    public static boolean validateInput(String board[][], int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[x][y].equals("X") || board[x][y].equals("O")) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void insert(String board[][], int x, int y) {
        if (gameNotOver()) {
            if (validateInput(board, x, y)) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board.length; j++) {
                        if (i == x && j == y) {
                            board[i][j] = XorO();
                        }
                    }
                }
                printBoard(board);
                a++;
            } else {
                System.out.println("POSITION ALREADY TAKEN, CHOOSE ANOTHER POSITION.");
                printBoard(board);
                getInput();
            }

        }
    }


    public static void printBoard(String board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("X")) {
                    System.out.print("    X    ");

                } else if (board[i][j].equals("O")) {
                    System.out.print("    O    ");
                } else {
                    System.out.print("| (" + i + "," + j + ") |");

                }
            }
            System.out.println();
        }
    }


    public static String XorO() {
        return a % 2 == 0 ? "X" : "O";
    }

    public static void main(String[] args) {
        createBoard(board);
        while (true) {
            getInput();


        }
    }
}


/*
 try {
            int difference = Math.abs(returnTempList().get(0) - returnTempList().get(1));
            if (difference == 1) {
                for (int i = 0; i < returnTempList().size(); i++) {
                    System.out.println(returnTempList().get(i));
                }
                if (returnTempList().contains(2) && returnTempList().contains(4) || returnTempList().contains(5) && returnTempList().contains(7)|| returnTempList().contains(1) && returnTempList().contains(3)|| returnTempList().contains(4) && returnTempList().contains(6)) {
                    System.out.println("HELLLLLLLLLLLOOOOOOOOOOOOO");
                    checkDifference = false;
                }
            }
            for (int j = 0; j < returnTempList().size() - 1; j++) {
                if ((Math.abs(returnTempList().get(j) - returnTempList().get(j + 1)) != difference) && returnTempList().size() == 3) {
                    System.out.println("YOOOOOOOOOOOOOOOOOOOOOOOO");
                    checkDifference = false;
                }
            }

        } catch (IndexOutOfBoundsException e) {
        }

 */
