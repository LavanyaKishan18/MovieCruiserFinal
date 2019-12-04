package com.MovieCruiser.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Lavanya_K
 *
 */
public class DateUtil {
	public static Date convertTodate(String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

}
