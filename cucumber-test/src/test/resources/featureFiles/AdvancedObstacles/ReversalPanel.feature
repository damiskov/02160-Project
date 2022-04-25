Feature: Reversal Panel

  @tag1 
    Scenario: Reversal panel
    Given a game with an empty board
    And reversal panel on the board at (5, 5)
    And a robot on the board at (5, 5)
    And a program for the robot
    When the board elements activate
    Then the remaining moves get reversed
    
   Scenario: Reversal panel
    Given a game with an empty board
    And reversal panel on the board at (5, 5)
    And a robot on the board at (5, 5)
    And an already reversed program for the robot
    When the board elements activate
    Then the remaining moves get reversed
    
   Scenario: Reversal panel
    Given a game with an empty board
    And reversal panel on the board at (5, 5)
    And a robot on the board at (5, 5)
    And a program for the robot with uTurns
    When the board elements activate
    Then the remaining moves get reversed