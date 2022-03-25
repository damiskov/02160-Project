Feature: Health station

  Scenario: A damaged robot is healed by a health station
  	Given a board
    And a robot on the board
    And a health station on the board
    And the robot does not have full health
    When the robot moves into the health station during a register
    Then the robot gains one HP at the end of the register

  Scenario: A robot is not healed by a health station, because it has full health
  	Given a board
    And a robot on the board
    And a health station on the board
    And the robot has full health
    When the robot moves into the health station during a register
    Then the robot remains at full health at the end of the register
