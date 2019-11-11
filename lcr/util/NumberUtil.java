package com.mes.lcr.util;

import java.text.DecimalFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberUtil {
	private static final Logger LOG = LoggerFactory.getLogger(NumberUtil.class);

	private NumberUtil() {
		throw new IllegalStateException("Utility class"); //$NON-NLS-1$
	}

	public static String getPaddedLong(long value, int size) {
		String retVal = "ERROR";
		StringBuffer digitFormat = new StringBuffer("");
		try {
			for (int i = 0; i < size; ++i) {
				digitFormat.append("0");
			}
			DecimalFormat df = new DecimalFormat(digitFormat.toString());
			retVal = df.format(value);
		}
		catch (Exception e) {
			LOG.error("Error in getPaddedLong() ", e);
		}
		return retVal;
	}

	public static int calcMod10CheckDigit(String data) {
		int retVal = 0;
		int sum = 0;

		boolean dbl = true;

		for (int i = (data.length() - 1); i >= 0; --i) {
			int digit = Character.digit(data.charAt(i), 10);
			if (dbl) {
				digit = ((digit * 2) % 10) + ((digit * 2) / 10);
			}
			sum += digit;
			dbl = !dbl;
		}
		retVal = ((10 - (sum % 10)) % 10);
		return (retVal);
	}
}
