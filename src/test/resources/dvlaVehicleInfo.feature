@dvla
Feature: Vehicle information

  Scenario: verify vehicle information from DVLA
    Given I enter url "https://www.gov.uk/get-vehicle-information-from-dvla"
    When I click on Start now button
    And I verify the vehicle details by entering registraiton number
