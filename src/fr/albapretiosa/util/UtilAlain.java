package fr.albapretiosa.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
	
	/**
	 * Récuperer une date dans ResultSet
	 * @param rs
	 * @param nomColonne
	 * @return
	 * @throws SQLException
	 */
	public static LocalDate getDateFromRs(ResultSet rs, String nomColonne) throws SQLException {
		Calendar cal 		  = Calendar.getInstance(Locale.FRANCE);
		java.sql.Date date    = rs.getDate(nomColonne,cal);
		LocalDate ldate = ((date != null)? date.toLocalDate() : null);
		return ldate;
	}

	/**
	 * positionne une LocalDate dans un preparedStatement
	 * @param pstmt
	 * @param position
	 * @param date
	 * @throws SQLException
	 */
	public static void setDateToPreparedStatement(PreparedStatement pstmt, int position, LocalDate date) throws SQLException {
		pstmt.setDate(position,((date == null) ? null : java.sql.Date.valueOf(date)),java.util.Calendar.getInstance());	
	}

}
