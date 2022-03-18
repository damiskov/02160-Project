Feature: Gear

	@tag1
	 
	Scenario: Gear turns the robot downward
	 Given a gear pointing downwards
	 And a robot on the board
	 When robot steps on a gear
	 Then gear turns the robot in the downwards direction
	
	Scenario: Gear turns the robot forward
	 Given a gear pointing forward
	 And a robot on the board
	 When robot steps on a gear
	 Then gear turns the robot in the forward direction
	 
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
	