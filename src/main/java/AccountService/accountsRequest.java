package AccountService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Headers.Builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Headers.Builder;
import okhttp3.internal.http2.Header;

public class accountsRequest {

	private static final Builder Builder = null;

	public static String Accounturl() {

		HttpUrl customerUrl = new HttpUrl.Builder().scheme("https")
				.host("ucom-customer-services-dev.apps.us-oma1-np2.1dc.com")
				.addEncodedPathSegments("v1/partners/SONIC/customers").build();

		return customerUrl.toString();
	}

	public static String customerRequestBody() {
		
		Random random = new Random();

		int  externalId = random.nextInt(100000);

		System.out.println(externalId);

		String customerAccount = "{\r\n  \"customer\" : {\r\n      \"externalId\" : " + externalId + "\r\n  }\r\n}";
		
		return customerAccount;

	}

	

	public static String Accounturl(String SavedCustomerid) throws IOException {
		HttpUrl url = new HttpUrl.Builder().scheme("https").host("ucom-account-services-dev.apps.us-oma1-np2.1dc.com")
				.addEncodedPathSegments("v1/partners/SONIC/customers").addEncodedPathSegments(SavedCustomerid)
				.addEncodedPathSegments("accounts")

				// .addQueryParameter("q", "polar bears")
				.build();
		// System.out.println(accounturl);
		return url.toString();

	}
	
	public static String Partnersurl(String partners, String SavedCustomerid) throws IOException {
		HttpUrl url = new HttpUrl.Builder().scheme("https").host("ucom-account-services-dev.apps.us-oma1-np2.1dc.com")
				.addEncodedPathSegments("v1/partners").addEncodedPathSegments(partners).addEncodedPathSegments("customers").addEncodedPathSegments(SavedCustomerid)
				.addEncodedPathSegments("accounts")

				// .addQueryParameter("q", "polar bears")
				.build();
		// System.out.println(accounturl);
		return url.toString();

	}

	public static String Accounturl(String SavedCustomerid, String SavedAccountid) {
		HttpUrl url = new HttpUrl.Builder().scheme("https").host("ucom-account-services-dev.apps.us-oma1-np2.1dc.com")
				.addEncodedPathSegments("v1/partners/SONIC/customers").addEncodedPathSegments(SavedCustomerid)
				.addEncodedPathSegments("accounts").addEncodedPathSegments(SavedAccountid)

				// .addQueryParameter("q", "polar bears")
				.build();
		// System.out.println(accounturl);
		return url.toString();

	}

	
	public static Headers getHeaders(accounts datavariable) {

		// verifyfunctions = new userDefinedFunctions();
		Builder header = new Headers.Builder();
		header.add("Content-Type", "application/json");
		header.add("X-Wallet-Id", datavariable.getX_Wallet_Id()).toString();
		header.add("Cache-control", datavariable.getCache_control()).toString();
		header.add("Postman-Token", datavariable.getPostman_Token()).toString();

		return header.build();

	}

	public static String AccountRequestBody(accounts datavariable) {

		String AccountRequest = "{\r\n  \"account\": {\r\n    \"type\": \"+datavariable.getAcc_type()+\",\r\n   "
				+ " \"status\": \"+datavariable.getAcc_status()+\",\r\n"
				+ "    \"credit\": {\r\n      \"cardNumber\": \"+datavariable.getCc_cardNumber()+\",\r\n   "
				+ "   \"nameOnCard\": \"+datavariable.getCc_nameOnCard()+\",\r\n      \"cardType\": \"+datavariable.getCc_cardType()+\",\r\n  "
				+ "    \"billingAddress\": {\r\n        \"type\": \"+datavariable.getBa_type()+\",\r\n      "
				+ "  \"streetAddress\": \"+datavariable.getBa_streetAddress()+\",\r\n     \"locality\": \"+datavariable.getBa_locality()+\",\r\n       "
				+ " \"region\": \"+datavariable.getBa_region()+\",\r\n      \"postalCode\": \"+datavariable.getBa_postalCode()+\",\r\n       "
				+ " \"country\": \"+datavariable.getBa_country()+\",\r\n        "
				+ "\"formatted\": \"+datavariable.getBa_formatted()+\",\r\n      " + "\"primary\": "
				+ datavariable.getBa_primary().toLowerCase() + " \r\n      },\r\n     \"expiryDate\": {\r\n      "
				+ "  \"month\": \"+datavariable.getExpiryDate_month()+\",\r\n      \"year\": \"+datavariable.getExpiryDate_year()+\"\r\n      },\r\n    "
				+ "  \"securityCode\": \"+datavariable.getSecurityCode()+\",\r\n  \"sequenceNumber\": "
				+ datavariable.getSequenceNumber() + "\r\n    },\r\n   "
				+ " \"deviceId\": \"+datavariable.getDeviceId()+\",\r\n   "
				+ " \"nickName\": \"+datavariable.getNickName()+\"\r\n  }\r\n}";

		return AccountRequest;
	}

	public static String PatchAccountRequestBody(accounts datavariable) {

		String AccountRequestPatch = "{\n  \"account\": {\n      \"credit\": {\n          \"securityCode\": \"+datavariable.getSecurityCode()+\",\n          \"expiryDate\": {\n              \"month\": \"+datavariable.getExpiryDate_month()+\",\n              \"year\": \"+datavariable.getExpiryDate_year()+\"\n          }\n      }\n  }\n}";

		return AccountRequestPatch;

	}

	public static final String customerfdAccount() throws IOException {

		Random random = new Random();

		int externalId = random.nextInt(1000);

		System.out.println(externalId);

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\r\n  \"customer\" : {\r\n      \"externalId\" : " + externalId + "\r\n  }\r\n})");
		Request request = new Request.Builder()
				.url("https://ucom-customer-services-dev.apps.us-oma1-np2.1dc.com/v1/partners/SONIC/customers")
				.post(body).addHeader("Content-Type", "application/json").addHeader("X-Wallet-Id", "SONIC_WALLET")
				.addHeader("Cache-Control", "no-cache")
				.addHeader("Postman-Token", "6dff378d-9c1f-408e-a274-ce8c11a16eb8").build();

		Response response = client.newCall(request).execute();

		String Customerid = response.body().string().substring(7, 39);

		return Customerid;
	}

}