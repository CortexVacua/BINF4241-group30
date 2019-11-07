Part 1.5: Implementing Pieces as Observers

In this part, we implemented the chess pieces as observers and the game as observables. At the start
of the game, the pieces are initialized by registering them in the observer list from the game. When a piece is 
going to get eaten by another piece, the game will notify every pieces, updating them for their current row and column.
If a piece has the same row and column as the updating row and column, it will remove itself from the
game by removing it from the observer list. 

We made two new interfaces called ObservablePieces and ObserverPieces. We also implemented in the class
Piece the ObserverPieces interface and in the class Game the ObservablePieces interface. We had to slightly
change how the pieces get eaten in the Game Class and added an ArrayList for the observers in the Game and
the Piece class.

 

```puml

interface ObservablePieces <<Interface>> {
    +registerObserver()
    +removeObserver()
    +notifyObserver()
}

interface ObserverPieces <<Interface>> {
    +update()
}

Class Piece {
    -ArrayList<ObserverPieces> subscribed_observer
    +update()
}

Class Game {
    -ArrayList<ObserverPieces> subscribed_observer
    +registerObserver()
    +removeObserver()
    +notifyObserver()
}

ObserverPieces <|-- Piece
ObservablePieces <|-- Game
ObserverPieces o-- ObservablePieces

```

```puml
title Register and Remove Sequence Diagram
note left: Initialization
Game --> Printer: new Printer
Game --> Gameboard: new Gameboard
Gameboard --> FieldIterator: new Field
FieldIterator --> Gameboard: List field
Gameboard --> Game: Gameboard gameboard
Game -> Piece: registerObserver()
note left: Register
Group Loop
Game -> Printer: board_state()
Game -> Piece: notifyObserver()
Piece -> Piece: Update()
end
```

```puml
Kenobi -> Grievious: Hello there.
Grievious -> Kenobi: General Kenobi. 
Kenobi -> Skywalker: It's over Anakin. I have the high ground!
Skywalker -> Kenobi: You underestimate my power!
Skywalker -> Padme: i hate sand
Padme -> Skywalker: lol ok
Kenobi -> Archives: isComplete()
Archives --> Kenobi: return False
```
```puml
Tenko -> Cage: occupy()
Korekiyo -> Cage: isOccupied()
Cage --> Korekiyo: return True
Korekiyo -> Seesaw: doSeeSaw()
Seesaw -> Cage: applySeeSawEffect()
Cage -> Tenko: kill()
Tenko -> Tenko: setDeadTrue()
Himiko -> Cage: liftup()
Himiko -> Tenko: isDead()
Tenko --> Himiko: return True 
```