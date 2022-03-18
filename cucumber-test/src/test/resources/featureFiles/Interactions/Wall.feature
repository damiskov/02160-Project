Feature: Wall

	@tag1
	Scenario: Wall pushes the robot to the right
	 Given a wall on the right side of the player
	 And a robot on the board
	 When robot bumps into the wall
	 Then wall stops the robot from the right
	
	Scenario: Wall pushes the robot to the left
	 Given a wall on the left side of the player
	 And a robot on the board
	 When robot bumps into the wall
	 Then wall stops the robot from the left
	 
	Scenario: Wall pushes the robot forward
	 Given a wall pointing forward
	 And a robot on the board
	 When robot bumps in the wall
	 Then wall stops the robot from front
	 
	Scenario: Wall pushes the robot backwards
	 Given a wall pointing backwards
	 And a robot on the board
	 When robot bumps in the wall
	 Then wall stops the robot from the back