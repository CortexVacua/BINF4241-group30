Part 3:
---
### UNO game

#### 1.a.

When asking for the number of players, the game should only accept integers between 2 and 10. During a players turn, only legal moves for that turn should be accepted (cards that the player has on their hand and that can be legally played). The input for the card one wants to play is the number on the card followed by the starting letter of its color (e. g. "2R" for 2 red). If a wild card is played, the input is "W" followed by the desired color (e. g. "WR"). For wild draw four cards, the input is "W4" followed by the desired color (e. g. "W4R"). For draw two cards, the input is "+2". For skip cards, the input is "S". For reverse, the input is "R". The game also accepts the input "UNO" after the card specification if the player will have only one card left after the move (e. g. "2R UNO"). If no card can be legally played, the player inputs "None". All other inputs should result in the game telling the player that the input was invalid and prompt them to try again.

#### 1.b.

The game should check if the inputs are valid for the given situation of play and if the player making the move may do so. It should not do anything with invalid inputs except to tell the player that an invalid input was provided.

#### 1.c.

The expected outputs are the new game situation after each turn that includes the card on top of the discard pile and the number of cards each player holds. Further, the game lets you know if your input is invalid and outputs a new input prompt. After the first player manages to discard all of their cards, the game ends and notifies the players of who has won it.

#### 2.

```puml

class Game {
    #scanner: Scanner
    #PlayerQueue: LinkedList
    #CurrentPlayer: Player
    #DiscardPile: LinkedList
    #DrawPile: LinkedList
    #DeckOfCards: LinkedList
    #clockwise: Boolean
    #number_of_moves: Integer
    #GameOver: Boolean
    +shuffle(list: List): LinkedList
    +getDrawPileCard(): Card
    +getDiscardPile(): LinkedList
    +addToDiscardPile(card: Card)
    +getPlayerQueue(): LinkedList
    +setCurrentPlayer(player: Player)
    +getCurrentPlayer(): Player
    +isLegalMove(player: Player, card: Card): Boolean
    +getClockwise(): Boolean
    +getNumberOfMoves(): Integer
    +isGameOver(): Boolean
}

interface Card <<Interface>> {
    {abstract} +getCard(): Card
}

class Main {
    ~game: Game
    {static} +main(String args[])
}

class GameInitializer {
    +initialize(list_of_players: LinkedList): Game
}

class Player {
#number_of_cards: Integer
#Cards: LinkedList
+addCard(card: Card)
+removeCard(card: Card)
+getCards(): LinkedList
+playRandomLegalCard()
+getNumberOfCards(): Integer
+playCard(card: Card)
+playCardSayingUNO(card: Card)
+getNumberOfLegalMoves(): Integer
}

class NumberCard {
#number: Number
#Color: Color
+getCard(): NumberCard
}

class WildCard {
#Color: Color
+getCard(): WildCard
}

class ReverseCard {
#Color: Color
+getCard(): ReverseCard
}

class SkipCard {
#Color: Color
+getCard(): SkipCard
}

class WildDrawFourCard {
#Color: Color
+getCard(): WildDrawFourCard
}

class Printer {
+printGameState(players: LinkedList, discardPile: LinkedList)
}



Card <|.. NumberCard
Card <|.. WildCard
Card <|.. ReverseCard
Card <|.. SkipCard
Card <|.. WildDrawFourCard
Main o-- Game
Game o-- Player
Game o-- Printer
Player o-- Card
Game o-- NumberCard
Game o-- WildCard
Game o-- ReverseCard
Game o-- SkipCard
Game o-- WildDrawFourCard
GameInitializer o-- Game
```

You can find a png file of the class diagram called "Class diagram.png" within the same folder in this repository.

