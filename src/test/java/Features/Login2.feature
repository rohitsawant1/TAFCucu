@Login2
Feature: Verify SIA Login functionality
      Background: Initialize browser 
      	Scenario: Verify Login
      		Given Users navigates to the SIA website
      		When User enters username and password
      		And clicks login button
      		Then User home page is displayed