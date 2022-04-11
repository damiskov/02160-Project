#@tag
#Feature: Advanced obstacles scenarios
#
  #@tag1
  #Scenario: Laser damages
  #	Given a board
    #And a laser on the board
    #And a robot on the board
    #When the robot steps into the laser
    #Then the robot loses life points
    #
    #Given a game with an empty board
  #	And a laser on the board at (5, 5)
    #And a robot on the board at (5, 5)
    #When the board elements activate
    #Then the robot loses life points
#
    #
  #Scenario: Fire damages robot
    #Given a board
    #And a fire on the board
    #And a robot on the board
    #When the robot steps into the fire
    #Then the robot loses life points
    #
  #Scenario: Fire Spreading
    #Given a board
    #And a fire on the board
    #And a robot on the board
  #  When a turn passes
    #When the robot steps into the fire
    #this was only added to make the test run, the previous one is correct
    #going to be changed to "when the obstacle"
    #Then the fire spreads to a random adjacent cell
    #
   # error, because "program" is null
    #Scenario: Reversal panel
    #Given a board
    #And reversal panel on the board
    #And a robot on the board
    #When the robot steps into the reversal panel
    #Then the remaining moves get reversed
    #
  #Scenario: Robot becomes chainable with no other chainable robots
    #Given a board
    #And a game
    #And a chaining panel on the board
    #And a robot on the board
   # And no chainable robots
    #When the robot steps into the chaining panel
    #Then the robot becomes chainable
    #And the chaining panel becomes inactive
#
  #Scenario: Chain connection
    #Given a board
    #And a game
    #And a chaining panel on the board
    #And a second chaining panel on the board
    #And a robot on the board
    #And a chainable robot
    #When the first robot steps into the chaining panel
    #Then the robots get chained together
    #And the first chaining panel become active again
#
  #Scenario: De-chaining the robots
    #Given a board
    #And two robots chained together
    #When one robot reboots
    #Then the robots get unchained
    #
  #Scenario: Robots pulling on eachother
    #Given a board
    #And two robots chained together
    #When one robot moves
    #Then the second robot is at (5, 5)
    #
  #Scenario: Deterministic teleporting panel
    #Given a board
    #And a teleporter on the board
    #And a robot on the board
    #And another teleporter on the board
    #When the robot steps into the first teleporter
   # And the teleporter activates
    #Then the robot gets teleported to the other teleporter
#
    #
#
#
