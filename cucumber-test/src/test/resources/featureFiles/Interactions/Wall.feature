Feature: Wall

	@tag1
	Scenario: Wall stops the robot from the right side
	 Given a wall on the right side of the robot
	 And a robot on the board
	 When robot bumps into the wall from the right side
	 Then wall stops the robot from the right
	
	Scenario: Wall stops the robot from the left side
	 Given a wall on the left side of the robot
	 And a robot on the board
	 When robot bumps into the wall from the left side
	 Then wall stops the robot from the left
	 
	Scenario: Wall stops the robot in the direction it is facing
	 Given a wall standing infront of the robot
	 And a robot on the board
	 When robot bumps into the wall in its facing direction
	 Then wall stops the robot from moving forward
	 
	Scenario: Wall stops the robot from the opposite direction
	 Given a wall standing behined the robot
	 And a robot on the board
	 When robot bumps in the wall from behind
	 Then wall stops the robot from moving backward