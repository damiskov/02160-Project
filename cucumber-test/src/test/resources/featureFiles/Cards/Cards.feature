Feature: Programming Cards


	Scenario: Accept the programming card
  	Given a player
  	And a Deck
    When a Hand is created 
    Then the player accepts nine cards
    
  Scenario: Programming the cards
  	Given a player
  	And a non empty program
    When a card is taken from the front of the program
    Then the robot executes the action on the card
  

  Scenario: Move the robot one step in the direction it is facing
  	Given a Move1 card
    And a robot on the board2
    When the card is executed2
    Then the robot moves one step in its direction
    
   
  Scenario: Move the robot two steps in the direction it is facing
  	Given a Move2 card
    And a robot on the board3
    When the card is executed3
    Then the robot moves two steps in its direction
    
  Scenario: Move the robot three steps in the direction it is facing
  	Given a Move3 card
    And a robot on the board4
    When the card is executed4
    Then the robot moves three steps in its direction
    
      
  Scenario: Rotate robot to the right through ninety degrees
  	Given Right Direction card
    And a robot on the board5
    When the card is executed5
    Then the robot moves ninety degrees to the right
    
    
  Scenario: Rotate robot to the right through ninety degrees
  	Given Left turn card
    And a robot on the board6
    When the card is executed6
    Then the robot moves ninety degrees to the left 


  Scenario: Move the robot at one hundred eighty degrees angle
  	Given UTurn card
    And a robot on the board7
    When the card is executed7
    Then the robot faces opposite orientation
    
    
  Scenario: Move the robot in the downwards direction
  	Given Backup card
    And a robot on the board8
    When the card is executed8
    Then the robot moves one space back without changing its direction
    

   