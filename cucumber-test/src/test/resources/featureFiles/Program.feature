Feature: Card priority sequence

	Scenario: 
  	Given A player
  	And A hand
    When a player selects five cards from their hand in order of priority
    Then actions are executed sequentially on player's robot