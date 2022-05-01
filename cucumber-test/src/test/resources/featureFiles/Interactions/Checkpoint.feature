Feature: Checkpoint

  Scenario: A robot steps onto a checkpoint
    Given a game with an empty board
    And checkpoint number 1 on the board at (5, 5)
    And a robot on the board at (4, 5) facing "right"
    When the robot moves 1 step
    Then the robot has checkpoint 1 as its most recent checkpoint
  
  Scenario: A robot moves over a checkpoint without stopping on it
  	Given a game with an empty board
    And checkpoint number 1 on the board at (5, 5)
    And a robot on the board at (4, 5) facing "right"
    When the robot moves 2 steps
    Then the robot has checkpoint 1 as its most recent checkpoint
  
  Scenario: A robot steps onto a checkpoint which is not the next checkpoint it has to step on
  	Given a game with an empty board
    And checkpoint number 1 on the board at (5, 5)
    And checkpoint number 4 on the board at (6, 5)
    And a robot on the board at (4, 5) facing "right"
    When the robot moves 2 steps
    Then the robot has checkpoint 1 as its most recent checkpoint

	Scenario: A robot steps onto the final checkpoint and finishes the game
		Given a game with an empty board
		And a final checkpoint with number 1 on the board at (5, 5)
		And a robot on the board at (4, 5) facing "right"
		When the robot moves 1 step
		Then the game is marked as over
	
	Scenario: A robot moves over the final checkpoint without stopping on it and finishes the game
		Given a game with an empty board
		And a final checkpoint with number 1 on the board at (5, 5)
		And a robot on the board at (4, 5) facing "right"
		When the robot moves 2 steps
		Then the game is marked as over