@footer @ui
Feature: I want to verify the presence of web elements on the home page

  Background:
    Given I am on homepage


  Scenario: 9,10,11,12 - I want to verify presence of items on footer under "Categories" heading
    Then I should see below address in footer section
    """
    Elegant Decors
    Unit 1 Brewery Mews Centre,
    St John's Road,
    Isleworth,
    TW7 6PH,
    United Kingdom.
    Phone: 020 8004 6667
    """
    And I should see below items in footer section
      | Categories     |
      | Cremation Urns |
      | Home Decors    |

##      | MediaOptions     |
##      | facebook         |
##      | twitter          |
##      | g+               |
##      | PayPal           |
##      | paymentOptions   |
##      | MasterCard       |
##      | Visa             |
##      | Maestro          |
##      | Delta            |
##      | Switch           |
##      | Solo             |
