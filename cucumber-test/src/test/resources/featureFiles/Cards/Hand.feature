Feature: Card Hand


	Scenario: Dealing a hand
  	Given a game with one player
  	And a deck for the game
  	When the game deals the cards
    Then the player has a hand
 