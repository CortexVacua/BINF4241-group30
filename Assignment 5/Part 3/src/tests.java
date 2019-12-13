import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This is a testing suite for the UNO game, covering most functions and moves in the game
 */

public class tests{

    LinkedList<String> list = new LinkedList<String>() {{
        add("a");
        add("b");
        add("c");
    }
    };

    /**
     * This test covers the process of game initialization and checks whether the game is set up with one card in the
     * discard pile and seven cards in each player’s hand. Further, it checks whether the first card on the discard pile
     * is a Wild Draw Four card and gives an assertion error if that is the case.
     */

    @Test
    public void testInitialization() {
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        assertEquals("The discard pile does not have size 1 at initialization", 1, game.getDiscardPile().size());
        assertTrue("The number of players is not between 2 and 10", game.getPlayerQueue().size() <= 10 && game.getPlayerQueue().size() >= 2);
        for (Player player : game.getPlayerQueue()) {
            assertEquals("Some players do not have 7 cards at the start of the game", 7, player.getNumberOfCards());
        }
        assertTrue("A Wild Draw Four card cannot be the first card on the discard pile.", !(game.getDiscardPile().get(0) instanceof WildDrawFourCard));
    }


    /**
     * This test covers the process of changing the direction of play from clockwise to couterclockwise and vice versa
     * whenever a new ReverseCard is placed on the discard pile. It throws an assertion error if the game fails to reverse
     * the direction of play.
     */

    @Test
    public void testMovingDirection() {
        ReverseCard r = new ReverseCard(Color.RED);
        NumberCard n = new NumberCard(Color.RED, Number.TWO);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        boolean clockwise = game.getClockwise();
        game.setCurrentPlayer(getPlayerQueue.get(1));
        game.getCurrentPlayer().addCard(r);
        game.addToDiscardPile(n);
        game.getCurrentPlayer().playCard(r);
        assertEquals("The game should reverse the order of play when a reverse card is played!", !clockwise, game.getClockwise());
    }


    /**
     * This test covers the process of playing an illegal NumberCard. It throws an assertion error if the game allows this
     * card to be played.
     */

    @Test
    public void testPlayingWrongCard() {
        NumberCard n = new NumberCard(Color.RED, Number.TWO);
        NumberCard n2 = new NumberCard(Color.BLUE, Number.THREE);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        int number_of_moves = game.getNumberOfMoves();
        game.setCurrentPlayer(getPlayerQueue.get(1));
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(n2);
        game.getCurrentPlayer().playCard(n);
        assertEquals("You should not be allowed to play this card.", game.getNumberOfMoves(), number_of_moves);

    }


    /**
     * This test covers the process of playing a legal NumberCard. It throws an assertion error if the game does not allow
     * this card to be played.
     */

    @Test
    public void testPlayingRightCard() {
        NumberCard n = new NumberCard(Color.RED, Number.TWO);
        NumberCard n2 = new NumberCard(Color.BLUE, Number.TWO);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        int number_of_moves = game.getNumberOfMoves();
        game.setCurrentPlayer(getPlayerQueue.get(1));
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(n2);
        game.getCurrentPlayer().playCard(n);
        assertEquals("You should be allowed to play this card.", game.getNumberOfMoves(), number_of_moves + 1);
    }


    /**
     * This test covers the process of playing a card of a different color from the one specified for the wild card. It
     * throws an assertion error if the game allows this card to be played.
     */

    @Test
    public void testWrongColorWild() {
        WildCard w = new WildCard(Color.RED);
        NumberCard n = new NumberCard(Color.GREEN, Number.TWO);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        int number_of_moves = game.getNumberOfMoves();
        game.setCurrentPlayer(getPlayerQueue.get(1));
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(w);
        game.getCurrentPlayer().playCard(n);
        assertEquals("You should not be allowed to play this card.", game.getNumberOfMoves(), number_of_moves);
    }


    /**
     * This test covers the process of playing a card of the color specified for the wild card. It throws an assertion error
     * if the game does not allow this card to be played.
     */

    @Test
    public void testRightColorWild() {
        WildCard w = new WildCard(Color.GREEN);
        NumberCard n = new NumberCard(Color.GREEN, Number.TWO);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        int number_of_moves = game.getNumberOfMoves();
        game.setCurrentPlayer(getPlayerQueue.get(1));
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(w);
        game.getCurrentPlayer().playCard(n);
        assertEquals("You should be allowed to play this card.", game.getNumberOfMoves(), number_of_moves + 1);
    }


