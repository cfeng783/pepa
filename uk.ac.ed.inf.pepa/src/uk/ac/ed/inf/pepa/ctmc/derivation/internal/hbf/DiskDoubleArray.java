/*******************************************************************************
 * Copyright (c) 2006, 2009 University of Edinburgh.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BSD Licence, which
 * accompanies this feature and can be downloaded from
 * http://groups.inf.ed.ac.uk/pepa/update/licence.txt
 *******************************************************************************/
package uk.ac.ed.inf.pepa.ctmc.derivation.internal.hbf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DiskDoubleArray {
	
	private RandomAccessFile file;
	
	private int size;
	
	private static final int BYTE_SIZE = 3;
	
	public DiskDoubleArray(String file) throws IOException {
		
		this.file = new RandomAccessFile(file, "r");
		long longSize = this.file.length() >> BYTE_SIZE; 
		if (longSize > Integer.MAX_VALUE)
			throw new IllegalStateException("File too long");
		this.size = (int) longSize;
	}
	
	public double get(int index) throws IOException {
		file.seek(index << BYTE_SIZE);
		return file.readDouble();
	}
	
	/**
	 * Copies the contents of this array into the destination.
	 * For performance reasons, it doesn't do any bound checking.
	 * @param from
	 * @param to
	 * @param dest
	 */
	public void getBulk(int from, int to, double[] dest) throws IOException {
		file.seek(from << BYTE_SIZE);
		int range = to-from;
		for (int i = 0; i <range; i++) {
			dest[i] = file.readDouble();
		}
	}
	
	public int size() {
		return size;
	}
}
