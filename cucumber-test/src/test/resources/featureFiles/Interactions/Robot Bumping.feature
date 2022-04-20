Feature: Robot Bumping

Scenario: Player as an obstacle on the right side
	 Given a game with an empty board
	 And a robot on the board at (5, 5) facing "right"
	 And a second robot on the board at (6, 5) facing "right"
	 When the first robot moves to (6, 5) 
	 Then the first robot is at (6, 5)
	# Then the second robot is at (7, 5)

#	 
#	Scenario: Player as obstacle on the left side
#	 Given a player
#	 And a robot
#	 And robot pushes other robot
#	 When robot bumps into another robot
#	 Then pushed robots are moved into an obstacle on the left side
#	 
#	Scenario: Player as obstacle in the forward direction
#	 Given a player
#	 And a robot
#	 And robot pushes other robot
#	 When robot bumps into another robot
#	 Then pushed robots are moved into an obstacle in the forward direction
#	 
#	Scenario: Player as obstacle in the backward direction
#	 Given a player
#	 And a robot
#	 And robot pushes other robot
#	 When robot bumps into another robot
#	 Then pushed robots are moved into an obstacle in the backward direction
