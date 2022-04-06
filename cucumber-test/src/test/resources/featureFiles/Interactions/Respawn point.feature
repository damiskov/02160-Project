Feature: Title of your feature

  Scenario: A robot loses all of its health and respawns at its respawn point
    Given a game with an empty board
    And a robot on the board at (5, 5)
    And a respawn point on the board at (1, 1)
    And the robot having its respawn point set
    When the robot takes enough damage to kill it
    Then the robot is at (1, 1)
    And the robot is back at max health
  
  Scenario: A robot sets its respawn point at the end of a register, then moves away and dies. It then respawns at the respawn point
		Given a game with an empty board
    And a robot on the board at (5, 5)
    And a respawn point on the board at (5, 5)
    When the board elements activate
    And the robot moves to (7, 5)
    And the robot takes enough damage to kill it
    Then the robot is at (5, 5)
    And the robot is back at max health
