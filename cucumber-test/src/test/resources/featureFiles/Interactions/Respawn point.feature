Feature: Title of your feature

  Scenario: A robot loses all of its health and respawns at its respawn point
    Given a board
    And a robot on the board
    And a respawn point on the board
    And the robot having its respawn point set
    When the robot takes enough damage to kill it
    Then the robot respawns at its respawn point
    And the robot is back at max health
  
  Scenario: A robot sets its respawn point at the end of a register, then moves away and dies. It then respawns at the respawn point
		Given a board
    And a robot on the board
    And a respawn point on the board
    When the robot is on the respawn point at the end of a register
    And the robot moves away from the respawn point
    And the robot takes enough damage to kill it
    Then the robot respawns at its respawn point
    And the robot is back at max health
