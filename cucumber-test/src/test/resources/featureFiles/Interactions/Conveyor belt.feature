Feature: Conveyor belt

  Scenario: A robot is pushed upwards by a conveyor belt
  	Given a board
  	And a conveyor belt on the board at (5, 5) facing "up"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (5, 6)
    
    #Given a board
    #And a robot on the board
    #And an upwards-pointing conveyor belt on the board
    #When the robot moves into the conveyor belt during a register
    #Then the robot is pushed upwards at the end of the register

  Scenario: A robot is pushed right by a conveyor belt
  	Given a board
  	And a conveyor belt on the board at (5, 5) facing "right"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (6, 5)
    
    #Given a board
    #And a robot on the board
    #And a right-pointing conveyor belt on the board
    #When the robot moves into the conveyor belt during a register
    #Then the robot is pushed right at the end of the register
    
  Scenario: A robot is pushed downwards by a conveyor belt
  	Given a board
  	And a conveyor belt on the board at (5, 5) facing "down"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (5, 4)
    
    #Given a board
    #And a robot on the board
    #And a downwards-pointing conveyor belt on the board
    #When the robot moves into the conveyor belt during a register
    #Then the robot is pushed downwards at the end of the register

  Scenario: A robot is pushed left by a conveyor belt
  	Given a board
  	And a conveyor belt on the board at (5, 5) facing "left"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (4, 5)
    
    #Given a board
    #And a robot on the board
    #And a left-pointing conveyor belt on the board
    #When the robot moves into the conveyor belt during a register
    #Then the robot is pushed left at the end of the register
  
  Scenario: One robot blocks another robot from being pushed by a conveyor belt
  	Given a board
  	And a conveyor belt on the board at (5, 5) facing "right"
    And a robot on the board at (5, 5)
    And a second robot on the board at (6, 5)
    When the board elements activate
    Then the first robot is at (5, 5)
    
  #	Given a board
  #	And a robot on the board
  #	And a right-pointing conveyor belt on the board
  #	And a robot blocking the way of the conveyor belt
  #	When the robot moves into the conveyor belt during a register
  #	Then the robot stays on the conveyor belt at the end of the register
	
	Scenario: A wall blocks a robot from being pushed by a conveyor belt
		Given a board
  	And a conveyor belt on the board at (5, 5) facing "right"
    And a robot on the board at (5, 5)
    And a wall on the board at (6, 5)
    When the board elements activate
    Then the robot is at (5, 5)
	
#		Given a board
  #	And a robot on the board
  #	And a right-pointing conveyor belt on the board
  #	And a wall blocking the way of the conveyor belt
  #	When the robot moves into the conveyor belt during a register
  #	Then the robot stays on the conveyor belt at the end of the register
