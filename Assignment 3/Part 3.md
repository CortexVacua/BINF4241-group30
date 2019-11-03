Part 3:

We decided to implement a Scoreboard that uses the Observer pattern for the third part. So we created the interfaces ObservableSB (registerObserver, removeObserver, notifyObserver) and ObserverSB (update) and a new class named ScoreBoard. 

Since eating a piece does not take place within the Board class, we decided to use the Player class as the Observable and ScoreBoard as the Observer by implementing the above mentioned interfaces. We used the Player class as the Observable, because we already had implemented code, that keeps track of the eaten pieces by each player within a list.

Each time a piece gets added to these lists, ScoreBoard as the Observer gets a notification. Depending on the color of the piece ScoreBoard decides which player gets the points and depending on the type of the piece the amount of points is decided (5 for Queen, 1 for everything else).

For the printout, we had to slightly adjust our Printer class and implement a getScores method within ScoreBoard. The adapted Printer class just prints out a string at the very end, which displays the scores of both players. 

Further adjustments to the preexisting code that had to be made are the following: 
- initializing the scoreboard within the Game class
- passing the player names to the Printer class, so that both names can be printed independently from the current player making his move