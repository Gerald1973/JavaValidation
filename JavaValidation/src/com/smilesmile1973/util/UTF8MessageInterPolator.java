package com.smilesmile1973.util;

import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.MessageInterpolator;

/**
 * Message Interpolator for UTF8.
 * @author Gérald Maréchal
 * @Since 22/05/2016
 *
 */
public class UTF8MessageInterPolator implements MessageInterpolator {
	
	private ResourceBundle resourceBundle = UTF8ResourcesBundle.UTF8ValidatorMessages.getResourceBundle();

	public UTF8MessageInterPolator() {
		super();
	}

	private static final Pattern MESSAGE_PARAMETER_PATTERN = Pattern.compile("(\\{[^\\}]+?\\})");

	/* (non-Javadoc)
	 * @see javax.validation.MessageInterpolator#interpolate(java.lang.String, javax.validation.MessageInterpolator.Context)
	 */
	@Override
	public String interpolate(String message, Context context) {
		return interpolateMessage(message, context.getConstraintDescriptor().getAttributes(), Locale.getDefault());
	}

	/* (non-Javadoc)
	 * @see javax.validation.MessageInterpolator#interpolate(java.lang.String, javax.validation.MessageInterpolator.Context, java.util.Locale)
	 */
	@Override
	public String interpolate(String message, Context context, Locale locale) {
		return interpolateMessage(message, context.getConstraintDescriptor().getAttributes(), locale);
	}

	private String interpolateMessage(String message, Map<String, Object> annotationParameters, Locale locale) {
		String userBundleResolvedMessage;
		String resolvedMessage = message;
		userBundleResolvedMessage = replaceVariables(resolvedMessage, resourceBundle, locale, true);
		return userBundleResolvedMessage;
	}

	private String replaceVariables(String message, ResourceBundle bundle, Locale locale, boolean recurse) {
		Matcher matcher = MESSAGE_PARAMETER_PATTERN.matcher(message);
		StringBuffer sb = new StringBuffer();
		String resolvedParameterValue;
		while (matcher.find()) {
			String parameter = matcher.group(1);
			resolvedParameterValue = resolveParameter(parameter, bundle, locale, recurse);
			matcher.appendReplacement(sb, Matcher.quoteReplacement(resolvedParameterValue));
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	private String resolveParameter(String parameterName, ResourceBundle bundle, Locale locale, boolean recurse) {
		String parameterValue;
		try {
			if (bundle != null) {
				parameterValue = bundle.getString(removeCurlyBrace(parameterName));
				if (recurse) {
					parameterValue = replaceVariables(parameterValue, bundle, locale, recurse);
				}
			} else {
				parameterValue = parameterName;
			}
		} catch (MissingResourceException e) {
			// return parameter itself
			parameterValue = parameterName;
		}
		return parameterValue;
	}

	private String removeCurlyBrace(String parameter) {
		return parameter.substring(1, parameter.length() - 1);
	}
}
