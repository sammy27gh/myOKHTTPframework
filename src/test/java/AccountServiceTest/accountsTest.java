package AccountServiceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.testng.Assert;
import org.testng.Assert;

import AccountService.UserDefinedFunctions;
import AccountService.accounts;
import AccountService.accountsRequest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileReader.FileProcessor;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class accountsTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(accountsTest.class);
    
	
	public static  String SavedAccountid;
	public static String SavedCustomerid;
	static Response SaveResponse;
	static Response UseResponse;
  
	//@SuppressWarnings("unused")
	//private static UserDefinedFunctions userDefinedFunctions;

	static accounts javaBean;
	static List<accounts> requestList = new ArrayList<accounts>();
	static Map<String, accounts> dataMap = new HashMap<String, accounts>();

	static {
		//userDefinedFunctions = new UserDefinedFunctions();
		
		Map<String, String> columnMapping = new HashMap<String, String>();

		columnMapping.put("scenarioName", "scenarioName");
		columnMapping.put("acc_type", "acc_type");
		columnMapping.put("acc_status", "acc_status");
		columnMapping.put("cc_cardNumber", "cc_cardNumber");
		columnMapping.put("cc_nameOnCard", "cc_nameOnCard");
		columnMapping.put("cc_cardType", "cc_cardType");
		columnMapping.put("ba_type", "ba_type");
		columnMapping.put("ba_streetAddress", "ba_streetAddress");
		columnMapping.put("ba_locality", "ba_locality");
		columnMapping.put("ba_region", "ba_region");
		columnMapping.put("ba_postalCode", "ba_postalCode");
		columnMapping.put("ba_country", "ba_country");
		columnMapping.put("ba_formatted", "ba_formatted");
		columnMapping.put("ba_primary", "ba_primary");
		columnMapping.put("expiryDate_month", "expiryDate_month");
		columnMapping.put("expiryDate_year", "expiryDate_year");
		columnMapping.put("securityCode", "securityCode");
		columnMapping.put("sequenceNumber", "sequenceNumber");
		columnMapping.put("deviceId", "deviceId");
		columnMapping.put("nickName", "nickName");
		columnMapping.put("X_Wallet_Id", "X_Wallet_Id");
		columnMapping.put("Cache_control", "Cache_control");
		columnMapping.put("Postman_Token", "Postman_Token");
		columnMapping.put("responseCode", "responseCode");
		columnMapping.put("responseMessage", "responseMessage");

		String resources = "src/test/resources/environment/";
		String testDataFile = "/testdata/testdata.csv";
		
		String env = System.getProperty("env");
				//System.out.println(partners);
		
		
		
		requestList = new FileProcessor<accounts>().parseCSVToBeanList(resources + env + testDataFile, columnMapping,
				accounts.class);

		Iterator<accounts> iterator = requestList.iterator();
		while (iterator.hasNext()) {
			javaBean = iterator.next();
			dataMap.put(javaBean.getScenarioName(), javaBean);

		}
		System.out.println(javaBean);

	//	System.out.println(accountsRequest.Accounturl());

	}
	
	
	
	/*
	 * //Test Prerequisite Create Customer profile *
	 */
		
	@Given("^customer has credentials to create a their profile$")
	public void customer_has_credentials_to_create_a_their_profile() throws Throwable {

		try {
			String ScenarioName = "Create an new customer profile";
			LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
		} catch (ExceptionInInitializerError e) {
			System.err.println("caught in a static block " + e.getCause());
			// do something
		}
		
		
		
		
	
	}

	@When("^customer enters their credentials in an approved application$")
	public void customer_enters_their_credentials_in_an_approved_application() throws Throwable {
	try{   String ScenarioName = "Create an new customer profile";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		
		String  partners  = System.getProperty("partners");
		
		String requestAccountUrl = accountsRequest.Partnersurl(partners, SavedCustomerid);
		 System.out.println("accounturlfor partners is "+requestAccountUrl);
		RequestBody body = RequestBody.create(mediaType, accountsRequest.customerRequestBody());
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));
        
		Request request = new Request.Builder().url(requestAccountUrl)

				.post(body).headers(requestHeader).build();

		Response SavedResponse = client.newCall(request).execute();

		// Response SavedResponse = response;

		UseResponse = SavedResponse;

		// SavedCustomerid = accountsRequest.customerfdAccount();

	
	} catch(Exception e) {
		
		System.out.println(e.getMessage());
		Assert.fail();
		
	}
	
	
	}

	@Then("^Customer profile  should be created with customeridentification$")
	public void customer_profile_should_be_created_with_customeridentification() throws Throwable {
		try {
			String ScenarioName = "Create an new customer profile";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		int ActualResponseCode = UseResponse.code();
		String ActualResponseMessage = UseResponse.message();
		Assert.assertEquals(ActualResponseCode, dataMap.get(ScenarioName).getResponseCode());
		Assert.assertEquals(ActualResponseMessage, dataMap.get(ScenarioName).getResponseMessage());

		SavedCustomerid = UseResponse.body().source().readUtf8().substring(7, 39);

		System.out.println("our generated customer id is " + SavedCustomerid);
		} catch (Exception e) {
			e.getMessage();
			// LOGGER.error(e.getMessage());
			Assert.fail();
		}

	}

	@Given("^customer has credentials to create an account$")
	public void customer_has_credentials_to_create_an_account() throws Throwable {

		String ScenarioName = "Create an account associated with the customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer enters their card or account information$")
	public void customer_enters_their_card_or_account_information() throws Throwable {
		String ScenarioName = "Create an account associated with the customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		String requestAccountUrl = accountsRequest.Accounturl(SavedCustomerid);
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));
		String requestBody = accountsRequest.AccountRequestBody(dataMap.get(ScenarioName));

		System.out.println(requestAccountUrl);
		System.out.println(requestHeader);
		System.out.println(requestBody);

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,"{\"account\": {\r\n    \"type\": \"CREDIT\",\r\n    \"status\": \"ACTIVE\",\r\n    \"credit\": {\r\n      \"cardNumber\": \"5406020000000049\",\r\n      \"nameOnCard\": \"Meenal Somasundaram\",\r\n      \"cardType\": \"MASTERCARD\",\r\n      \"billingAddress\": {\r\n        \"type\": \"BILLING\",\r\n        \"streetAddress\": \"48 Ashford Dunwood\",\r\n        \"locality\": \"Hollywood\",\r\n        \"region\": \"GA\",\r\n        \"postalCode\": \"00000\",\r\n        \"country\": \"US\",\r\n        \"formatted\": \"100 Universal City Plaza\\nHollywood, CA 91608 USA\",\r\n        \"primary\": true\r\n      },\r\n      \"expiryDate\": {\r\n        \"month\": \"12\",\r\n        \"year\": \"19\"\r\n      },\r\n      \"securityCode\": \"444\",\r\n      \"sequenceNumber\": null\r\n    },\r\n    \"deviceId\": \"ea505f11-f45c-4c1f-8a84-506e753e134b\",\r\n    \"nickName\": \"myVisa\"\r\n  }\r\n}");
		Request request = new Request.Builder().url(requestAccountUrl).post(body).headers(requestHeader).build();

		Response SaveResponse = client.newCall(request).execute();

		UseResponse = SaveResponse;
		SavedAccountid = UseResponse.body().source().readUtf8().substring(16, 48);

		System.out.println(SavedAccountid);
	

		//System.out.println(UseResponse.body().source().readUtf8());
	}

	@Then("^Customer account should be created$")
	public void customer_account_should_be_created() throws Throwable {

		// UseAccountid = SavedAccountid;
		
		String ScenarioName = "Create an account associated with the customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
		Assert.assertEquals(UseResponse.code(), dataMap.get(ScenarioName).getResponseCode());
		Assert.assertEquals(UseResponse.message(), dataMap.get(ScenarioName).getResponseMessage());
		
		}

	@Given("^customer has a valid  account$")
	public void customer_has_a_valid_account() throws Throwable {
		String ScenarioName = "Read  active accounts associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer enters their identification number to get account information$")
	public void customer_enters_their_identification_number_to_get_account_information() throws Throwable {
		String ScenarioName = "Read  active accounts associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		String requestAccountUrl = accountsRequest.Accounturl(SavedCustomerid, SavedAccountid);
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));
		String requestBody = accountsRequest.AccountRequestBody(dataMap.get(ScenarioName));

		System.out.println(requestAccountUrl);
		System.out.println(requestHeader);
		System.out.println(requestBody);

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(requestAccountUrl).get().headers(requestHeader).build();

		Response SaveResponse = client.newCall(request).execute();

		UseResponse = SaveResponse;

	}

	@Then("^customer account should be displayed$")
	public void customer_account_should_be_displayed() throws Throwable {
		String ScenarioName = "Read  active accounts associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		Assert.assertEquals(UseResponse.code(), dataMap.get(ScenarioName).getResponseCode());
		Assert.assertEquals(UseResponse.message(), dataMap.get(ScenarioName).getResponseMessage());

	}

	@Given("^customer has registered and obtained valid  account$")
	public void customer_has_registered_and_obtained_valid_account() throws Throwable {

		String ScenarioName = "Read all active accounts associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer enters their  account information$")
	public void customer_enters_their_account_information() throws Throwable {
		String ScenarioName = "Read all active accounts associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
        
		String requestAccountUrl = accountsRequest.Accounturl(SavedCustomerid);
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));
		String requestBody = accountsRequest.AccountRequestBody(dataMap.get(ScenarioName));

		System.out.println(requestAccountUrl);
		System.out.println(requestHeader);
		System.out.println(requestBody);

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(requestAccountUrl).get().headers(requestHeader).build();

		Response SaveResponse = client.newCall(request).execute();

		UseResponse = SaveResponse;

	}

	@Then("^customer should be able to view  all accounts$")
	public void customer_should_be_able_to_view_all_accounts() throws Throwable {
		String ScenarioName = "Read all active accounts associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		Assert.assertEquals(UseResponse.code(), dataMap.get(ScenarioName).getResponseCode());
		Assert.assertEquals(UseResponse.message(), dataMap.get(ScenarioName).getResponseMessage());

	}

	@Given("^customer has successfully  created an account$")
	public void customer_has_successfully_created_an_account() throws Throwable {
		String ScenarioName = "Update an account associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer updates part of their information$")
	public void customer_updates_part_of_their_information() throws Throwable {
		String ScenarioName = "Update an account associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		String requestAccountUrl = accountsRequest.Accounturl(SavedCustomerid, SavedAccountid);
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));

		String requestBody = accountsRequest.PatchAccountRequestBody(dataMap.get(ScenarioName));

		OkHttpClient client = new OkHttpClient();

		System.out.println(requestAccountUrl);
		System.out.println(requestHeader);
		System.out.println(requestBody);

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, requestBody);
		Request request = new Request.Builder().url(requestAccountUrl).patch(body).headers(requestHeader).build();

		Response SaveResponse = client.newCall(request).execute();

		UseResponse = SaveResponse;

		System.out.println(SaveResponse);

	}

	@Then("^Customer account should be updated with the new information$")
	public void customer_account_should_be_updated_with_the_new_information() throws Throwable {
		String ScenarioName = "Update an account associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		Assert.assertEquals(UseResponse.code(), dataMap.get(ScenarioName).getResponseCode());
		Assert.assertEquals(UseResponse.message(), dataMap.get(ScenarioName).getResponseMessage());

	}

	@Given("^customer has account successfuly created$")
	public void customer_has_account_successfuly_created() throws Throwable {
		System.out.println(UseResponse.code());
		System.out.println(UseResponse.message());

		String ScenarioName = "Delete an account associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer deletes their  account information$")
	public void customer_deletes_their_account_information() throws Throwable {
		String ScenarioName = "Delete an account associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
		String requestAccountUrl = accountsRequest.Accounturl(SavedCustomerid, SavedAccountid);
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));
		// String requestBody =
		// accountsRequest.AccountRequestBody(dataMap.get(ScenarioName));

		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(requestAccountUrl).delete(null).headers(requestHeader).build();
		Response SaveResponse = client.newCall(request).execute();
		UseResponse = SaveResponse;

	}

	@Then("^customer should not be able to see a deleted account$")
	public void customer_should_not_be_able_to_see_a_deleted_account() throws Throwable {
		String ScenarioName = "Delete an account associated with the  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		Assert.assertEquals(UseResponse.code(), dataMap.get(ScenarioName).getResponseCode());
		Assert.assertEquals(UseResponse.message(), dataMap.get(ScenarioName).getResponseMessage());

	}

	@Given("^customer has credentials  to create an credit card account$")
	public void customer_has_credentials_to_create_an_credit_card_account() throws Throwable {
		String ScenarioName = "Create Credit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer enters their credit card card account information$")
	public void customer_enters_their_credit_card_card_account_information() throws Throwable {
		String ScenarioName = "Create Credit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

		String requestAccountUrl = accountsRequest.Accounturl(SavedCustomerid);
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));
		String requestBody = accountsRequest.AccountRequestBody(dataMap.get(ScenarioName));

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, requestBody);
		Request request = new Request.Builder().url(requestAccountUrl).post(body).headers(requestHeader).build();

		Response SaveResponse = client.newCall(request).execute();

		UseResponse = SaveResponse;

		System.out.println(SaveResponse);

	}

	@Then("^Customer credit card account should be created$")
	public void customer_credit_card_account_should_be_created() throws Throwable {
		String ScenarioName = "Create Credit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
		Assert.assertEquals(UseResponse.code(), dataMap.get(ScenarioName).getResponseCode());
		Assert.assertEquals(UseResponse.message(), dataMap.get(ScenarioName).getResponseMessage());

	}

	@Given("^customer has credentials  to create an Debit card account$")
	public void customer_has_credentials_to_create_an_Debit_card_account() throws Throwable {
		String ScenarioName = "Create Debit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer enters their Debit card card account information$")
	public void customer_enters_their_Debit_card_card_account_information() throws Throwable {
		String ScenarioName = "Create Debit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
		String requestAccountUrl = accountsRequest.Accounturl(SavedCustomerid);
		Headers requestHeader = accountsRequest.getHeaders(dataMap.get(ScenarioName));
		String requestBody = accountsRequest.AccountRequestBody(dataMap.get(ScenarioName));

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, requestBody);
		Request request = new Request.Builder().url(requestAccountUrl).post(body).headers(requestHeader).build();

		Response SaveResponse = client.newCall(request).execute();

		UseResponse = SaveResponse;

		System.out.println(SaveResponse);

	}

	@Then("^Customer Debit card account should be created$")
	public void customer_Debit_card_account_should_be_created() throws Throwable {
		String ScenarioName = "Create Debit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));
	}

	@Given("^customer has credentials  to create prepaid account$")
	public void customer_has_credentials_to_create_prepaid_account() throws Throwable {
		String ScenarioName = "Create Debit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@When("^customer enters their prepaid account account information$")
	public void customer_enters_their_prepaid_account_account_information() throws Throwable {
		String ScenarioName = "Create Debit Card account as  customer";
		LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

	}

	@Then("^Customer prepaid  account should be created$")
	public void customer_prepaid_account_should_be_created() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^customer has credentials  to create loyalty account$")
	public void customer_has_credentials_to_create_loyalty_account() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^customer enters their loyalty account account information$")
	public void customer_enters_their_loyalty_account_account_information() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Customer loyalty  account should be created$")
	public void customer_loyalty_account_should_be_created() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^customer has credentials  to create Paypal account$")
	public void customer_has_credentials_to_create_Paypal_account() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^customer enters their Paypal account account information$")
	public void customer_enters_their_Paypal_account_account_information() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^customer Paypal  account should be created$")
	public void customer_Paypal_account_should_be_created() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^customer has credentials  to create Nonce account$")
	public void customer_has_credentials_to_create_Nonce_account() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^customer enters their Nonce account  information$")
	public void customer_enters_their_Nonce_account_information() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Customer Nonce  account should be created$")
	public void customer_Nonce_account_should_be_created() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^Existing account customer has credentials create  account$")
	public void existing_account_customer_has_credentials_create_account() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Existing customer enters the same  card or account information$")
	public void existing_customer_enters_the_same_card_or_account_information() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Existing customer should be blocked for suspicious activity$")
	public void existing_customer_should_be_blocked_for_suspicious_activity() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
