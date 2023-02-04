@homepage @ui
Feature: I want to verify the presence of web elements on the home page

  Background:
    Given I am on homepage

  Scenario: 2.I want to verify the presence of web elements on home page horizontal menu-bar
    Then I should see the below items on menubar
      | MENUBAR_ITEMS  |
      | Home           |
      | Cremation Urns |
      | Home Decors    |
      | New Arrivals   |


  Scenario: 3.I want to verify the presence of dynamically changing banners on home page
    Then I should see below banner images available
      | BANNERS_IMAGE_ALT_TEXT  |
      | Cremation Urns          |
      | Keepsake Cremation Urns |
      | Pet Cremation Urns      |
      | Home Decors             |



# *** Note: In the above scenario, the issue is how do you indentify that 'Adust ...' banner is the image number 1 or 2 or 4th oe ?
#  so , psss the data based on which I can identify the image, generally it should be URL (href) or, Tooltip or name (if available)...Feature:

  #*** Note: The below scenario indirectly covered in below scenario , while buying item, it will search for the sectio, if not found, it will fail,
  # so indirectly it is validatig., no need to duplicate it.... Pramod.

#  Scenario: 4.I want to verify the presence of web elements on home page Top categories section
#    Then I should see below items under "Top Category" section on home page
#      | TopCategoryItems |
#      | Adult Urns       |
#      | Keepsake Urns    |
#      | Heart Keepsake   |
#      | Home Decors      |

  Scenario Outline: Scneario 4 also coveres - Verify user can proceed buy the product from --Top Category-- section on home page
    When I choose a category "<TopCategoryName>" from "Top Categories" section on home page
    And I select "first" item to buy from the list on Product search result page
    Then The Product name should be displayed on Product detail page as expected
  Examples:
      | TopCategoryName |
      | Adult Urns       |
      | Keepsake Urns    |
      | Heart Keepsake   |

    # In below scenario for section Home Decors ther are proucts with title contains double quote ", example: 15"... which creates problem, we have to handle to separtely, as of now just skipping it.
    @done
  Scenario Outline: Scneario 4.1 also coveres - Verify user can proceed buy the product from --Top Category-- section on home page ('Home Decors' executing separately as it has different element properties)
    When I choose a category "<TopCategoryName>" from "Top Categories" section on home page
    And I select "last" item to buy from the list on Product search result page
    Then The Product name should be displayed on Product detail page as expected
    Examples:
      | TopCategoryName |
      | Home Decors      |

# homework
#  Scenario: 5.I want to verify the presence of web elements on home page Top Selling Products section on home page
#    Then I should see below items under "Top Selling Products" section on home page
#      | Top_Selling_Products                                                            | Price   |
#      | Classic Falling Leves Large Adult Funeral Urn For Ashes                         | £109.99 |
#      | Natural Punga Color Aluminium Large Cremation Urn For Ashes+Free jewellery Urn  | £109.99 |
#      | New Test Plush Anti-slip Cat House ChristalPlush Warm Round Pet Nest Deep Sleep | £34.99  |


  Scenario: Verify user can proceed buy the product from --Top Selling produts-- section
    When I choose a product from "Top Selling Products" section on home page
#    And I select "last" item to buy from the list on Product search result page
    Then The Product name should be displayed on Product detail page as expected


#  Scenario: 6.I want to verify whether message saying "Why Choose www.bipin.co.uk/elegant_decors/:" is there or not
#    Then I should see "Why Choose www.bipin.co.uk/elegant_decors/:" message and description
