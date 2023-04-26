/**
 * 
 */
package com.parasoft.parabank.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Parasoft Jtest UTA: Test class for Accounts
 *
 * @see com.parasoft.parabank.util.Accounts
 * @author pteodor
 */
public class AccountsTest {

	/**
	 * Parasoft Jtest UTA: Test for toString()
	 *
	 * @see com.parasoft.parabank.util.Accounts#toString()
	 * @author pteodor
	 */
	@Test
	public void testToString() throws Throwable {
		// Given
		Accounts underTest = new Accounts();

		// When
		String result = underTest.toString();

		// Then
		// assertEquals("", result);
	}
}