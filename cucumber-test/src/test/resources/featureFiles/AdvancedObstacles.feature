@tag
Feature: Advanced obstacles scenarios

  @tag1
  Scenario: Laser damages
    Given a laser
    And a robot
    When the robot steps into the laser
    And the laser activates
    Then the robot loses life points

  #Scenario: Random teleporting panel
    #Given a sending teleporter
    #And a robot
    #And multiple receiving teleporters
    #When the robot steps into the sending teleporter
    #Then the robot get teleported to a random receiving teleporter
    
  Scenario: Oil spill ignites
    Given an oil spill
    And a robot
    When the robot steps into the oil spill
    Then the oil spill ignites
    And the robot loses life points
    
  Scenario: Fire damages robot
    Given a fire
    And a robot
    When the robot steps into the fire
    Then the robot loses life points
    
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
    
  Scenario: Robot becomes chainable with no other chainable robots
    Given chaining panel
    And a robot
    And no chainable robots
    When the robot steps into the chaining panel
    Then the robot becomes chainable
    And the chaining panel becomes inactive
    
  Scenario: Chain connection
    Given chaining panel
    And a robot
    And a chainable robot
    When the first robot steps into the chaining panel
    Then the robots get chained together
    And the first chaining panel become active again
    
  Scenario: Robots pulling on eachother
    Given two robots chained together
    When one robot moves and the distance between them becomes greater 
    Then the other robot gets pulled in the same direction
    
  Scenario: De-chaining the robots
    Given two robots chained together
    When one of them moves and the distance between them decreases 
    Then the robots get unchained
    
  Scenario: Deterministic teleporting panel
    Given a teleporter
    And a robot
    And another teleporter
    When the robot steps into the first teleporter
    And the teleporter activates
    Then the robot get teleported to the other teleporter
    


