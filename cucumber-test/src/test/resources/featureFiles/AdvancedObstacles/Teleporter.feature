Feature: Teleporter

  Scenario: Deterministic teleporting panel
    Given a game with an empty board
    And a sending teleporter on the board at (5, 5)
    And a robot on the board at (5, 5)
    And a linked receiving teleporter on the board at (9, 5)
    When the board elements activate
    Then the robot gets teleported to the other teleporter
    
  Scenario: Robot on the receiving teleporter
    Given a game with an empty board
    And a sending teleporter on the board at (5, 5)
    And a robot on the board at (5, 5)
    And a linked receiving teleporter on the board at (9, 5)
    And a second robot on the board at (9, 5)
    And a respawn point on the board at (6, 3)
    And the second robot having its respawn point set to the respawn point
    When the board elements activate
    Then the robot gets teleported to the other teleporter
    And the second robot is at (6, 3)