package model.entity;

import java.io.Serializable;

public class LanguageBean implements Serializable {
//	言語コード
	private String languageCode;

//	言語名
	private String languageName;

//	デフォルトコンストラクタ
	public LanguageBean() {

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
