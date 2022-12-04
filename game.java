public class Game {

    public static void main(String[] args) {
        board game = new board();
        game.printboard();
        game.movePiece('A', 6, 'B', 5);
        game.movePiece('D', 3, 'C', 4);
        game.movePiece('B', 5, 'D', 3);
    }
}