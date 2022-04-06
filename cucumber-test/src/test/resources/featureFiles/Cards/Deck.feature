Feature: Deck 

	Scenario: 
  	Given A deck
  	And A player
    When a deck generate a list of nine random cards for a player
    Then a player receives a hand