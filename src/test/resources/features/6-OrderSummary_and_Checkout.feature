Feature: As a user I want to validate all use cases related to Order summary page
  Order summary page page appears after user clicks 'checkout' button in order details.
  User can sign in from this page.
  User also can navigate to Item details page for a single item.

  Background: Navigate to Order Summary page
    Given I am on homepage
    When I search a product with name "Aluminium"
    And I select "first" item to buy from the list on Product search result page
    And I proceed with Add to Cart in Product details page
    And I Checkout on View Cart page
    Then I should be on Order Summary page


  Scenario: Verify the order summary accordian is expanded by default
    Then Order Summary header is expanded by default

  @done
  Scenario: Verify Item detail page appears when user clicks on the product name in order summary pge
    Then The Product Name should be displayed as expected on Order Summary page
    And The Product Sale Price should be displayed as expected on Order Summary page
    And The Product SubTotal should be displayed as expected on Order summary page
    And The Product OrderTotal should be displayed as expected on Order Summary page

  @done
  Scenario: Verify The item link in order summary page opens order details page in a new tab in the browser
    When I Press the product link on Order Summary page
    Then I should be on Product details page in a new tab
#      And Verify the product name displayed on product details page and order summary page are same
#      And Verify the product sale price displayed on product details page and order summary page are same
#      And Verify the product Sub total price displayed on product details page and order summary page are same
#      And Verify the product Quantity displayed on Product details page as entered by user

  @done
  Scenario: User logs in with valid credential as existing customer and verify the Order Total amount in footer section seen as expected
    When I logged in as existing customer with valid credentials as "testemail@mailinator.com" and "Welcome123"
    Then Verify Order Total Amount in footer and header section should be equal

  @done
  Scenario: User logs in with valid credential as existing customer and verify the Order Total amount in footer section seen as expected
    When I logged in as existing customer with valid credentials as "testemail@mailinator.com" and "Welcome123"
    Then I fill up billing information on Checkout page
    And I fill up delivery information on Order Summary Page
    And I Proceed to Payment on Checkout page
    And I am on Payment gateway page
