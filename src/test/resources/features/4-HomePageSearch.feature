@ui
Feature: As a user I want to validate the search functionality works fine as expected
#  When I search for a product for product name "" by Enter Key
#  When I search for a product for product name "" by pressing Search Button

  Background:
    Given I am on homepage

  @done
  Scenario: Verify user gets the list of items starting with word in search edit box
    When I type item name as "beautiful" in search edit box
    Then I should see list of Items name containing "Beautiful"

#  @done
#  Scenario: Verify user gets the list of items starting with word in search edit box
#    When I type item name as "pet" in search edit box
#    Then I should see at least one item starting with "pet"


  @done
  Scenario: Verify user gets alert if search product with blank value and by pressing Enter key
    When I search a product with name "" by pressing Enter Key
    Then I should get popup alert window with message "Please enter product name"

#    by pressing Search Button (default)
  @done
  Scenario: Verify user gets alert if search product with blank value and by pressing Search button
    When I search a product with name ""
    Then I should get popup alert window with message "Please enter product name"

  @done
  Scenario: Verify user able to search a product successfully after searching with blank value by pressing Search Button
    When I search a product with name ""
    Then I should get popup alert window with message "Please enter product name"
    When I search a product with name "Aluminium Bird Nest Tree Jewelry Stand Organizer"
    Then I should see below items listed on the search result page
      | FULL_ITEM_NAME                                   |
      | Aluminium Bird Nest Tree Jewelry Stand Organizer |

#  homework
#  Scenario: Verify user able to search a product successfully after searching with blank value by pressing Search Button
#    When I search for a product for product name "" by pressing Search Button
#    Then I should get popup alert window with message "Please do not enter blank product"
#    When I search for a product for product name "Aluminium Bird Nest Tree Jewelry Stand Organizer" by pressing Search Button
#    Then I should see the item is listed on the search result section as "Aluminium Bird Nest Tree Jewelry Stand Organizer"

  @done
  Scenario: Verify user can search an Item with partial product name
    When I search a product with name "Aluminium"
    Then I should see below items listed on the search result page
      | FULL_ITEM_NAME                                   |
      | Aluminium Bird Nest Tree Jewelry Stand Organizer |

  @done
  Scenario Outline: Verify user can proceed to Checkout page with one item
    When I search a product with name "Aluminium"
    And I select the item "<ITEM_TO_BUY>" to buy in Search page
    Then I should see the item "<ITEM_TO_BUY>" in Product detail page
    Examples:
      | ITEM_TO_BUY                                      |
      | Aluminium Bird Nest Tree Jewelry Stand Organizer |


  @done
  Scenario: Verify user can proceed to product details page by selecting **FIRST** item from the list
    When I search a product with name "Aluminium"
    And I select "first" item to buy from the list on Product search result page
    Then The Product name should be displayed on Product detail page as expected

  @done
  Scenario: Verify user can proceed to product details page by selecting **LAST** item from the list
    When I search a product with name "Aluminium"
    And I select "last" item to buy from the list on Product search result page
    Then The Product name should be displayed on Product detail page as expected
