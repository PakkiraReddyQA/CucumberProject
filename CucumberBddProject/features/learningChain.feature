#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Internal Printing

  @tag1
  Scenario: Internal printing by attaching QR Code to Certificate 
    Given open the Application URL "https://stage.learningchain.in/"
    And User Enters Username "AnuUser" and Password "Admin@1"
    When Click on Certificates and Upload CSV File
    And Generate the QR Code
    And attach QR Code to pdf with ScanWriter app
    And Upload the Certificate

  
