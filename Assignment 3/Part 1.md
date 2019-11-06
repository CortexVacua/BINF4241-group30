Part 1:

We have decided to implement the Iterator design pattern when initializing the fields of the game board. We created a class FieldIterator that implements the Iterator interface and initializes the list of fields. That way, we can externalize some of the logic from the Gameboard class, which now calls the FieldIterator instead of initializing the fields by itself.

The class diagram is as follows:

```puml
interface Iterator {
    hasNext()
    next()
}

class FieldIterator {
    -Fields: List<Field>
    -position: int
    hasNext()
}

class Field {
    Color aColor
    Row aRow
    Column aColumn
    Occupied aOccupied
}
Iterator <|-- FieldIterator
Class03 *-- Class04
FieldIterator o-- Field
Class07 .. Class08
Class09 -- Class10
```