#Feature: As a user I want to validate the search functionality works fine as expected
#
#  Background:
#    Given I am on homepage
#
#  Scenario Outline: Verify user can search an Item with its exact name
#
##    When I search for a product with product name as "15" Antique /Vintage Iron Wire Basket With 2 Handles"
#    When I search for a product with product name as <Item_to_Search>
#    Then I should see the item is listed on the search result section as <Item_to_Search>
#    Examples:
#      |Item_to_Search|
#      | 15" Antique /Vintage Iron Wire Basket With 2 Handles |
#
#
#  Scenario Outline: Verify user can search an Item with partial name
#    Given I am on homepage
##    When I search for a product with product name as "15" Antique /Vintage Iron Wire Basket With 2 Handles"
#    When I search for a product with product name as <Item_to_Search>
#    Then I should see all item names displayed on search result section contains <Item_to_Search>
#
#    Examples:
#      |Item_to_Search|
#      |Antique |
#
#  Scenario Outline: Verify user can proceed to Checkout page with Item searched with partial name (first item)
#    Given I am on homepage
##    When I search for a product with product name as "15" Antique /Vintage Iron Wire Basket With 2 Handles"
#    When I search for a product with product name as <Item_to_Search>
#    Then I should see all item names displayed on search result section contains <Item_to_Search>
#    And I select first item in the list to buy
#    Then I should be moved to Checkout page
#    Examples:
#      |Item_to_Search|
#      |Antique |
#
#  Scenario Outline: Verify user can proceed to Checkout page with Item searched with partial name (Last item)
#    Given I am on homepage
##    When I search for a product with product name as "15" Antique /Vintage Iron Wire Basket With 2 Handles"
#    When I search for a product with product name as <Item_to_Search>
#    Then I should see all item names displayed on search result section contains <Item_to_Search>
#    And I select last item in the list to buy
#    Then I am on the Checkout page
#    Examples:
#      |Item_to_Search|
#      |Antique |