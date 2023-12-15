Feature: Interview

  @Shwetha
  Scenario Outline: Interview
    Given user launch the website using the URL "https://www.tendable.com"
    Then user verify the accessibility of the "<topLevelMenus>"
    And user verify "Request a Demo" button under "<topLevelMenus>"
    When user navigate to "Contact Us" page
    And user clicks "Contact" button under "Marketing" in Contact us page
    When user fill the Marketing Contact form and validate the submission
      | Full Name | Organisation Name | Phone Number | Email                 |
      | Shwetha   | Tendable          |   9123456789 | shwethah@tendable.com |

    Examples: 
      | topLevelMenus                                              |
      | ['Our Story', 'Our Solution', 'Why Tendable?', 'tendable'] |