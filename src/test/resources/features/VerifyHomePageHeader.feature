Feature: I want to verify the presence of web elements on the home page


  @smoke @db
  Scenario: 1.I want to verify the presence of web elements on home page header section
    Given I am on homepage
    Then Verify the title contains "Home Decors, Lightings, Handbags, Rugs, Lanterns, Vintage Decorations | Elegantdecors.co.uk"
    And I should see the below items
      | webelements_on_header                |
      | ElegantDecors name and Logo          |
      | Free Next day Delivery message       |
      | Contact Phone number                 |
      | menu button                          |
      | cart                                 |
      | Product Search box and search symbol |
#
#    List < <String, String>>
#    =====================
#  webelements_on_header                | Key
#  | ElegantDecors name and Logo Value
#    <String, String>
#
#
#  webelements_on_header
#  | Free Next day Delivery message       |
#  <String, String>

  @regression @db
  Scenario: 2.I want to verify the presence of web elements on home page header section
    Given I am on homepage
    Then Verify that the URL should be "https://www.bipin.co.uk/elegant_"



#  Scenario: 6.I want to verify whether message saying "Why Choose www.bipin.co.uk/elegant_decors/:" is there or not
#    Given I am on homepage
#    Then I should see "Why Choose www.bipin.co.uk/elegant_decors/:" message and description
#
#

#  Scenario: 10.I want to verify presence of socialmedia items on footer under "FollowUs" heading
#    Given I am on homepage
#    When I open home page
#    And scroll down to footer of the page
#    Then I should see below items
#      | MediaOptions |
#      | facebook     |
#      | twitter      |
#      | g+           |
