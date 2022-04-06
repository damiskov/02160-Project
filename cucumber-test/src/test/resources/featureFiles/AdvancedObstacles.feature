@tag
Feature: Advanced obstacles scenarios

  @tag1
  Scenario: Laser damages
  	Given a board
    And a laser on the board
    And a robot on the board
    When the robot steps into the laser
    Then the robot loses life points
    
  Scenario: Oil spill ignites
  	Given a board
    And an oil spill on the board
    And a robot on the board
    When the robot steps into the oil spill
    Then the oil spill ignites
    And the robot loses life points
    
  Scenario: Fire damages robot
    Given a board
    And a fire on the board
    And a robot on the board
    When the robot steps into the fire
    Then the robot loses life points
    
  Scenario: Fire Spreading
    Given a board
    And a fire on the board
    And a robot on the board
  #  When a turn passes
    When the robot steps into the fire
    #this was only added to make the test run, the previous one is correct
    #going to be changed to "when the obstacle"
    Then the fire spreads to a random adjacent cell
    
  Scenario: Reversal panel
    Given a board
    And reversal panel on the board
    And a robot on the board
    When the robot steps into the reversal panel
    Then the remaining moves get reversed
    
  Scenario: Robot becomes chainable with no other chainable robots
    Given a board
    And a game
    And chaining panel on the board
    And a robot on the board
   # And no chainable robots
    When the robot steps into the chaining panel
    Then the robot becomes chainable
    And the chaining panel becomes inactive
    
  Scenario: Chain connection
    Given a board
    And a game
    And a second chaining panel on the board
    And a robot on the board
    And a chainable robot
    When the first robot steps into the chaining panel
    Then the robots get chained together
    And the first chaining panel become active again
    
  #Scenario: Robots pulling on eachother
    #Given two robots chained together
    #When one robot moves and the distance between them becomes greater 
    #Then the other robot gets pulled in the same direction
    
  #Scenario: De-chaining the robots
    #Given two robots chained together
    #When one of them moves and the distance between them decreases 
    #Then the robots get unchained
    
  Scenario: Deterministic teleporting panel
    Given a board
    And a teleporter on the board
    And a robot on the board
    And another teleporter on the board
    When the robot steps into the first teleporter
   # And the teleporter activates
    Then the robot gets teleported to the other teleporter
    


