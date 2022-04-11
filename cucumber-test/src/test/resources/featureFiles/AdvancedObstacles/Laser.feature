Feature: Laser
  @tag1
  Scenario: Laser damages
    Given a game with an empty board
  	And a laser on the board at (5, 5)
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot loses life points