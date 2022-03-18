
@tag
Feature: Difficulty setup

  @tag1
  Scenario: Select from default difficulties
    Given a Host
    When a difficulty is selected
    Then set number of obstacles
    And setup the board
    
    Scenario: Insert number of obstacles
    Given a Host
    When a costum button is selected
    And a number of obstacles is inserted
    Then setup the board
    
    


