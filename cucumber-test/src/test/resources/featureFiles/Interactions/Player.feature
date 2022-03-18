Feature: Player

	@tag1
	Scenario: Player as obstacle on the right side
	 Given a player
	 And a robot
	 And robot pushes other robot
	 When robot bumps into another robot
	 Then pushed robots are moved into an obstacle on the right side
	 
	Scenario: Player as obstacle on the left side
	 Given a player
	 And a robot
	 And robot pushes other robot
	 When robot bumps into another robot
	 Then pushed robots are moved into an obstacle on the left side
	 
	Scenario: Player as obstacle in the forward direction
	 Given a player
	 And a robot
	 And robot pushes other robot
	 When robot bumps into another robot
	 Then pushed robots are moved into an obstacle in the forward direction
	 
	Scenario: Player as obstacle in the backward direction
	 Given a player
	 And a robot
	 And robot pushes other robot
	 When robot bumps into another robot
	 Then pushed robots are moved into an obstacle in the backward direction
