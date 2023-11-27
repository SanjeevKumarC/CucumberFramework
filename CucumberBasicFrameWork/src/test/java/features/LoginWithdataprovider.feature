
Feature: Application login


  Scenario Outline: Home page default Login
    Given Initialize the browser with chrome
    And Navigate To "https://www.rediff.com/" sites
    And Verify Home Page Is Displayed
    When Enter <FullName> and <RediffEmail>
    Then  Check for email availability
    And Close browser
    
    Examples:
|FullName|RediffEmail|
|Manoj|Manojbalasubramaniyam4488@|
|Sanjay|SanjayShadhashivam4488@|

