Feature: Conveyor belt

  Scenario: A robot is pushed upwards by a conveyor belt
  	Given a game with an empty board
  	And a conveyor belt on the board at (5, 5) facing "up"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (5, 6)

  Scenario: A robot is pushed right by a conveyor belt
  	Given a game with an empty board
  	And a conveyor belt on the board at (5, 5) facing "right"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (6, 5)
    
  Scenario: A robot is pushed downwards by a conveyor belt
  	Given a game with an empty board
  	And a conveyor belt on the board at (5, 5) facing "down"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (5, 4)

  Scenario: A robot is pushed left by a conveyor belt
  	Given a game with an empty board
  	And a conveyor belt on the board at (5, 5) facing "left"
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot is at (4, 5)
  
  Scenario: One robot blocks another robot from being pushed by a conveyor belt
  	Given a game with an empty board
  	And a conveyor belt on the board at (5, 5) facing "right"
    And a robot on the board at (5, 5)
    And a second robot on the board at (6, 5)
    When the board elements activate
    Then the first robot is at (5, 5)
	
	Scenario: A wall blocks a robot from being pushed by a conveyor belt
		Given a game with an empty board
  	And a conveyor belt on the board at (5, 5) facing "right"
    And a robot on the board at (5, 5)
    And a wall on the board at (6, 5)
    When the board elements activate
    Then the robot is at (5, 5)
