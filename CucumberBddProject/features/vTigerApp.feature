
Feature: Organization

Background: Below are the  Common Steps for Every Scenario
    Given Launch Browser "http://localhost:8888"
    And Login with Valid Credentials userName "<userName>" password "<password>"
    Then I validate the logged in successfully
    
@sanity 
 Scenario: Create New Organization
    When Click on Organization Link
    And Click on Create new Organization Link
    Given Provide Organization Name in Organization Text Field Click on Save Button
    Then Validate Created Organization With Actual Organization Name
    And close the browser
    
@regression  
 Scenario: Create New Organization With Industry
    When Click on Organization Link
    And Click on Create new Organization Link
    Given Provide Organization Name in Organization and Industry Text Field Click on Save Button
    Then Validate Created Organization With Actual Organization Name
    And close the browser
    
 


    
      
