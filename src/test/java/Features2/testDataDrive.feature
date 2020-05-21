Feature: Test datatable using poi

  Background: Initialize td

  @Datatab
  Scenario: verify my Dt login

  #Given Get the test data alone "src/main/resources/Data/personData.xlsx"
  @Dataex
  Scenario Outline: Verify my Ex login
    # add a step to provide test data xls and sheet name
    Given Get the test data alone "src/main/resources/Data/personData.xlsx" "Sheet1" "<Testcase>"
    When my login "<username>" and "<password>"
    Then my details

    Examples: 
      | Testcase | Testcase Description |
      | T1       | Desc1                |
      | T2       | Desc2                |
