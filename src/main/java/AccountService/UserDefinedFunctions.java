package AccountService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Properties;

import org.slf4j.*;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.slf4j.Logger;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Verify Functions class has all the reusable functions required
 */

public class UserDefinedFunctions {

	public Properties properties = null;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDefinedFunctions.class);

	public static final Response customerfdAccount() {
		Response UseCustomerid = null;
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\r\n  \"customer\" : {\r\n      \"externalId\" : "
				+ java.util.UUID.randomUUID().toString() + "\r\n  }\r\n}\r\n\r\n\r\n\r\n\r\n");
		Request request = new Request.Builder()
				.url("https://ucom-customer-services-dev.apps.us-oma1-np2.1dc.com/v1/partners/SONIC/customers")
				.post(body).addHeader("Content-Type", "application/json").addHeader("Timestamp", "{{time}}")
				.addHeader("X-Wallet-Id", "SONIC_WALLET").addHeader("Cache-Control", "no-cache")
				.addHeader("Postman-Token", "7c5138a9-1eee-4ff7-a886-36e4abb8238f").build();

		try {
			// Response response = client.newCall(request).execute();
			Response SaveCustomerid = client.newCall(request).execute();
			UseCustomerid = SaveCustomerid;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UseCustomerid;

	}
/*
	public String apiAuthorization(String Ratelimit) {
		String apiAuthorization = "";
		try {
			properties = configProperties();
			apiAuthorization = properties.getProperty("apiAuthorization" + Ratelimit);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return apiAuthorization;
	}*/

/*	public Properties configProperties() {
		Properties properties = new Properties();
		InputStream input = null;

		try {
			String env = System.getProperty("env");
			input = new FileInputStream("src/test/resources/environment/" + env + "/config.properties");
			// load a properties file
			properties.load(input);

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
				}
			}
		}
		return properties;
	}*/

}