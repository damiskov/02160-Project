Feature: Pit

  Scenario: A robot falling into a pit
  	Given a game with an empty board
    And a robot on the board at (4, 5) facing "right"
    And a pit on the board at (5, 5)
    And a respawn point on the board at (1, 1)
    And the robot having its respawn point set
    When the robot moves 1 step
    Then the robot is at (1, 1)
  
  Scenario: A robot moving over a pit without stopping on it falls into it, and continues moving after respawning
  	Given a game with an empty board
    And a robot on the board at (4, 5) facing "right"
    And a pit on the board at (5, 5)
    And a respawn point on the board at (1, 1)
    And the robot having its respawn point set
    When the robot moves 2 steps
    Then the robot is at (2, 1)
