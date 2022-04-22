Feature: Card Hand

#error, because, The step 'A player' is undefined.
	Scenario: 
  	Given a player
  	And a deck
  	When the cards are dealt
    Then a hand is created
    
  
