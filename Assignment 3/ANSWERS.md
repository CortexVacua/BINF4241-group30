Part 1:
---
### Iterator

We have decided to implement the Iterator design pattern when initializing the fields of the game board. We created a class FieldIterator that implements the Iterator interface and initializes the list of fields. That way, we can externalize some of the logic from the Gameboard class, which now calls the FieldIterator instead of initializing the fields by itself.

The class diagram is as follows:

```puml
interface Iterator {
    {abstract} +hasNext()
    {abstract} +next()
}

class FieldIterator {
    -Fields: List<Field>
    -position: Integer
    +hasNext(): Boolean
    +next(): Field
}
class Gameboard {
    +Fields: List<Field>
    +Pieces: List<Piece>
    +getField(x: Column, y: Row): Field
    +getPiece(x: Column, y: Row): Piece
    +getPieces(): List<Piece>
    +getFields(): List<Field> 
}

class Field {
    -aColor: Color
    -aRow: Row
    -aColumn: Column
    -aOccupied: Occupied
    +occupy()
    +unoccupy()
    +getaColor(): Color
    +getaColumn(): Column
    +getaRow(): Row
    +getaOccupied(): Occupied
    +checkIfAttacked(gb: Gameboard): Boolean
    +checkIfAttacked(gb: Gameboard, color: Color): Boolean
}
Iterator <|.. FieldIterator
FieldIterator o- Field
Gameboard o-- Field
Gameboard o- FieldIterator
```
You can find a png file of the diagram called "Part 1 Iterator class diagram.png" within the same folder in this repository.


The sequence diagram is as follows:

```puml
create Gameboard
activate Gameboard
create FieldIterator
Gameboard -> FieldIterator: new FieldIterator()
activate FieldIterator
FieldIterator -> FieldIterator: constructor call
activate FieldIterator #005500
create Field
FieldIterator -> Field: new Field()
activate Field
FieldIterator -> FieldIterator: Fields.add(Field)
deactivate FieldIterator
FieldIterator --> Gameboard: FieldIterator is constructed
Gameboard -> FieldIterator: while hasNext()
Gameboard -> FieldIterator: next()
activate Gameboard #005500
FieldIterator --> Gameboard: return Field
Gameboard -> Gameboard: Fields.add(Field)
deactivate Gameboard
```
You can find a png file of the diagram called "Part 1 Iterator sequence diagram.png" within the same folder in this repository.

---
Part 2:
---

This sequence diagram of the Gameboard only looks at the real gameboard object, that is used and not at any copies, 
which are used for checks of possible moves (e.g. valid moves of the king).

As requested this sequence diagram only looks at methods, that actually cause a state change within the Gameboard . This
means that methods that interact with the Gameboard for whatever reason, that do not result in a state change are omitted
 in this diagram (Printer, checks for valid moves, etc.). Omitted as well are all the methods between objects, that do not affect
 the concrete gameboard object.
 
This diagram shows the initialization of Gameboard and the possible state changes in one turn.

There are not many methods that actually change the state of the Gameboard. The few that do are mentioned in the diagram
and are self explanatory. Where needed some slight comments where added in the diagram to make it clearer.
 
You can find a png file of the diagram called Part_2.png within the same folder in this repository.

```puml
->Game
activate Game
Game->Gameboard: new Gameboard(), initializes the original board
activate Gameboard
Gameboard->Gameboard: within Gameboard(): creates two lists called Fields and Pieces
Gameboard->Fielditerator: within Gameboard(): new Iterator(), initialize the fielditerator
activate Fielditerator
loop while hasnext() returns true
  Fielditerator<-Gameboard: hasnext()
Fielditerator-->Gameboard: returns true
Gameboard->Fielditerator: fielditerator.next()
Gameboard<--Fielditerator: returns the next Field
Gameboard->Gameboard: add Field to list of fields
activate Field
end
deactivate Fielditerator
destroy Fielditerator
Gameboard->Gameboard: within Gameboard(): adds all the pieces to  list of pieces
activate Piece
Field->Field: unoccupy(), unoccupies field when a piece leaves it
Field-->Gameboard: indirect change in Fields list, bc of change in attributes of a Field
Piece-->Piece: setPosition(), changes Position of Piece
Piece-->Gameboard: indirect change in Pieces list, bc of change in attributes of a Piece
Piece->Gameboard: Piece.update(), removes captured pieces from Pieces list after dying
Gameboard-->Piece: returns the removed Piece, which is than added to the captures through Piece.update()
Game->Gameboard: within game(): check for Pawns able to promote in Pieces
alt there is Pawn that can be promoted
    Gameboard-->Game: return true
    Game->Gameboard: Gameboard.Pieces.remove(Pawn), removes Pawn 
    Game->Gameboard: Gameboard.Pieces.add(desired_Piece), adds desired Piece 
else no Pawn can be promoted
    Gameboard-->Game: return false
end
deactivate Game
deactivate Gameboard
deactivate Field
deactivate Piece
```

---
Part 3:
---

We decided to implement a Scoreboard that uses the Observer pattern for the third part. So we created the interfaces ObservableSB (registerObserver, removeObserver, notifyObserver) and ObserverSB (update) and a new class named ScoreBoard. 

Since eating a piece does not take place within the Board class, we decided to use the Player class as the Observable and ScoreBoard as the Observer by implementing the above mentioned interfaces. We used the Player class as the Observable, because we already had implemented code, that keeps track of the eaten pieces by each player within a list.

Each time a piece gets added to these lists, ScoreBoard as the Observer gets a notification. Depending on the color of the piece ScoreBoard decides which player gets the points and depending on the type of the piece the amount of points is decided (5 for Queen, 1 for everything else).

For the printout, we had to slightly adjust our Printer class and implement a getScores method within ScoreBoard. The adapted Printer class just prints out a string at the very end, which displays the scores of both players. 

Further adjustments to the preexisting code that had to be made are the following: 
- initializing the scoreboard within the Game class
- passing the player names to the Printer class, so that both names can be printed independently from the current player making his move