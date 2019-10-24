Chess game:

Write the player input in algebraic notation.

To move a Pawn just specify the field you want him to move to (fields are specified by column first and by row second, "a3" not "3a"):

e.g. e4 (=move Pawn to e4)

For the other figures add their figure specifier before entering the desired Field:
- King	->	K
- Queen	->	Q
- Knight->	N
- Bishop->	B
- Rook	->	R

e.g. Ra3 (=move Rook to a3)

If more than one figure of the same type can move to the desired field, you'll have to specify which figure you want to move by adding the row, the column or both 
after the figure specifier and before the desired field(if you add both parameters enter the column first and then the row like "a1" and not "1a" to your input):
e.g. Raa7 (=move Rook on column a to a7)
e.g. R1a7 (=move Rook on row 1 to a7)
e.g. Ra1a7 (=move Rook on a1 to a7)

If you desire to capture a piece add an "x" between the figure specifier and the destination field:

e.g. Rxa7 (=capture figure on a7 with Rook)

e.g. Ra1xa7 (=capture figure on a7 with the Rook currently on a1)

and so on...

When capturing with a Pawn you have to specify on which column the Pawn resides:

e.g. exf4 (=capture figure on f4 with the pawn in column e)

En Passant has to be specified by adding the suffix "e.p." after the destination field:

e.g. bxa3e.p. (=a3 is the field on which the figure will land and not the field of the figure to be eaten)

Castling has to be specified with 0-0 (small one) or 0-0-0 respectively (big one):

e.g. 0-0 (=small castling)
