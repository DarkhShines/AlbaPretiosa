package fr.albapretiosa.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.jasper.TrimSpacesOption;

import AppException.ExceptionAlain;

public class UtilAlain {
	static String errorLocation = "/WEB-INF/Error.jsp";
	
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
	
	public static String getErrorLocation() {
		return errorLocation;
	}
	public static String isEmpty(String string) throws ExceptionAlain {
			if(string.trim().length() > 0) {
				System.out.println("Test emptyOK");
			} else {
				throw new ExceptionAlain("Ce champ est vide");
			}
		 
		
		return string;
	}
}
