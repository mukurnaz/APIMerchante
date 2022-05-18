@SmokeTest
Feature: Request for Json Place Holder
  Background: send a post request and verify the response
    Given send post request using the api "base_URI"
    Then verify statusCode "201"
    And verify id number "101"
  Scenario Outline: send a get request and verify the response
    Given send get request using the api "base_URI"
    Then verify firstName "<id>"
    And verify lastName "<title>"
    Examples:
    |id|title|
    |2|qui est esse|
  Scenario: send a put request and verify the response
      Given send put request using the api "base_URI"
      Then verify statusCode for put "200"
      And verify id number "101"
  Scenario: send a delete request and verify the response
      Given send delete request using the api "base_URI"
      Then verify statusCode for delete "200"