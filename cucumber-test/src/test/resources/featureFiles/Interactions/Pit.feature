Feature: Pit

  Scenario: A robot falling into a pit
  	Given a game with an empty board
    And a robot on the board at (5, 5)
    And a pit on the board at (6, 5)
    And a respawn point on the board at (1, 1)
    And the robot having its respawn point set
    When the robot moves to (6, 5)
    Then the robot is at (1, 1)
