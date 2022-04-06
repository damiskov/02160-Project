Feature: Robot movement

  @tag1
  Scenario: Robot turns right
  	Given a board
	  And A turn right command
	  And a robot on the board
	  Then Robot turns right
	 
	Scenario: Robot turns left
		Given a board
	  And A turn left command
	  And a robot on the board
	  Then Robot turns left
	
	Scenario: Robot moves forward
		Given a board
	  And A move forward command
	  And a robot on the board
	  Then Robot moves forward
	
	Scenario: Robot moves backwards
		Given a board
		And a move backwards command
		And a robot on the board
		Then Robot moves backward
	

