Feature: Multiplayer game

	@tag1
	Scenario: Players priority
	 Given two robots A and B on the board
	 And movement cards with numbers
	 When the first card for each robot is drawn
	 Then the robot moves in decreasing order of number