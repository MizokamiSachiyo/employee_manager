package model.entity;

public class LanguageBean {
//	部署コード
	private int languageCode;

//	部署名
	private String languageName;

//	デフォルトコンストラクタ
	public LanguageBean() {

	}

	/**
	 * @return languageCode
	 */
	public int getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode セットする languageCode
	 */
	public void setLanguageCode(int languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * @return languageName
	 */
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * @param languageName セットする languageName
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
}
