@E2E
Feature: Verify SIA Login functionality

  Background: Initialize browser

  # as a example- Given Users navigates to the SIA website OR * invoke a browser before the test start
  @Sanity
  Scenario: Verify Login with Datatable
    #Given Users navigates to the SIA website
    #When User enters username and password
    #And clicks login button
    #Then User home page is displayed
    And Enter my current nominee details
      | name  | age | sex |
      | rohit |  37 | M   |
      | rekha |  35 | F   |
      | raj   |   2 | M   |
      | yug   |   1 | M   |

  @Sanity
  Scenario: Verify Login with Datatable
    And Enter my current nominee details
      | name   | age | sex |
      | rohit1 |  37 | M   |
      | rekha1 |  35 | F   |
      | raj1   |   2 | M   |
      | yug1   |   1 | M   |

  @Regression
  Scenario Outline: Verify Login with examples
    Given Users navigates to the SIA website
    When User enters "<username>" and "<password>"
    And clicks login button
    Then User home page is displayed
    Then Verify other page items as "<name>" <accountno> "<address>" <miles> <expMiles> "<mytrip>" <credits>

    Examples: 
      | username    | password     | name | accountno  | address | miles | expMiles | mytrip | credits |
      |  8989898989 | Pass123 | RS   | 8989898989 | SG      | 12345 | 23456711 | SG-IND | 9999999 |
      |  8989898988 | Pass123 | RR   | 8989898989 | SG      | 12345 | 23456711 | SG-IND | 9999999 |
      | RohitSawant | Pass123 | RS   | 8989898989 | SG      | 12345 | 23456711 | SG-IND | 9999999 |

  @SanityTest
  Scenario: Verify Login with Datatable
    And Enter my current nomineetest details
      | name   | age | sex |  
      | rohit1 |  37 | M   | 
      