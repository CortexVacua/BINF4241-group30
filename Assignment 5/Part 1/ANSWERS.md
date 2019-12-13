For this assignment, I made a file with test cases for the snakes and ladders game from assignment 1.
With the test cases I checked if most of the elements of the game works properly and also tested for
some edge cases.

I could not reach the full test coverage because I could not test the classes Game and Printer.
The class Game has no function that can be tested and the class Printer has function which has
no proper output that can be tested (I didn't know how System.out.print can be tested).

I also deleted some code lines that wasn't used at all like:

-  the function public Queue<Player> getPlayers() {return list_of_players;} in gameboard.

- the protected int points_to in the class Square

During testing I found a but that crashed the game. It was possible to crash the game when an inproper input
is given during the initialization of the gameboard (when it asked for the gameboard size and player size and the
user would give something else than numbers). I could fixed the problem but unfortunately, the test case for Gameboard
doesn't work anymore, so I marked the GameboardTest cases as a comment.