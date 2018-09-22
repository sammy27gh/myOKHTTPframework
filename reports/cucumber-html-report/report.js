$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("terms.feature");
formatter.feature({
  "line": 2,
  "name": "Login Feature",
  "description": "I want to use this template for my feature file",
  "id": "login-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Validate the UserName and Password",
  "description": "",
  "id": "login-feature;validate-the-username-and-password",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I have a prescription Application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I enter the correct UserName and Password",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should be able to see the HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "DataVariableTest.i_have_a_prescription_Application()"
});
formatter.result({
  "duration": 325966283,
  "status": "passed"
});
formatter.match({
  "location": "DataVariableTest.i_enter_the_correct_UserName_and_Password()"
});
formatter.result({
  "duration": 3395365744,
  "status": "passed"
});
formatter.match({
  "location": "DataVariableTest.i_should_be_able_to_see_the_HomePage()"
});
formatter.result({
  "duration": 11710459,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Validate the Login Functionality",
  "description": "",
  "id": "login-feature;validate-the-login-functionality",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I enter an invalid userName and Password",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "i initiate the tool",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I should be able to guide the tool",
  "keyword": "Then "
});
formatter.match({
  "location": "DataVariableTest.i_enter_an_invalid_userName_and_Password()"
});
formatter.result({
  "duration": 216423,
  "status": "passed"
});
formatter.match({
  "location": "DataVariableTest.i_initiate_the_tool()"
});
formatter.result({
  "duration": 34929,
  "status": "passed"
});
formatter.match({
  "location": "DataVariableTest.i_should_be_able_to_guide_the_tool()"
});
formatter.result({
  "duration": 31162,
  "status": "passed"
});
});