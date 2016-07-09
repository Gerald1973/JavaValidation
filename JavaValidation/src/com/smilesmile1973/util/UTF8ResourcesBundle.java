package com.smilesmile1973.util;

import java.util.ResourceBundle;

/**
 * UTF-8 resource bundle singleton
 * 
 * @author Gérald Maréchal
 *
 */
public enum UTF8ResourcesBundle {
	UTF8ValidatorMessages("com.smilesmile1973.ValidationMessages");

	/**
	 * @see ResourceBundle
	 */
	private ResourceBundle resourceBundle;

	/**
	 * Constructor
	 * 
	 * @param baseName
	 */
	private UTF8ResourcesBundle(String baseName) {
		resourceBundle = ResourceBundle.getBundle(baseName, new UTF8Control());
	}

	/**
	 * @return the resourceBundle
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * This method returns the property associated to the parameter key. If the
	 * property is not found, then returns the key.
	 * 
	 * @param key
	 *            the key of the property
	 * @return the property associated to the parameter key. If the property is
	 *         not found, then returns the key.
	 */
	public String getString(String key) {
		String result = resourceBundle.getString(key);
		if (result == null) {
			result = key;
		}
		return result;
	}
}
