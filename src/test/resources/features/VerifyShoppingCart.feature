Feature: Verify my shopping cart functionality working as expected

  @done
  Scenario: Verify user can view item details in View cart page
    Given I am on homepage
    When I search a product with name "Aluminium"
    And I select "first" item to buy from the list on Product search result page
    Then I should be on Product details page
    And I update Qty as "2" in Product details page
    And I proceed with Add to Cart in Product details page
    Then I should be on View Cart Page
    And The Product Image should be displayed as expected on View Cart Page
    And The Product Name should be displayed as expected  on View Cart Page
#    And The Product Sale Price should be displayed as expected  on View Cart Page
#    And The Product SubTotal should be displayed as expected  on View Cart Page
#    And The Delete option should be available to delete the Item  on View Cart Page

