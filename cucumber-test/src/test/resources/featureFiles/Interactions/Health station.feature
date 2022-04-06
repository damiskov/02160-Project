Feature: Health station

  Scenario: A damaged robot is healed by a health station
  	Given a game with an empty board
  	And a health station on the board at (5, 5)
  	And a robot on the board at (5, 5)
  	And the robot does not have full health
    When the board elements activate
    Then the robot gains one HP

  Scenario: A robot is not healed by a health station, because it has full health
  	Given a game with an empty board
  	And a health station on the board at (5, 5)
  	And a robot on the board at (5, 5)
    And the robot has full health
    When the board elements activate
    Then the robot remains at full health
