package com.smilesmile1973.util;

import java.util.ResourceBundle;

public enum UTF8ResourcesBundle {
	UTF8ValidatorMessages("com.smilesmile1973.ValidationMessages");

	private ResourceBundle resourceBundle;

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public String getString(String key) {
		String result = resourceBundle.getString(key);
		if (result == null){
			result = key;
		}
		return result;
	}

	private UTF8ResourcesBundle(String baseName) {
		resourceBundle = ResourceBundle.getBundle(baseName,new UTF8Control());
	}
}
