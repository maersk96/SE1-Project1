Feature: Add mock data
  Description: Test data is added to the app.
  Actors: UI

  Scenario: The UI adds test data for the user to see
    When mock data is generated
    Then some employees exist
    And some projects exist