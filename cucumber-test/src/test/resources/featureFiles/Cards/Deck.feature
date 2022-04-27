Feature: Deck 

	Scenario: 
  	Given a deck
  	And a player
    When the cards are dealt
    Then the hand is removed from the deck
  
  #only for coverage
  Scenario: Adding a card that does not exist
   Given a deck
   When we try to add a "chicken" card to the deck
   Then the "chicken" card is not added