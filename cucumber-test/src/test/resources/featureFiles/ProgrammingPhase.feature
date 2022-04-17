Feature: Programming phase

  @tag1
  Scenario: Programming phase
    Given a game with an empty board
    And a player
    And a robot for the player
    And a deck
    When the cards are dealt
    And the player chooses the cards for their robot
    Then the robot is assigned the program that the player chose