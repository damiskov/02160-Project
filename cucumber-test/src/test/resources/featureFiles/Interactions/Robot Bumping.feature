Feature: Robot Bumping

Scenario: Robot as an obstacle on the right side
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "right"
	 And a second robot on the board at (6, 5) facing "right"
	 When one robot moves 
	 Then the first robot is at (6, 5)
	 Then the second robot is at (7, 5)
	 
#	 
#	Scenario: Robot as obstacle on the left side
#	 
#	Scenario: Robot as obstacle in the forward direction
#	 
#	Scenario: Robot as obstacle in the backward direction
#	 
# Scenario: Third Robot as an obstacle in the way of second robot
#	 
# Scenario: Wall as an obstacle in the way of second robot
