Feature: Activation phase priority

  Scenario: A conveyor belt is activated before a gear
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
  	And a conveyor belt on the board at (5, 5) facing "up"
  	And a gear on the board at (5, 6) spinning "clockwise"
  	When the board elements activate
  	Then the robot is at (5, 6) and facing "right"
  	
  Scenario: Activation phase
    Given a game with two players and an empty board
    And a laser on the board at (8, 5)
    And a robot for the first player on the board at (4, 5)
    And a robot for the second player on the board at (4, 6)
    And a program for the robot full of move1s
    And a program for the second robot full of move1s
    When the activation phase happens
    Then the first robot is at (9, 5)
    And the robot loses life points
    And the second robot is at (9, 8)
#maybe try to put more than one player