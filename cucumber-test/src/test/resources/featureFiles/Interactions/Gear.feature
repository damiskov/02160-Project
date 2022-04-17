Feature: Gear

	 
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
   

	