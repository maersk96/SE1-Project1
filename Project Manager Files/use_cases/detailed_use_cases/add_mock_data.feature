# Work distribution:
# Jonas s183635

Feature: Add mock data
  Description: Generated data is added to the Project Manager by the Admin
  Actors: Admin

  Scenario: The admin adds mock data
    Given the user is logged in as admin
    When mock data is generated
    Then there are some projects in the Project Manager

  Scenario: A non-admin employee adds mock data unsuccessfully
    Given the user is logged in as a registered employee
    When mock data is generated
    Then there are no projects in the Project Manager
    And the error message "Administrator login required" is given
