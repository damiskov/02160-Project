
@tag
Feature: Robot movement

  @tag1
  Scenario: Move robot
    Given a Robot
    Then execute program
    
  Scenario: Program execution
    Given a Program
    Then execute a set of moves
  
  Scenario: Execute a movement
    Given a Move
    Then move left, right, up or down
