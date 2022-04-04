Feature: Robot laser

  Scenario: Successful upwards laser shot
  	Given a board
  	And a robot on the board
  	And a second robot above the first
  	And the first robot is facing up
  	When the board elements activate
  	Then the second robot takes damage

  Scenario: Successful downwards laser shot
    Given a board
  	And a robot on the board
  	And a second robot below the first
  	And the first robot is facing down
  	When the board elements activate
  	Then the second robot takes damage

  Scenario: Successful rightwards laser shot
    Given a board
  	And a robot on the board
  	And a second robot to the right of the first
  	And the first robot is facing right
  	When the board elements activate
  	Then the second robot takes damage

  Scenario: Successful leftwards laser shot
    Given a board
  	And a robot on the board
  	And a second robot to the left of the first
  	And the first robot is facing left
  	When the board elements activate
  	Then the second robot takes damage




  Scenario: Blocked upwards laser shot
  	Given a board
  	And a robot on the board
  	And a second robot above the first
  	And the first robot is facing up
  	And a wall in between the robots
  	When the board elements activate
  	Then the second robot does not take damage

  Scenario: Blocked downwards laser shot
    Given a board
  	And a robot on the board
  	And a second robot below the first
  	And the first robot is facing down
  	And a wall in between the robots
  	When the board elements activate
  	Then the second robot does not take damage

  Scenario: Blocked rightwards laser shot
    Given a board
  	And a robot on the board
  	And a second robot to the right of the first
  	And the first robot is facing right
  	And a wall in between the robots
  	When the board elements activate
  	Then the second robot does not take damage

  Scenario: Blocked leftwards laser shot
    Given a board
  	And a robot on the board
  	And a second robot to the left of the first
  	And the first robot is facing left
  	And a wall in between the robots
  	When the board elements activate
  	Then the second robot does not take damage
