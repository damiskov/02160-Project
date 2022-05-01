Feature: Setting up game

  Scenario: Beginning an easy game
  Given an easy game with 5 players
  When the game begins
  Then the players are created
  And the robots for the players are created
  And the game has an easy board
  
  Scenario: Beginning a medium game
  Given a medium game with 5 players
  When the game begins
  Then the players are created
  And the robots for the players are created
  And the game has a medium board
  
  Scenario: Beginning a hard game
  Given a hard game with 5 players
  When the game begins
  Then the players are created
  And the robots for the players are created
  And the game has a hard board
