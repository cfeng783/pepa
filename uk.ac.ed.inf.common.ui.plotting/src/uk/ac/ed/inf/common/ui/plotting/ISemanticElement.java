/*******************************************************************************
 * Copyright (c) 2006, 2009 University of Edinburgh.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BSD Licence, which
 * accompanies this feature and can be downloaded from
 * http://groups.inf.ed.ac.uk/pepa/update/licence.txt
 *******************************************************************************/
package uk.ac.ed.inf.common.ui.plotting;

import org.eclipse.core.runtime.IAdaptable;

/**
 * An element which is represented by some graph.
 * It extends {@link IAdaptable} interface for ease of
 * interaction with the Eclipse environment. 
 * 
 * @author mtribast
 *
 */
public interface ISemanticElement extends IAdaptable {
	
	public static final String CSV_FORMAT = "CSV";
	
	public static final String SBSI_FORMAT = "SBSI";
	
	/**
	 * A human-readable description of the element.
	 * @return
	 */
	public String getDescription(String format);
}
