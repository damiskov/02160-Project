
@tag
Feature: Robot movement

  @tag1
  Scenario: Robot turns right
	  Given A turn right command
	  And a robot on the board
	  Then Robot turns right
	 
	Scenario: Robot turns left
	  Given A turn left command
	  And a robot on the board
	  Then Robot turns left
	
	Scenario: Robot moves forward
	  Given A move forward command
	  And a robot on the board
	  Then Robot moves forward
	
	Scenario: Robot moves backwards
		Given a move backwards command
		And a robot on the board
		Then Robot moves forward
	