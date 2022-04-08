Feature: Programming Cards

#error because we need to implement SD file - DONE
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
  
#
  #Scenario: Move the robot one step in the direction it is facing
  #	Given a one step card
    #And a robot on the board
    #When the card is executed
    #Then the robot moves one step in its direction
    #
   #
  #Scenario: Move the robot two steps in the direction it is facing
  #	Given a two steps card
    #And a robot on the board
    #When the card is executed
    #Then the robot moves two steps in its direction
    #
  #Scenario: Move the robot three steps in the direction it is facing
  #	Given three steps card
    #And a robot on the board
    #When the card is executed
    #Then the robot moves three steps in its direction
    #
      #
  #Scenario: Move the robot towards right at ninety degrees angle
  #	Given Right Direction card
    #And a robot on the board
    #When the card is executed
    #Then the robot moves ninety degrees to the right
    #
  #Scenario: Move the robot towards left at ninety degrees angle
  #	Given Left Direction card
    #And a robot on the board
    #When the card is executed
    #Then the robot moves ninety degrees to the left
    #
      #
  #Scenario: Move the robot at one hundred eighty degrees angle
  #	Given U-turn card
    #And a robot on the board
    #When the card is executed
    #Then the robot moves one hundred eighty degrees so it faces opposite direction
    #
        #
  #Scenario: Move the robot in the downwards direction
  #	Given Backup card
    #And a robot on the board
    #When the card is executed
    #Then the robot moves one space back without changing its direction
    #
#
#
   