package AccountService;

// perhaps we are making some changes
public class accounts {

	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAcc_status() {
		return acc_status;
	}

	public void setAcc_status(String acc_status) {
		this.acc_status = acc_status;
	}

	public String getCc_cardNumber() {
		return cc_cardNumber;
	}

	public void setCc_cardNumber(String cc_cardNumber) {
		this.cc_cardNumber = cc_cardNumber;
	}

	public String getCc_nameOnCard() {
		return cc_nameOnCard;
	}

	public void setCc_nameOnCard(String cc_nameOnCard) {
		this.cc_nameOnCard = cc_nameOnCard;
	}

	public String getCc_cardType() {
		return cc_cardType;
	}

	public void setCc_cardType(String cc_cardType) {
		this.cc_cardType = cc_cardType;
	}

	public String getBa_type() {
		return ba_type;
	}

	public void setBa_type(String ba_type) {
		this.ba_type = ba_type;
	}

	public String getBa_streetAddress() {
		return ba_streetAddress;
	}

	public void setBa_streetAddress(String ba_streetAddress) {
		this.ba_streetAddress = ba_streetAddress;
	}

	public String getBa_locality() {
		return ba_locality;
	}

	public void setBa_locality(String ba_locality) {
		this.ba_locality = ba_locality;
	}

	public String getBa_region() {
		return ba_region;
	}

	public void setBa_region(String ba_region) {
		this.ba_region = ba_region;
	}

	public String getBa_postalCode() {
		return ba_postalCode;
	}

	public void setBa_postalCode(String ba_postalCode) {
		this.ba_postalCode = ba_postalCode;
	}

	public String getBa_country() {
		return ba_country;
	}

	public void setBa_country(String ba_country) {
		this.ba_country = ba_country;
	}

	public String getBa_formatted() {
		return ba_formatted;
	}

	public void setBa_formatted(String ba_formatted) {
		this.ba_formatted = ba_formatted;
	}

	public String getBa_primary() {
		return ba_primary;
	}

	public void setBa_primary(String ba_primary) {
		this.ba_primary = ba_primary;
	}

	public String getExpiryDate_month() {
		return expiryDate_month;
	}

	public void setExpiryDate_month(String expiryDate_month) {
		this.expiryDate_month = expiryDate_month;
	}

	public String getExpiryDate_year() {
		return expiryDate_year;
	}

	public void setExpiryDate_year(String expiryDate_year) {
		this.expiryDate_year = expiryDate_year;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	private String scenarioName;
	private String acc_type;
	private String acc_status;
	private String cc_cardNumber;
	private String cc_nameOnCard;
	private String cc_cardType;
	private String ba_type;
	private String ba_streetAddress;
	private String ba_locality;
	private String ba_region;
	private String ba_postalCode;
	private String ba_country;
	private String ba_formatted;
	private String ba_primary;
	private String expiryDate_month;
	private String expiryDate_year;
	private String securityCode;
	private String sequenceNumber;
	private String deviceId;
	private String nickName;
	private String X_Wallet_Id;
	private String Cache_control;
	private String Postman_Token;
	private int responseCode;
	private String responseMessage;

	public String getX_Wallet_Id() {
		return X_Wallet_Id;
	}

	public void setX_Wallet_Id(String x_Wallet_Id) {
		X_Wallet_Id = x_Wallet_Id;
	}

	public String getCache_control() {
		return Cache_control;
	}

	public void setCache_control(String cache_control) {
		Cache_control = cache_control;
	}

	public String getPostman_Token() {
		return Postman_Token;
	}

	public void setPostman_Token(String postman_Token) {
		Postman_Token = postman_Token;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {

		return "scenarioName= " + scenarioName + ", acc_type=" + acc_type + ",acc_status = " + acc_status + ""
				+ "cc_cardNumber=" + cc_cardNumber + ",cc_nameOnCard =" + cc_nameOnCard + ",cc_cardType =" + cc_cardType
				+ ", ba_type=" + ba_type + ",ba_streetAddress=" + ba_streetAddress + ",ba_locality=" + ba_locality
				+ ",ba_region=" + ba_region + "" + " ba_postalCode=" + ba_postalCode + ",ba_country=" + ba_country
				+ ", ba_formatted=" + ba_formatted + "" + "ba_primary=" + ba_primary + ",expiryDate_month="
				+ expiryDate_month + ", expiryDate_year=" + expiryDate_year + "" + "securityCode=" + securityCode
				+ ",sequenceNumber=" + sequenceNumber + ",deviceId=" + deviceId + ",nickName= " + nickName
				+ ", responseCode = " + responseCode + ",responseMessage=" + responseMessage + ", X_Wallet_Id ="
				+ X_Wallet_Id + ",Cache_control = " + Cache_control + ", " + " Postman_Token = " + Postman_Token + " ";

	}
}