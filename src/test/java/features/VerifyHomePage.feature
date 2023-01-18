Feature: I want to verify the presence of web elements on the home page

  Scenario: 1.I want to verify the presence of web elements on home page header section
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    Then Verify the title contains "Home Decors, Lightings, Handbags, Rugs, Lanterns, Vintage Decorations | Elegantdecors.co.uk"
    And I should see the below items on Home page header
      | WebElements_on_header                |
      | ElegantDecors name and Logo          |
      | Free Next day Delivery message       |
      | Contact Phone number                 |
      | menu button                          |
      | cart                                 |
      | Product Search box and search symbol |
    And Close the browser

  Scenario: 2.I want to verify the presence of web elements on home page horizontal menubar
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    Then I should see the below items on menubar
      | menubar_items  |
      | Home           |
      | Cremation Urns |
      | Home Decors    |
      | New Arrivals   |
    And Close the browser

  Scenario: 3.I want to verify the presence of dynamically changing banners on home page
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    Then I should see below banners dynamically changing
      | banners                 |
      | Adult Cremation Urns    |
      | Keepsake Cremation Urns |
      | Pet Cremation Urns      |
      | Home Decors             |
    And Close the browser

  Scenario: 4.I want to verify the presence of web elements on home page Top categories section
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    Then I should see below items
      | TopCategoryItems |
      | Adult Urns       |
      | Keepsake Urns    |
      | Heart Keepsake   |
      | Home Decors      |
    And Close the browser

  Scenario: 5.I want to verify the presence of web elements on home page Top Selling Products section
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    Then I should see below items
#   I entered only 3 products
  |Top_Selling_Products|Price |
  |Classic Falling Leves Large Adult Funeral Urn For Ashes      |£109.99|
  |Natural Punga Color Aluminium Large Cremation Urn For Ashes+Free jewellery Urn |£109.99|
  |New Test Plush Anti-slip Cat House ChristalPlush Warm Round Pet Nest Deep Sleep|£34.99 |
    And Close the browser

  Scenario: 6.I want to verify whether message saying "Why Choose www.bipin.co.uk/elegant_decors/:" is there or not
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    Then I should see "Why Choose www.bipin.co.uk/elegant_decors/:" message and description
    And Close the browser

  Scenario: 7.I want to verify whether contact address is there on footer or not
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    And  scroll down to footer of the page
    Then I should see ElegantDecors address under "Contact Us" heading
    And Close the browser

  Scenario: 8.I want to verify presence of items on footer under "UsefulLinks" heading
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    And scroll down to footer of the page
    Then I should see following links
      | UsefulLinks       |
      | Terms&Conditions  |
      | Testimonials      |
      | Privacy Statement |
      | Sitemap           |
      | Cookies           |
      | Contact Us        |
      | Refund Policy     |
      | Delivery Policy   |
      | Disclaimer        |
      | About Us          |
    And Close the browser

  Scenario: 9.I want to verify presence of items on footer under "Categories" heading
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    And scroll down to footer of the page
    Then I should see below items
      | Categories Links |
      | Cremation Urns   |
      | Home Decors      |
    And Close the browser

  Scenario: 10.I want to verify presence of socialmedia items on footer under "FollowUs" heading
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    And scroll down to footer of the page
    Then I should see below items
      | MediaOptions |
      | facebook     |
      | twitter      |
      | g+           |
    And Close the browser

  Scenario: 11.I want to verify presence of PayPal link is there on footer or not
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    And scroll down to footer of the page
    Then I should see "PayPal" link
    And Close the browser

  Scenario: 12.I want to verify presence of payment options on footer
    Given I have a valid URL for "ElegantDecors"
    When I open home page
    And scroll down to footer of the page
    Then I should see below items
      | paymentOptions |
      | MasterCard     |
      | Visa           |
      | Maestro        |
      | Delta          |
      | Switch         |
      | Solo           |
    And Close the browser