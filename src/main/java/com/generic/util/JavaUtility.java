package com.generic.util;

import java.util.Date;

public class JavaUtility {

	public String getSystemDateInFormate() {
		Date d = new Date();
		String[] split = d.toString().split(" ");
		String date = split[2];
		String month = split[1];
		String year = split[5];
		String time = split[3].replace(":", "-");
		return date + " " + month + " " + year + " " + time;
	}

}
