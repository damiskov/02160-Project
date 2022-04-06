Feature: Robot laser

  Scenario: Successful upwards laser shot
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
  	And a second robot on the board at (5, 7)
  	When the board elements activate
  	Then the second robot takes damage

  Scenario: Successful downwards laser shot
    Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
  	And a second robot on the board at (5, 3)
  	When the board elements activate
  	Then the second robot takes damage

  Scenario: Successful rightwards laser shot
    Given a game with an empty board
  	And a robot on the board at (5, 5) facing "right"
  	And a second robot on the board at (7, 5)
  	When the board elements activate
  	Then the second robot takes damage

  Scenario: Successful leftwards laser shot
    Given a game with an empty board
  	And a robot on the board at (5, 5) facing "left"
  	And a second robot on the board at (3, 5)
  	When the board elements activate
  	Then the second robot takes damage




  Scenario: Blocked upwards laser shot
  	Given a game with an empty board
  	And a robot on the board at (5, 5) facing "up"
  	And a second robot on the board at (5, 7)
  	And a wall on the board at (5, 6)
  	When the board elements activate
  	Then the second robot does not take damage

  Scenario: Blocked downwards laser shot
    Given a game with an empty board
  	And a robot on the board at (5, 5) facing "down"
  	And a second robot on the board at (5, 3)
  	And a wall on the board at (5, 4)
  	When the board elements activate
  	Then the second robot does not take damage

  Scenario: Blocked rightwards laser shot
    Given a game with an empty board
  	And a robot on the board at (5, 5) facing "right"
  	And a second robot on the board at (7, 5)
  	And a wall on the board at (6, 5)
  	When the board elements activate
  	Then the second robot does not take damage

  Scenario: Blocked leftwards laser shot
    Given a game with an empty board
  	And a robot on the board at (5, 5) facing "left"
  	And a second robot on the board at (3, 5)
  	And a wall on the board at (4, 5)
  	When the board elements activate
  	Then the second robot does not take damage
