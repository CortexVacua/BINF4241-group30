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
-> Game
activate Game
note left: Initialization
Game --> Printer: new Printer
activate Printer
Game --> Gameboard: new Gameboard
activate Gameboard
Gameboard --> Field: new Fields
activate Field
Gameboard --> Piece: new Pieces
activate Piece
Field --> Gameboard: return List fields
Piece --> Gameboard: return List pieces
Gameboard --> Game: return Gameboard gameboard
Game --> Player: new Player
activate Player
Player --> Game: return list players
Game -> Piece: registerObserver()
note left: Register
Group Loop
Game -> Printer: board_state()
-->Game: Player Input
Piece -> Field: unoccupy()
Game -> Piece: notifyObserver()
Piece -> Piece: Update()
Group If a Piece gets eaten
Piece -> Player: add_captures()
Piece -> Game: removeObserver()
end
Piece -> Field: occupy()
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
activate Tenko
activate Korekiyo
activate Himiko
Tenko -> Cage: occupy()
activate Cage
Korekiyo -> Cage: isOccupied()
Cage --> Korekiyo: return True
Korekiyo -> Seesaw: doSeeSaw()
activate Seesaw
Seesaw -> Cage: applySeeSawEffect()
deactivate Seesaw
Cage -> Tenko: kill()
Tenko -> Tenko: setDeadTrue()
deactivate Tenko
Himiko -> Cage: liftup()
deactivate Cage
Himiko -> Tenko: isDead()
Tenko --> Himiko: return True 
```