    /**
     * This test covers the process of not saying the UNO keyword when making a move that leaves a player with only one
     * card. It throws an assertion error if the game fails to add two penalty cards to that player’s hand.
     */

    @Test
    public void testNotSayingUNO() {
        NumberCard n = new NumberCard(Color.RED, Number.TWO);
        NumberCard n2 = new NumberCard(Color.RED, Number.THREE);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        game.setCurrentPlayer(getPlayerQueue.get(1));
        Player current_player = game.getPlayerQueue.get(1);
        for (int i = 0; i <= 5; i++) {
            game.getCurrentPlayer().getCards.remove();
        }
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(n2);
        game.getCurrentPlayer().playCard(n);
        assertEquals("You should take two cards from draw pile if you forget to say UNO!", 3, current_player.getNumberOfCards());
    }


    /**
     * This test covers the process of saying the UNO keyword when making a move that leaves a player with only one
     * card. It throws an assertion error if the game adds two penalty cards to that player’s hand.
     */

    @Test
    public void testSayingUNO() {
        NumberCard n = new NumberCard(Color.RED, Number.TWO);
        NumberCard n2 = new NumberCard(Color.RED, Number.THREE);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        game.setCurrentPlayer(getPlayerQueue.get(1));
        Player current_player = game.getPlayerQueue.get(1);
        for (int i = 0; i <= 5; i++) {
            game.getCurrentPlayer().getCards.remove();
        }
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(n2);
        game.getCurrentPlayer().playCardSayingUNO(n);
        assertEquals("Player saying UNO should not have to draw two penalty cards.", 1, current_player.getNumberOfCards());
    }


    /**
     * This test covers the process of saying the UNO keyword when making a move that leaves a player with more than one
     * card. It throws an assertion error if the game considers this move legal.
     */

    @Test
    public void testSayingFalseUNO() {
        NumberCard n = new NumberCard(Color.RED, Number.TWO);
        NumberCard n2 = new NumberCard(Color.RED, Number.THREE);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        game.setCurrentPlayer(getPlayerQueue.get(1));
        int number_of_moves = game.getNumberOfMoves();
        for (int i = 0; i <= 4; i++) {
            game.getCurrentPlayer().getCards.remove();
        }
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(n2);
        game.getCurrentPlayer().playCardSayingUNO(n);
        assertEquals("Player should not be allowed UNO where not applicable.", game.getNumberOfMoves(), number_of_moves);
    }


    /**
     * This test covers the process of playing a Wild Draw Four Card in the case where it is a player’s only possible legal
     * move and in the case where there are other possible legal moves. If it is the only possible legal move, the test
     * will throw an assertion error if the game does not alllow that move. If it is not the only possible legal move, the
     * test will throw an assertion error if the game allows the Wild Draw Four card to be played.
     */

    @Test
    public void testWildDrawFourCard() {
        WildDrawFourCard w4 = new WildDrawFourCard();
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        game.setCurrentPlayer(getPlayerQueue.get(1));
        int number_of_moves = game.getNumberOfMoves();
        game.getCurrentPlayer().addCard(w4);
        if (game.getCurrentPlayer().getNumberOfLegalMoves() > 1) {
            game.getCurrentPlayer().playCard(w4);
            assertEquals("You should not be allowed to play this card.", game.getNumberOfMoves(), number_of_moves);
        } else {
            game.getCurrentPlayer().playCard(w4);
            assertEquals("You should be allowed to play this card.", game.getNumberOfMoves(), number_of_moves + 1);
        }
    }


    /**
     * This test covers the process of ending the game once a player has played their last card. It throws an assertion
     * error if the game fails to end after this move.
     */

    @Test
    public void testGameOver() {
        NumberCard n = new NumberCard(Color.RED, Number.TWO);
        NumberCard n2 = new NumberCard(Color.RED, Number.THREE);
        GameInitializer gi = new GameInitializer();
        Game game = GameInitializer.initialize(list);
        game.setCurrentPlayer(getPlayerQueue.get(1));
        for (int i = 0; i <= 6; i++) {
            game.getCurrentPlayer().getCards.remove();
        }
        game.getCurrentPlayer().addCard(n);
        game.addToDiscardPile(n2);
        game.getCurrentPlayer().playCard(n);
        assertTrue("The game should be over when a player has played their last card.", game.isGameOver() == true);
    }
}
