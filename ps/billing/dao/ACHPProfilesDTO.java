package com.mes.ps.billing.dao;

/**
 * ACHPProfilesDTO Bean
 */
public class ACHPProfilesDTO {
	private String profileId;
	private String merchNum;
	private String merchName;
	private String companyName;
	private String transitNum;
	private String accountNum;
	private String accountNumEnc;
	private String accountType;
	private String sfSecCode;
	private Long ftId;
	private String ccdEnableFlag;
	private String ppdEnableFlag;
	private String webEnableFlag;
	private String telEnableFlag;
	private Integer ccdPendDays;
	private Integer ppdPendDays;
	private Integer webPendDays;
	private Integer telPendDays;
	private String holdFlag;
	private Integer batchNum;
	private Integer testBatchNum;
	private String statusCode;
	private String emailAddr;
	private String achHost;
	private String userName;
	private String passWord;
	private String entityId;
	private String locationId;
	private String businessDbaName;
	private String bankAccounts;

	public ACHPProfilesDTO() {
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getMerchNum() {
		return merchNum;
	}

	public void setMerchNum(String merchNum) {
		this.merchNum = merchNum;
	}

	public String getMerchName() {
		return merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTransitNum() {
		return transitNum;
	}

	public void setTransitNum(String transitNum) {
		this.transitNum = transitNum;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountNumEnc() {
		return accountNumEnc;
	}

	public void setAccountNumEnc(String accountNumEnc) {
		this.accountNumEnc = accountNumEnc;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getSfSecCode() {
		return sfSecCode;
	}

	public void setSfSecCode(String sfSecCode) {
		this.sfSecCode = sfSecCode;
	}

	public Long getFtId() {
		return ftId;
	}

	public void setFtId(Long ftId) {
		this.ftId = ftId;
	}

	public String getCcdEnableFlag() {
		return ccdEnableFlag;
	}

	public void setCcdEnableFlag(String ccdEnableFlag) {
		this.ccdEnableFlag = ccdEnableFlag;
	}

	public String getPpdEnableFlag() {
		return ppdEnableFlag;
	}

	public void setPpdEnableFlag(String ppdEnableFlag) {
		this.ppdEnableFlag = ppdEnableFlag;
	}

	public String getWebEnableFlag() {
		return webEnableFlag;
	}

	public void setWebEnableFlag(String webEnableFlag) {
		this.webEnableFlag = webEnableFlag;
	}

	public String getTelEnableFlag() {
		return telEnableFlag;
	}

	public void setTelEnableFlag(String telEnableFlag) {
		this.telEnableFlag = telEnableFlag;
	}

	public Integer getCcdPendDays() {
		return ccdPendDays;
	}

	public void setCcdPendDays(Integer ccdPendDays) {
		this.ccdPendDays = ccdPendDays;
	}

	public Integer getPpdPendDays() {
		return ppdPendDays;
	}

	public void setPpdPendDays(Integer ppdPendDays) {
		this.ppdPendDays = ppdPendDays;
	}

	public Integer getWebPendDays() {
		return webPendDays;
	}

	public void setWebPendDays(Integer webPendDays) {
		this.webPendDays = webPendDays;
	}

	public Integer getTelPendDays() {
		return telPendDays;
	}

	public void setTelPendDays(Integer telPendDays) {
		this.telPendDays = telPendDays;
	}

	public String getHoldFlag() {
		return holdFlag;
	}

	public void setHoldFlag(String holdFlag) {
		this.holdFlag = holdFlag;
	}

	public Integer getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(Integer batchNum) {
		this.batchNum = batchNum;
	}

	public Integer getTestBatchNum() {
		return testBatchNum;
	}

	public void setTestBatchNum(Integer testBatchNum) {
		this.testBatchNum = testBatchNum;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	public String getAchHost() {
		return achHost;
	}

	public void setAchHost(String achHost) {
		this.achHost = achHost;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getBusinessDbaName() {
		return businessDbaName;
	}

	public void setBusinessDbaName(String businessDbaName) {
		this.businessDbaName = businessDbaName;
	}

	public String getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(String bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profileId == null) ? 0 : profileId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ACHPProfilesDTO other = (ACHPProfilesDTO) obj;
		if (profileId == null) {
			if (other.profileId != null)
				return false;
		} else if (!profileId.equals(other.profileId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ACHPProfilesDTO [profileId=" + profileId + ", merchNum=" + merchNum + ", merchName=" + merchName
				+ ", companyName=" + companyName + ", transitNum=" + "xxxx" + ", accountNum=" + "xxxx"
				+ ", accountNumEnc=" + accountNumEnc + ", accountType=" + accountType + ", sfSecCode=" + sfSecCode
				+ ", ftId=" + ftId + ", ccdEnableFlag=" + ccdEnableFlag + ", ppdEnableFlag=" + ppdEnableFlag
				+ ", webEnableFlag=" + webEnableFlag + ", telEnableFlag=" + telEnableFlag + ", ccdPendDays="
				+ ccdPendDays + ", ppdPendDays=" + ppdPendDays + ", webPendDays=" + webPendDays + ", telPendDays="
				+ telPendDays + ", holdFlag=" + holdFlag + ", batchNum=" + batchNum + ", testBatchNum=" + testBatchNum
				+ ", statusCode=" + statusCode + ", emailAddr=" + "xxxx" + ", achHost=" + achHost + ", userName="
				+ "xxxx" + ", passWord=" + "xxxx" + ", entityId=" + "xxxx" + ", locationId=" + "xxxx"
				+ ", businessDbaName=" + businessDbaName + ", bankAccounts=" + bankAccounts + "]";
	}
}
