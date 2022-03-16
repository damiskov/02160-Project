
@tag
Feature: Checking-in with travel card

  @tag1
  Scenario: successfule check-in
  	Given a travel card with balace 100
  	And check-in status is false
  	And a check-in automaton at "Lyngby-St"
  	When check-in
  	Then automaton displays message that the card is checked in