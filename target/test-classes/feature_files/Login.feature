#Author: Sarthak Kumar Panda
@TutorialsNinjaLogin
Feature: Login functionality of TutorialsNinja Application

Background: Giving common steps to run before all scenarios
Given user navigates to LoginPage

@ValidCredentials
Scenario Outline: Login with valid credentials
When user enters valid email <email> into email textbox field
And user enters valid password <password> into password textbox field
And user clicks on Login button
Then user is navigated to AccountPage
Examples:

|  email 								   |  password    |
|seleniumpanda@gmail.com   | Selenium@123 |
|seleniumpanda1@gmail.com  | Selenium@123 |
|seleniumpanda2@gmail.com  | Selenium@123 |
|seleniumpanda3@gmail.com  | Selenium@123 |
|seleniumpanda4@gmail.com  | Selenium@123 |
|seleniumpanda5@gmail.com  | Selenium@123 |
|seleniumpanda6@gmail.com  | Selenium@123 |
|seleniumpanda7@gmail.com  | Selenium@123 |
|seleniumpanda8@gmail.com  | Selenium@123 |
|seleniumpanda9@gmail.com  | Selenium@123 |
|seleniumpanda10@gmail.com | Selenium@123 |

@InvalidCredentials
Scenario: Login with invalid credentials
When user enters invalid email "seleniumpandahelloworld@gmail.com" into email textbox field
And user enters invalid password "Selenium@123456" into password textbox field
And user clicks on Login button
Then user gets warning message about credentials mismatch

@ValidEmailInvalidPassword
Scenario: Login with valid email invalid password 
When user enters valid email "seleniumpanda@gmail.com" into email textbox field
And user enters invalid password "Selenium@123456" into password textbox field
And user clicks on Login button
Then user gets warning message about credentials mismatch

@InvalidEmailValidPassword
Scenario: Login with invalid email valid password 
When user enters invalid email "seleniumpandahelloworld@gmail.com" into email textbox field
And user enters valid password "Selenium@123" into password textbox field
And user clicks on Login button
Then user gets warning message about credentials mismatch

@NoCredentials
Scenario: Login with no credentials 
And user clicks on Login button
Then user gets warning message about credentials mismatch