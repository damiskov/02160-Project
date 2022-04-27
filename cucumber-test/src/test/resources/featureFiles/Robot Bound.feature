Feature: Robot Bound

Scenario: Robot going out of bounds facing right
	Given a game with an empty board
	And a robot on the board at (11, 5) facing "right" 
	And a move forward command is executed
	Then a robot on the board at (11, 5) facing "right"
	
Scenario: Robot going out of bounds facing right
	Given a game with an empty board
	And a robot on the board at (9, 5) facing "right" 
	And a move forward 3 command is executed
	Then a robot on the board at (11, 5) facing "right"
	
Scenario: Robot going out of bounds facing left
	Given a game with an empty board
	And a robot on the board at (0, 5) facing "left" 
	And a move forward command is executed
	Then a robot on the board at (0, 5) facing "left"
Scenario: Robot going out of bounds up
	Given a game with an empty board
	And a robot on the board at (5, 11) facing "up" 
	And a move forward command is executed
	Then a robot on the board at (5, 11) facing "up"
Scenario: Robot going out of bounds up facing down
	Given a game with an empty board
	And a robot on the board at (5, 0) facing "down" 
	And a move forward command is executed
	Then a robot on the board at (5, 0) facing "down"
	


