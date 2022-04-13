Feature: Chaining Panel
  

  @tag1
  Scenario: Robot becomes chainable with no other chainable robots
    Given a game with an empty board
    And a chaining panel on the board at (5, 5)
    And a robot on the board at (5, 5)
    When the board elements activate
    Then the robot becomes chainable
    And the chaining panel becomes inactive

  Scenario: Chain connection
    Given a game with an empty board
    And a chaining panel on the board at (5, 5)
    And an inactive chaining panel on the board at (6, 6)
    And a robot on the board at (5, 5)
    And a chainable robot
    When the board elements activate
    Then the robots get chained together
    And the inactive chaining panel become active again

  Scenario: De-chaining the robots
    Given a game with an empty board
    And two robots chained together
    When one robot reboots
    Then the robots get unchained
    
  Scenario: Robots pulling on eachother
    Given a game with an empty board
    And two robots chained together
    When one robot moves
    Then the second robot is at (5, 5)
    
  Scenario: Robot pulled into a pit 
    Given a game with an empty board
    And two robots chained together
    And a pit on the board at (5, 5)
    And a second respawn point on the board at (3, 4)
    And the second robot having its respawn point set to the second respawn point
    When the first robot moves 1 step
    Then the second robot is at (3, 4)
    And the robots get unchained
    
  #Scenario: Robot pulled into a wall
    #Given a game with an empty board
    #And two robots chained together
    #And a wall on the board at (5, 5)
    #When one robot moves
    #Then the second robot stays at (5, 4)
    
  Scenario: Robot steps on inactive chaining panel
    Given a game with an empty board
    And an inactive chaining panel on the board at (5, 5)
    And a robot on the board at (5, 5)
    When the board elements activate
    Then nothing changes