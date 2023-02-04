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
    And The Product Name should be displayed as expected on View Cart Page
    And The Product Sale Price should be displayed as expected on View Cart Page
    And The Product SubTotal should be displayed as expected on View Cart Page
    And The Delete option should be available to delete the Item on View Cart Page
    And The Delete option should be available to delete the Item on View Cart Page
    And The Product OrderTotal should be displayed as expected on View Cart Page


  @done
  Scenario: Verify user can Edit Qty on View Cart page successfully
    Given I am on homepage
    When I search a product with name "Aluminium"
    And I select "first" item to buy from the list on Product search result page
    Then I should be on Product details page
    And I proceed with Add to Cart in Product details page
    When I Update Qty as "3" on View Cart Page
    And I proceed with Add to Cart in Product details page
    Then I should be on View Cart Page
    And The Product Image should be displayed as expected on View Cart Page
    And The Product Name should be displayed as expected on View Cart Page
    And The Product Sale Price should be displayed as expected on View Cart Page
    And The Product SubTotal should be displayed as expected on View Cart Page
    And The Delete option should be available to delete the Item on View Cart Page
    And The Delete option should be available to delete the Item on View Cart Page
    And The Product OrderTotal should be displayed as expected on View Cart Page
    And The Product OrderTotal should be displayed as expected on View Cart Page

  @done
  Scenario: Verify user can Delete a product from View Cart page
    Given I am on homepage
    When I search a product with name "Aluminium"
    And I select "first" item to buy from the list on Product search result page
    And I proceed with Add to Cart in Product details page
    And I Delete a product on View Cart Page
    Then The Product should be removed from View Cart Page
    And The delete message should be displayed on View Cart Page as below
      """
      Sorry
        There are no items available in your cart.
        Please click on the 'Continue Shopping' button to add selected items to the cart..
      """

  @done
  Scenario: Verify user can Checkout to proceed to Order Summary page
    Given I am on homepage
    When I search a product with name "Aluminium"
    And I select "first" item to buy from the list on Product search result page
    And I proceed with Add to Cart in Product details page
    And I Checkout on View Cart page
    Then I should be on Order Summary page
