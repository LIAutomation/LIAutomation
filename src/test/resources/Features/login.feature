@TotalReg
Feature: LI Application Automation
  @RegressionTest
  Scenario Outline: Login to LIApplication using Scenario
    Given User Launched LI Application
    Then Launching Li Application url
    When user enter userid and password into the application
    Then User verifies Home Page of the Application
    #Then User Verifies the data from ExcelFile "<rowNum>","<colNum>"
    Then User Verifies the data from ExcelFile1 "<colNum>"
    #And click login button

    Examples:
      | rowNum | colNum |
      | 1      | 2      |













