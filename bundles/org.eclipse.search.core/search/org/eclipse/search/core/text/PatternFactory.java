/*******************************************************************************
 * Copyright (c) 2023 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.search.core.text;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.search.internal.core.text.PatternConstructor;

/**
 * Factory methods to create patterns to use in search.
 * 
 * @since 3.16
 */
public class PatternFactory {

	public static Pattern createPattern(String pattern, boolean isCaseSensitive, boolean isRegex)
			throws PatternSyntaxException {
		return PatternConstructor.createPattern(pattern, isCaseSensitive, isRegex);
	}

	/**
	 * Creates a pattern element from the pattern string which is either a
	 * reg-ex expression or in our old 'StringMatcher' format.
	 *
	 * @param pattern
	 *            The search pattern
	 * @param isRegex
	 *            <code>true</code> if the passed string already is a reg-ex
	 *            pattern
	 * @param isStringMatcher
	 *            <code>true</code> if the passed string is in the StringMatcher
	 *            format.
	 * @param isCaseSensitive
	 *            Set to <code>true</code> to create a case insensitive pattern
	 * @param isWholeWord
	 *            <code>true</code> to create a pattern that requires a word
	 *            boundary at the beginning and the end.
	 * @return The created pattern
	 * @throws PatternSyntaxException
	 *             if "\R" is at an illegal position
	 */
	public static Pattern createPattern(String pattern, boolean isRegex, boolean isStringMatcher,
			boolean isCaseSensitive, boolean isWholeWord) throws PatternSyntaxException {
		return PatternConstructor.createPattern(pattern, isRegex, isStringMatcher, isCaseSensitive, isWholeWord);
	}


	/**
	 * Creates a pattern element from an array of patterns in the old
	 * 'StringMatcher' format.
	 *
	 * @param patterns
	 *            The search patterns
	 * @param isCaseSensitive
	 *            Set to <code>true</code> to create a case insensitive pattern
	 * @return The created pattern
	 * @throws PatternSyntaxException
	 *             if "\R" is at an illegal position
	 */
	public static Pattern createPattern(String[] patterns, boolean isCaseSensitive) throws PatternSyntaxException {
		return PatternConstructor.createPattern(patterns, isCaseSensitive);
	}
}
