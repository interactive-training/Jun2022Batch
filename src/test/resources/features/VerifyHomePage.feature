#Feature: I want to verify the presence of web elements on the home page
#
#
#  Scenario: 2.I want to verify the presence of web elements on home page horizontal menubar
#    Given I am on homepage
#    Then I should see the below items on menubar
#      | menubar_items  |
#      | Home           |
#      | Cremation Urns |
#      | Home Decors    |
#      | New Arrivals   |
#
#
#  Scenario: 3.I want to verify the presence of dynamically changing banners on home page
#    Given I have a valid URL for "ElegantDecors"
#    When I open home page
#    Then I should see below banners dynamically changing
#      | banners                 |
#      | Adult Cremation Urns    |
#      | Keepsake Cremation Urns |
#      | Pet Cremation Urns      |
#      | Home Decors             |
#
#
#  Scenario: 4.I want to verify the presence of web elements on home page Top categories section
#    Given I have a valid URL for "ElegantDecors"
#    When I open home page
#    Then I should see below items
#      | TopCategoryItems |
#      | Adult Urns       |
#      | Keepsake Urns    |
#      | Heart Keepsake   |
#      | Home Decors      |
##
#
#  Scenario: 5.I want to verify the presence of web elements on home page Top Selling Products section
#    Given I have a valid URL for "ElegantDecors"
#    When I open home page
#    Then I should see below items
##  // I entered only 3 products
#  |Top_Selling_Products|               |Price |
#  |Classic Falling Leves Large Adult Funeral Urn For Ashes      |£109.99|
#  |Natural Punga Color Aluminium Large Cremation Urn For Ashes+Free jewellery Urn |£109.99|
#  |New Test Plush Anti-slip Cat House ChristalPlush Warm Round Pet Nest Deep Sleep|£34.99 |
#
#
#  Scenario: 6.I want to verify whether message saying "Why Choose www.bipin.co.uk/elegant_decors/:" is there or not
#    Given I have a valid URL for "ElegantDecors"
#    When I open home page
#    Then I should see "Why Choose www.bipin.co.uk/elegant_decors/:" message and description
