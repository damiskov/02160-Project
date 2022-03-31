Feature: Programming Cards

	Scenario: Accept the programming card
  	Given a player
  	And the cards
    When the cards are dealt
    Then the player accepts nine cards
    
  Scenario: Programming the cards
  	Given a player
  	And the cards
    When the player chooses five cards
    And the program is executed
    Then the robot performs some actions
    

  Scenario: Move the robot one step in the direction it is facing
  	Given a one step card
    And a robot on the board
    When the card is executed
    Then the robot moves one step in its direction
    
   
  Scenario: Move the robot two steps in the direction it is facing
  	Given a two steps card
    And a robot on the board
    When the card is executed
    Then the robot moves two steps in its direction
    
  Scenario: Move the robot three steps in the direction it is facing
  	Given three steps card
    And a robot on the board
    When the card is executed
    Then the robot moves three steps in its direction
    
      
  Scenario: Move the robot towards right at ninety degrees angle
  	Given Right Direction card
    And a robot on the board
    When the card is executed
    Then the robot moves ninety degrees to the right
    
  Scenario: Move the robot towards left at ninety degrees angle
  	Given Left Direction card
    And a robot on the board
    When the card is executed
    Then the robot moves ninety degrees to the left
    
      
  Scenario: Move the robot at one hundred eighty degrees angle
  	Given U-turn card
    And a robot on the board
    When the card is executed
    Then the robot moves one hundred eighty degrees so it faces opposite direction
    
        
  Scenario: Move the robot in the downwards direction
  	Given Backup card
    And a robot on the board
    When the card is executed
    Then the robot moves one space back without changing its direction
    


   