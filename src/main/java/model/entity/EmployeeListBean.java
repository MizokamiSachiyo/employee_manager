package model.entity;

import java.io.Serializable;

public class EmployeeListBean implements Serializable {
	
//	従業員ID
	private int employeeId;
	
//	従業員名(姓)
	private String lName;
	
//	従業員名(名)
	private String fName;
	
//	性別
	private String gender;
	
//	生年月日
	private String birthday;
	
//	電話番号
	private String phoneNumber;
	
//	部署コード
	private String sectionCode;
	
//	言語コード
	private String languageCode;
	
//	入社日
	private String hireDate;
	
//	デフォルトコンストラクタ
	public EmployeeListBean() {
		
	}
	
	/**
	 * @return employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId セットする employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return lName
	 */
	public String getLName() {
		return lName;
	}

	/**
	 * @param lName セットする lName
	 */
	public void setLName(String lName) {
		this.lName = lName;
	}
	
	/**
	 * @return fName
	 */
	public String getFName() {
		return fName;
	}

	/**
	 * @param fName セットする fName
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender セットする gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber セットする phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode セットする sectionCode
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode セットする languageCode
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	/**
	 * @return hireDate
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate セットする hireDate
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

}
