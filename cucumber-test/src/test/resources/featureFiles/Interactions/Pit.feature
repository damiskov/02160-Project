Feature: Pit

  Scenario: A robot falling into a pit
    Given a robot on the board
    And a pit on the board
    When the robot moves into the pit during a register
    Then the robot reboots
