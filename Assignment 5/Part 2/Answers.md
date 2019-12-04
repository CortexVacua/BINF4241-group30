Failing Tests in GameBoardTest:

- markOnBoard
- markTwice
- getOpenPositions
- getOpenPostionsAll

To pass markOnBoard and markTwice the only thing we had to do, is fix the mark() method within the GameBoard class. To fix
the method we only had to swap the return statements of the second if-statement (board[row][col] != null) and its 
corresponding else-statement, because they were returning true when they should return false and false when they should
return true. 

To fix getOpenPositions and getOpenPositionsAll we only had to make a simple change within the getPositions() method within 
the Gameboard class. We had to make a change in its nested for loop (int col = 1; col < COLS; col++). We had to replace the 1
with a 0, since the indexing starts at 0 for the columns, just as it does for the rows.

---

Failing Tests in TicTacToeGameStateTest:
- hasWinRow
- hasWinCol
- isOverWin
- hasWinDiagonal
- startingPlayerIsX
- switchPlayer
- getAvailableStatesLastOne

To fix hasWinRow, hasWinCol and isOverWin we had to fix a part of the method hasWin() inside of the TicTacToeGameState class. 
For the fix we had to change the third line of the method to return true, which was returning false by mistake in case of a 
win by columns or a win by rows.

To fix hasWinDiagonal we had to fix the method completesDiagonal() by changing its 5th line from "return (board.getMark(0, 0) == center && center == board.getMark(1, 2))"
to return (board.getMark(0, 0) == center && center == board.getMark(2, 2)). The problem here was that it was checking the wrong
coordinates for a diagonal win. The coordinates (1,2) do not correspond to a diagonal field, while (2,2) represents the diagonal
field that gets you a win when paired with (0,0) and (1.1).

To fix startingPlayerIsX, switchPlayer, getAvailableStatesLastOne we only had to fix the broken method getCurrentPlayer() 
within the TicTacToeGameState class. The method previously always returned O. So we removed the first to lines of the method, so that it simply
returns the current player without changing the variable currentPlayer first and breaking things in the process.