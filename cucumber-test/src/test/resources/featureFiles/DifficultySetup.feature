
@tag
Feature: Difficulty setup

  @tag1
  Scenario: Select from default difficulties
    Given an easy difficulty
    Then set number of obstacles
    Then set their location
    Then Generate board
    Then set obstacles on board
    Then Generate board
    
    
   
