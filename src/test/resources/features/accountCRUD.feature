#Author: samuel.andoh@firstdata.com
#Keywords Summary :
#Feature: To test the functionality of the Account service
#@ (Tags/Labels):To group Scenarios
#@Sonic
#<> (placeholder)
Feature: Create Account
  I want to use this template for my feature file

  # Basic Crud Operation Validation
  #Precondition: Create a customer account
  @Sonic
  Scenario: Create an new customer profile
    Given customer has credentials to create a their profile
    When customer enters their credentials in an approved application
    Then Customer profile  should be created with customeridentification


  Scenario: Create an account associated with the customer
    Given customer has credentials to create an account
    When customer enters their card or account information
    Then Customer account should be created

  
  Scenario: Read  active accounts associated with the  customer
    Given customer has a valid  account
    When customer enters their identification number to get account information
    Then customer account should be displayed

  Scenario: Read all active accounts associated with the  customer
    Given customer has registered and obtained valid  account
    When customer enters their  account information
    Then customer should be able to view  all accounts

  Scenario: Update an account associated with the  customer
    Given customer has successfully  created an account
    When customer updates part of their information
    Then Customer account should be updated with the new information

  Scenario: Delete an account associated with the  customer
    Given customer has account successfuly created
    When customer deletes their  account information
    Then customer should not be able to see a deleted account

  #Basic Account type validation
  Scenario: Create Credit Card account as  customer
    Given customer has credentials  to create an credit card account
    When customer enters their credit card card account information
    Then Customer credit card account should be created

  Scenario: Create Debit Card account as  customer
    Given customer has credentials  to create an Debit card account
    When customer enters their Debit card card account information
    Then Customer Debit card account should be created

  Scenario: Create a prepaid account as  customer
    Given customer has credentials  to create prepaid account
    When customer enters their prepaid account account information
    Then Customer prepaid  account should be created

  Scenario: Create a Loyalty account as  customer
    Given customer has credentials  to create loyalty account
    When customer enters their loyalty account account information
    Then Customer loyalty  account should be created

  Scenario: Create a Paypal account as  customer
    Given customer has credentials  to create Paypal account
    When customer enters their Paypal account account information
    Then customer Paypal  account should be created

  Scenario: Create a Nonce account as  customer
    Given customer has credentials  to create Nonce account
    When customer enters their Nonce account  information
    Then Customer Nonce  account should be created

  Scenario: Create a ach account as  customer

  #Error Response Code validation
  #Trigger Conflict Errors
  Scenario: Create an account again with the same customer

  # Trigger Errors using account type
  Scenario: Validate that an error is thrown when creating account with status INACTIVE

  Scenario: Validate that an error is thrown when creating account with status ISSUER_TERMINATED

  Scenario: Validate that an error is thrown when creating account with status WALLET_TERMINATED

  Scenario: Validate that an error is thrown when creating account with status PENDING

  #Trigger Erros using securityCode
  Scenario: Validate that an error is thrown when creating an account with the wrong securityCode

  Scenario: Validate that an error is thrown when creating an account with securityCode longer three characters

  Scenario: Validate that an error is thrown when creating an account with securityCode longer as empty string

  #Trigger Errors using Device Id
  Scenario: Validate that an error is thrown when there is no device or deviceId is wrong

  Scenario: Validate that an error is thrown when device or deviceId is wrong missing

  # Trigger System or Server error validation
  
  Scenario:  Validate that an error is thrown when payload message format is wrong
  
  
  