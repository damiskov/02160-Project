Feature: Respawn point

  Scenario: A robot loses all of its health and respawns at its respawn point
    Given a game with an empty board
    And a robot on the board at (5, 5)
    And a respawn point on the board at (1, 1)
    And the robot having its respawn point set
    When the robot takes enough damage to kill it
    Then the robot is at (1, 1)
    And the robot is back at max health
  
  Scenario: A robot on a respawn point is killed when another robot respawns there
  	Given a game with an empty board
  	And a robot on the board at (5, 5)
  	And a respawn point on the board at (1, 1)
  	And the robot having its respawn point set
  	And a second robot on the board at (1, 1)
  	And a second respawn point on the board at (4, 1)
  	And the second robot having its respawn point set to the second respawn point
		When the robot takes enough damage to kill it
		Then the first robot is at (1, 1)
		And the second robot is at (4, 1)
	
	Scenario: A robot dies on its own respawn point
		Given a game with an empty board
		And a robot on the board at (5, 5)
		And a respawn point on the board at (5, 5)
		And the robot having its respawn point set
		When the robot takes enough damage to kill it
		Then the robot is at (5, 5)
		