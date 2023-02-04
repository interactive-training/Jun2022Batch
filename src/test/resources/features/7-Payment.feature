@ui @payment
Feature: Verify the payment page functionality

  Background:
    Given I am on homepage
    When I search a product with name "Aluminium"
    And I select "first" item to buy from the list on Product search result page
    And I proceed with Add to Cart in Product details page
    And I Checkout on View Cart page
    Then I should be on Order Summary page
    When I logged in as existing customer with valid credentials as "testemail@mailinator.com" and "Welcome123"
    Then I fill up billing information on Checkout page
    And I fill up delivery information on Order Summary Page
    And I Proceed to Payment on Checkout page
    And I am on Payment gateway page

  Scenario: Order total is displayed as expected
    Then I should see Order Total amount in Order Summay section on Payment page as expected

    @done
    Scenario: User able to pay using Card type as 'Visa/Delta/Electron'
      When I select to pay by card type as "Visa/Delta/Electron"
      And I fill up all required details
      And I proceed to pay
      And The payment should success
      And The order should be confirmed

#  Scenario: User able to pay using Card type as "MasterCard/EuroCard"
#    Given I am on Payment page
#    When I select to pay by card type as "MasterCard/EuroCard"
#    And I fill up all required details
#    And I proceed to pay
#    Then The payment should success
#    And The order should be confirmed
