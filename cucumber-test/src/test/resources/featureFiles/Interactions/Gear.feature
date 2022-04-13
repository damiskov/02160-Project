Feature: Gear

#error, because Cannot invoke "board.Board.initialPlacement(piece_basics.EnvironmentElement, int, int)" 
#because "board" is null
	 
	Scenario: Gear turns the robot towards right
	 Given a game with an empty board
	 And a gear on the board at (6, 5) spinning "clockwise"
   And a robot on the board at (5, 5) 
   When the board elements activate
   Then the robot moves to (6, 5) and turns "right"
   
	Scenario: Gear turns the robot towards left
	 Given a game with an empty board
	 And a gear on the board at (6, 5) spinning "counterclockwise"
   And a robot on the board at (5, 5) 
   When the board elements activate
   Then the robot moves to (6, 5) and turns "left"
   
#	Scenario: Gear turns the robot towards left
#	 Given a gear pointing towards left
#	 And a robot on the board
#	 When robot steps on a gear
#	 Then gear turns the robot towards left
	