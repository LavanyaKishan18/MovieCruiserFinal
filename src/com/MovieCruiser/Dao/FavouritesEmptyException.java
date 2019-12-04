package com.MovieCruiser.Dao;

/**
 * @author Lavanya_K
 *
 */

public class FavouritesEmptyException extends Exception {
	private String message;

	public FavouritesEmptyException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
