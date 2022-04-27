@tag
Feature: Setting up game

  @tag1
  Scenario: Beginning the game
  Given an easy game with 5 players
  When the game begins
  Then the players are created
  And the robots for the players are created
  And the game has an easy board
