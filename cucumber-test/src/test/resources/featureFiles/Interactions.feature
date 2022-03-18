Feature: Robot laser

  Scenario: Successful upwards laser shot
    Given two robots A and B on the board
    When a register ends with A in the same board column as B
    And A is below B
    And A is facing up
    Then B takes damage
  
  Scenario: Successful downwards laser shot
    Given two robots A and B on the board
    When a register ends with A in the same board column as B
    And A is above B
    And A is facing down
    Then B takes damage

  Scenario: Successful rightwards laser shot
    Given Two robots A and B on the board
    When a register ends with A in the same board row as B
    And A is to the left of B
    And A is facing right
    Then B takes damage
  
  Scenario: Successful leftwards laser shot
    Given Two robots A and B on the board
    When a register ends with A in the same board row as B
    And A is to the right of B
    And A is facing left
    Then B takes damage
  
  Scenario: Blocked upwards laser shot
    Given two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board column as B
    And A is below B
    And A is facing up
    And the blocking obstacle is between A and B
    Then B takes damage
  
  Scenario: Blocked downwards laser shot
    Given two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board column as B
    And A is above B
    And A is facing down
    And the blocking obstacle is between A and B
    Then B takes damage

  Scenario: Blocked rightwards laser shot
    Given Two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board row as B
    And A is to the left of B
    And A is facing right
    And the blocking obstacle is between A and B
    Then B takes damage
  
  Scenario: Blocked leftwards laser shot
    Given Two robots A and B on the board
    And a blocking obstacle on the board
    When a register ends with A in the same board row as B
    And A is to the right of B
    And A is facing left
    And the blocking obstacle is between A and B
    Then B takes damage
  
Feature: Pits
	
	Scenario: A robot falling into a pit
		Given a robot on the board
		And a pit on the board
		When the robot moves into the pit during a register
		Then the robot reboots
	
Feature: Conveyor belts
	
	Scenario: A robot is pushed upwards by a conveyor belt
		Given a robot on the board
		And an upwards-pointing conveyor belt on the board
		When the robot moves into the conveyor belt during a regiser
		Then the robot is pushed upwards at the end of the register
	
	Scenario: A robot is pushed downwards by a conveyor belt
		Given a robot on the board
		And an downwards-pointing conveyor belt on the board
		When the robot moves into the conveyor belt during a regiser
		Then the robot is pushed downwards at the end of the register
	
	Scenario: A robot is pushed right by a conveyor belt
		Given a robot on the board
		And an right-pointing conveyor belt on the board
		When the robot moves into the conveyor belt during a regiser
		Then the robot is pushed right at the end of the register
	
	Scenario: A robot is pushed left by a conveyor belt
		Given a robot on the board
		And an left-pointing conveyor belt on the board
		When the robot moves into the conveyor belt during a regiser
		Then the robot is pushed left at the end of the register

Feature: Health stations
	
	Scenario: A damaged robot is healed by a health station
		Given a robot on the board
		And a health station on the board
		And the robot does not have full health
		When the robot moves into the health station during a register
		Then the robot gains one HP at the end of the register
	
	Scenario: A robot is not healed by a health station, because it has full health
		Given a robot on the board
		And a health station on the board
		And the robot has full health
		When the robot moves into the health station during a register
		Then the robot remains at full health at the end of the register
	
	