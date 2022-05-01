Feature: Activation phase

  Scenario: A conveyor belt is activated before a gear in line with obstacle priority
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
  	And a conveyor belt on the board at (5, 5) facing "up"
  	And a gear on the board at (5, 6) spinning "clockwise"
  	When the board elements activate
  	Then the robot is at (5, 6) and facing "right"
  	
  Scenario: Activation phase
    Given a game with two players and an empty board
    And a laser on the board at (8, 7)
    And a robot for the first player on the board at (4, 7)
    And a robot for the second player on the board at (4, 6)
    And a program for the robot full of move1s
    And a program for the second robot full of move1s
    When the activation phase happens
    Then the first robot is at (9, 7)
    And the robot loses life points
    And the second robot is at (9, 6)

   Scenario: Activation phase terminates because of final chackpoint
    Given a game with two players and an empty board
    And a robot for the first player on the board at (4, 7)
    And a robot for the second player on the board at (4, 6)
    And a program for the robot full of move1s
    And a program for the second robot full of move1s
    And a final checkpoint at (6, 7)
    When the activation phase happens
    Then the first robot is at (6, 7)
    And the second robot is at (6, 6)