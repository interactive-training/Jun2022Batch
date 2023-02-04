@header @ui
Feature: I want to verify the presence of web elements on the home page

  Background:
    Given I am on homepage

  @regression
  Scenario: 1.I want to verify the presence of web elements on home page header section
    Then Verify the title contains "Home Decors, Lightings, Handbags, Rugs, Lanterns, Vintage Decorations | Elegantdecors.co.uk"
    And I should see the below items on Home page header
      | WEBELEMENTS_ON_HEADER                |
      | ElegantDecors name and Logo          |
      | Free Next day Delivery message       |
      | Contact Phone number                 |
      | menu button                          |
      | cart                                 |
      | Product Search box and search symbol |

###  @regression @db
###  Scenario: 2.I want to verify the presence of web elements on home page header section
###    Then Verify that the URL should be "https://www.bipin.co.uk/elegant_"
##
####
####  Scenario: 6.I want to verify whether message saying "Why Choose www.bipin.co.uk/elegant_decors/:" is there or not
####    Given I am on homepage
####    Then I should see "Why Choose www.bipin.co.uk/elegant_decors/:" message and description
###
##
#  Scenario: 7.I want to verify whether contact address is there on footer or not
#    Then I should see ElegantDecors address under "Contact Us" heading
#
