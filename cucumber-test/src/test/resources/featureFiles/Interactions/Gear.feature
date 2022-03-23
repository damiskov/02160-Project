Feature: Gear
	 
	Scenario: Gear turns the robot towards right
	 Given a gear pointing towards right
	 And a robot on the board
	 When robot steps on a gear
	 Then gear turns the robot towards right
	 
	Scenario: Gear turns the robot towards left
	 Given a gear pointing towards left
	 And a robot on the board
	 When robot steps on a gear
	 Then gear turns the robot towards left
	