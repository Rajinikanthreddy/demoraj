Feature: Application Login
Scenario Outline: Positive test validating login
	Given Initilaize the browser with chrome
	And Navigate to "http://qaclickacademy.com" application
	And Click on Sign in Link in home page to land on secure sign in page
	When user login enters with <Username> and <Password>
	Then verify user is successfully logged in
	And close browsers
Examples:
|Username   |Password	|
|raini			|Komali		|
|Heelo 			|Godrej		|
|dood				|Bad			|