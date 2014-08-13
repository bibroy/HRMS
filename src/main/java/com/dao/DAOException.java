/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

/**
 *
 * @author dolad
 */
public class DAOException extends Exception {

	/**
	 *
	 */
	public DAOException() {
		super();
	}

	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public DAOException(Throwable cause) {
		super(cause);
	}

}
