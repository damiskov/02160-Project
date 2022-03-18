@tag
Feature: Advanced obstacles scenarios

  @tag1
  Scenario: Title of your scenario
    Given a laser
    And a robot
    When the robot steps into the laser
    Then the robot loses life points

  Scenario: Random teleporting panel
    Given a sending teleporter
    And a robot
    And multiple receiving teleporters
    When the robot steps into the sending teleporter
    Then the robot get teleported to a random receiving teleporter
    
  Scenario: Oil spill
    Given an oil spill
    And a robot
    When the robot steps into the oil spill
    Then the oil spill ignites
    And the robot loses life points
    
  Scenario: Fire Spreading
    Given a fire
    When a turn passes
    Then the fire spreads to a random adjacent cell
    
  Scenario: Reversal panel
    Given reversal panel
    And a robot
    And some remaining moves for the robots
    When the robot steps into the reversal panel
    Then the remaining moves get reversed
    
  Scenario: Chain connection
    Given chaining panel
    And a robot
    And another robot
    When the robot steps into the chaining panel
    Then the two robots get chained together
    And they pull on eachother when they move
    
  Scenario: Deterministic teleporting panel
    Given a sending teleporter
    And a robot
    And a receiving teleporter
    When the robot steps into the sending teleporter
    Then the robot get teleported to the receiving teleporter
    


