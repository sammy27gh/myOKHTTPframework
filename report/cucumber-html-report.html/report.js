$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("testLogin.feature");
formatter.feature({
  "id": "login-feature",
  "tags": [
    {
      "name": "@login",
      "line": 1
    }
  ],
  "description": "I want to use this template for my feature file",
  "name": "Login Feature",
  "keyword": "Feature",
  "line": 2
});
formatter.scenario({
  "id": "login-feature;validate-the-username-and-password",
  "description": "",
  "name": "Validate the UserName and Password",
  "keyword": "Scenario",
  "line": 5,
  "type": "scenario"
});
formatter.step({
  "name": "I have a prescription Application",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "I enter the correct UserName and Password",
  "keyword": "When ",
  "line": 7
});
formatter.step({
  "name": "I should be able to see the HomePage",
  "keyword": "Then ",
  "line": 8
});
formatter.match({
  "location": "ApplicationTest.i_have_a_prescription_Application()"
});
formatter.result({
  "duration": 561518693,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationTest.i_enter_the_correct_UserName_and_Password()"
});
formatter.result({
  "duration": 178515,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationTest.i_should_be_able_to_see_the_HomePage()"
});
formatter.result({
  "duration": 58283,
  "status": "passed"
});
formatter.scenario({
  "id": "login-feature;check-that-the-username-and-password-is-invalid",
  "description": "",
  "name": "check that the UserName and Password is invalid",
  "keyword": "Scenario",
  "line": 10,
  "type": "scenario"
});
formatter.step({
  "name": "check that the password is invalid",
  "keyword": "Given ",
  "line": 11
});
formatter.step({
  "name": "verify that you are able to receive the data",
  "keyword": "When ",
  "line": 12
});
formatter.step({
  "name": "User should be able to get it done",
  "keyword": "Then ",
  "line": 13
});
formatter.match({
  "location": "ApplicationTest.check_that_the_password_is_invalid()"
});
formatter.result({
  "duration": 116933,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationTest.verify_that_you_are_able_to_receive_the_data()"
});
formatter.result({
  "duration": 6070254,
  "status": "pending",
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat Interview.ApplicationTest.verify_that_you_are_able_to_receive_the_data(ApplicationTest.java:41)\r\n\tat ✽.When verify that you are able to receive the data(testLogin.feature:12)\r\n"
});
formatter.match({
  "location": "ApplicationTest.user_should_be_able_to_get_it_done()"
});
formatter.result({
  "status": "skipped"
});
});