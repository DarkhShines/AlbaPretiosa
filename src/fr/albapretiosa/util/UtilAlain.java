package fr.albapretiosa.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UtilAlain {
	
	/*  DATE FORMAT EN FRANCAIS  */
	public static String formatDateFr(LocalDate date) {
		String dateEnFr;
		try {
			dateEnFr = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.FRENCH));
		} catch (NullPointerException npe) {
			dateEnFr = "Date is null";
		}
		return dateEnFr;
	}
}
