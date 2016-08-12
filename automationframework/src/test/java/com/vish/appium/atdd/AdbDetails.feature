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

Feature: Detecting Android Devices
* As a mobile app tester
* I should be able to get my Android device details through the framework
* In order to use that information for automation of mobile apps.

Scenario: If a device is connected
Given 1 android device with id "b3018009" is connected
When I check for available android devices
Then the output should contain "Mi4"

Scenario: If no device is connected
Given 0 android devices are connected
When I check for available android devices
Then no output should be returned