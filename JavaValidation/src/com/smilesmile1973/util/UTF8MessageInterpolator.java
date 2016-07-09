package com.smilesmile1973.util;

import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.MessageInterpolator;

import org.apache.commons.lang.ArrayUtils;

/**
 * Message Interpolator for UTF8.
 * 
 * @author Gérald Maréchal
 * @Since 22/05/2016
 *
 */
public class UTF8MessageInterpolator implements MessageInterpolator {

	/**
	 * RegEx to determine the string to replace.
	 */
	private static final Pattern MESSAGE_PARAMETER_PATTERN = Pattern.compile("(\\{[^\\}]+?\\})");

	/**
	 * @see ResourceBundle
	 */
	private final ResourceBundle resourceBundle;

	/**
	 * Constructor
	 */
	public UTF8MessageInterpolator() {
		resourceBundle = UTF8ResourcesBundle.UTF8ValidatorMessages.getResourceBundle();
	}

	/**
	 * @return the resourceBundle
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.MessageInterpolator#interpolate(java.lang.String,
	 * javax.validation.MessageInterpolator.Context)
	 */
	@Override
	public String interpolate(String message, Context context) {
		return interpolateMessage(message, context.getConstraintDescriptor().getAttributes(), Locale.getDefault());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.MessageInterpolator#interpolate(java.lang.String,
	 *      javax.validation.MessageInterpolator.Context, java.util.Locale)
	 */
	@Override
	public String interpolate(String message, Context context, Locale locale) {
		return interpolateMessage(message, context.getConstraintDescriptor().getAttributes(), locale);
	}

	private String interpolateMessage(String message, Map<String, Object> annotationParameters, Locale locale) {
		String userBundleResolvedMessage;
		final String resolvedMessage = message;
		userBundleResolvedMessage = replaceVariables(resolvedMessage, resourceBundle, locale, true);
		userBundleResolvedMessage = replaceAnnotationAttributes(userBundleResolvedMessage, annotationParameters);
		return userBundleResolvedMessage;
	}

	private String removeCurlyBrace(String parameter) {
		return parameter.substring(1, parameter.length() - 1);
	}

	private String replaceAnnotationAttributes(String message, Map<String, Object> annotationParameters) {
		final Matcher matcher = MESSAGE_PARAMETER_PATTERN.matcher(message);
		final StringBuffer stringBuilder = new StringBuffer(64);
		while (matcher.find()) {
			String resolvedParameterValue;
			final String parameter = matcher.group(1);
			final Object variable = annotationParameters.get(removeCurlyBrace(parameter));
			if (variable == null) {
				resolvedParameterValue = parameter;
			} else {
				if (variable.getClass().isArray()) {
					resolvedParameterValue = ArrayUtils.toString(variable);
				} else {
					resolvedParameterValue = variable.toString();
				}
			}
			matcher.appendReplacement(stringBuilder, sanitizeForAppendReplacement(resolvedParameterValue));
		}
		matcher.appendTail(stringBuilder);
		return stringBuilder.toString();
	}

	private String replaceVariables(String message, ResourceBundle bundle, Locale locale, boolean recurse) {
		final Matcher matcher = MESSAGE_PARAMETER_PATTERN.matcher(message);
		final StringBuffer stringBuffer = new StringBuffer();
		String resolvedParameterValue;
		while (matcher.find()) {
			final String parameter = matcher.group(1);
			resolvedParameterValue = resolveParameter(parameter, bundle, locale, recurse);
			matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(resolvedParameterValue));
		}
		matcher.appendTail(stringBuffer);
		return stringBuffer.toString();
	}

	private String resolveParameter(String parameterName, ResourceBundle bundle, Locale locale, boolean recurse) {
		String parameterValue;
		try {
			if (bundle == null) {
				parameterValue = parameterName;
			} else {
				parameterValue = bundle.getString(removeCurlyBrace(parameterName));
				if (recurse) {
					parameterValue = replaceVariables(parameterValue, bundle, locale, recurse);
				}
			}
		} catch (MissingResourceException e) {
			parameterValue = parameterName;
		}
		return parameterValue;
	}

	/**
	 * Escapes the string to comply with
	 * {@link Matcher#appendReplacement(StringBuffer, String)} requirements.
	 *
	 * @param src
	 *            The original string.
	 * @return The sanitized string.
	 */
	private String sanitizeForAppendReplacement(String src) {
		return src.replace("\\", "\\\\").replace("$", "\\$");
	}
}