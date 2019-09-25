Feature: login
Scenario Outline: validate uid field
Given launch site
When enter uid as "<u>"
And click uid next button
Then check uid outcome with "<uc>" criteria
When close site 
Examples: 
|   u                            |   uc      |
|ramanjithottempudi6729@gmail.com|uid-valid  |
|                                |uid-blank  |
|ram.ogl2314                     |uid-invalid|