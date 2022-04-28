Feature: Robot Bound

Scenario: Robot going out of bounds facing right
	Given a game with an empty board
	And a robot on the board at (11, 5) facing "right" 
	When a move forward command is executed
	Then the robot is at (11, 5) and facing "right"

Scenario: Robot going out of bounds facing left
	Given a game with an empty board
	And a robot on the board at (0, 5) facing "left"
	When the robot tries to move one step
	Then the robot is at (0, 5) and facing "left"
	
Scenario: Robot going out of bounds facing up
	Given a game with an empty board
	And a robot on the board at (5, 11) facing "up"
	When the robot tries to move one step
	Then the robot is at (5, 11) and facing "up"

Scenario: Robot going out of bounds facing down
	Given a game with an empty board
	And a robot on the board at (5, 0) facing "down"
	When the robot tries to move one step
	Then the robot is at (5, 0) and facing "down"

	


