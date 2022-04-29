Feature: Difficulty setup

	@tag1
  Scenario: Changinng the level in a difficulty
    Given an easy difficulty
    When the difficulty level is changed to hard
    Then the difficulty level is hard

   
