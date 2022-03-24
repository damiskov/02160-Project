Feature: Conveyor belt

  Scenario: A robot is pushed upwards by a conveyor belt
  	Given a board
    And a robot on the board
    And an upwards-pointing conveyor belt on the board
    When the robot moves into the conveyor belt during a regiser
    Then the robot is pushed upwards at the end of the register

  Scenario: A robot is pushed downwards by a conveyor belt
    Given a board
    And a robot on the board
    And a downwards-pointing conveyor belt on the board
    When the robot moves into the conveyor belt during a regiser
    Then the robot is pushed downwards at the end of the register

  Scenario: A robot is pushed right by a conveyor belt
  	Given a board
    And a robot on the board
    And a right-pointing conveyor belt on the board
    When the robot moves into the conveyor belt during a regiser
    Then the robot is pushed right at the end of the register

  Scenario: A robot is pushed left by a conveyor belt
  	Given a board
    And a robot on the board
    And a left-pointing conveyor belt on the board
    When the robot moves into the conveyor belt during a regiser
    Then the robot is pushed left at the end of the register
