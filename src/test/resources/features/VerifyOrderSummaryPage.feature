#Feature: As a user I want to validate all use cases related to Order summary page
#  Order summary page page appears after user clicks 'checkout' button in order details.
#  User can sign in from this page.
#  User also can navigate to Item details page for a single item.
#
#  Background: Navigate to Order Summary page
#    Given I am on homepage
##    When I search for a product with product name as "15" Antique /Vintage Iron Wire Basket With 2 Handles"
#    When I search for a product with product name as
#      | Item_Name_to_search                                  |
#      | 15" Antique /Vintage Iron Wire Basket With 2 Handles |
#    And Select below product(s) to buy
#      | Item_to_Buy                                          |
#      | 15" Antique /Vintage Iron Wire Basket With 2 Handles |
#    Then I should be in Order Summary page
#
#  Scenario: Verify Item detail page appears when user clicks on the product name in order summary pge
#    Given I am in Order Summary page
#    When I choose product name on the page
#    Then I get a new browser window or tab opened.
#    And I should be moved to the Item details page in the new tab
#
#
