@api
Feature: Verify API demo

  @working
  Scenario Outline: Verify user gets 200 when try to get single user valid data
    Given I have valid URL
    When I send the request using GET for user "<EmpID>"
    Then i should get "<ResStatus>"
    Examples:
      | EmpID | ResStatus |
      | 3     | 200       |
      | 100   | 404       |
