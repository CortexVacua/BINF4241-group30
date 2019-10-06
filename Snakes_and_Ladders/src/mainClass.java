public class mainClass {
    public static void main(String[] args) {
        Gameboard gameboard = new Gameboard();
        gameboard.init();
        Game game = new Game();
        game.game_flow(gameboard);
    }
}