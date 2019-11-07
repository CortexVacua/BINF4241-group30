Part 1:
---
####Iterator

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
*From here the file continues with Part 1.5 and Part 2*