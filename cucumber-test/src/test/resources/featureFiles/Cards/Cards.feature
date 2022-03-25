Feature: Programming Cards

	Scenario: Accept the programming card
  	Given a player
  	And the cards
    When the cards are shuffled
    Then the player accepts the cards
    
  Scenario: Programming the cards
  	Given a player
  	And the cards
    When the player programs the cards and reveal them
    Then the robot performs some actions
    

  Scenario: Move the robot 1 step in the direction it is facing
  	Given 1 step card
  	And a player
    And a robot on the board
    When the player places the cards on the board
    When the cards are revealed
    Then the robot moves 1 step in its direction
    
   
  Scenario: Move the robot 2 steps in the direction it is facing
  	Given 2 steps card
  	And a player
    And a robot on the board
    When the player places the cards on the board
    When the cards are revealed
    Then the robot moves 2 steps in its direction
    
  Scenario: Move the robot 3 steps in the direction it is facing
  	Given 3 steps card
  	And a player
    And a robot on the board
    When the player places the cards on the board
    When the cards are revealed
    Then the robot moves 3 steps in its direction
    
      
  Scenario: Move the robot towards right at 90 degrees 
  	Given Right TURN card
  	And a player
    And a robot on the board
    When the player places the cards on the board
    When the cards are revealed
    Then the robot moves 3 steps in its direction
    
      
  Scenario: Move the robot 3 steps in the direction it is facing
  	Given 3 steps card
  	And a player
    And a robot on the board
    When the player places the cards on the board
    When the cards are revealed
    Then the robot moves 3 steps in its direction
   