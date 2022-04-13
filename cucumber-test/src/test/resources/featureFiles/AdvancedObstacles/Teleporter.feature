Feature: Teleporter
  @tag1
  Scenario: Deterministic teleporting panel
    Given a game with an empty board
    And a sending teleporter on the board at (5, 5)
    And a robot on the board at (5, 5)
    And a linked receiving teleporter on the board at (9, 5)
    When the board elements activate
    Then the robot gets teleported to the other teleporter