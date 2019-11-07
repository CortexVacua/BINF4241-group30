Part 2:

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