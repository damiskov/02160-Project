Feature: Checkpoint

  Scenario: A robot steps onto a checkpoint
    Given a game with an empty board
    And checkpoint number 1 on the board at (5, 5)
    And a robot on the board at (4, 5) facing "right"
    When the robot moves 1 step
    Then the robot has checkpoint 1 as its most recent checkpoint

