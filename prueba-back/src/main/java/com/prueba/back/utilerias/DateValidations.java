package com.prueba.back.utilerias;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidations {
	private SimpleDateFormat simpleDateFormat;

	public boolean isValidDate(String inDate) {

		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:ms");
		simpleDateFormat.setLenient(false);

		try {
			simpleDateFormat.parse(inDate.trim());

		} catch (ParseException pe) {
			System.out.println("parseException");
			return false;

		} catch (NullPointerException pe) {
			System.out.println("null");
			return false;
		}
		System.out.println("true validation");

		return true;

	}

}
