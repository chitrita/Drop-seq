/*
 * MIT License
 *
 * Copyright 2017 Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.broadinstitute.dropseqrna.beadsynthesis;

import java.util.*;



public class BarcodeNeighborGroup {

	private Set<BeadSynthesisErrorData> neighbors;
	private final String rootSequence;
	private String intendedSequence;

	public BarcodeNeighborGroup(final String rootSequence) {
		this.rootSequence=rootSequence;
		this.neighbors=new HashSet<>();
	}

	public void addNeighbor (final BeadSynthesisErrorData neighbor) {
		this.neighbors.add(neighbor);
	}

	public List<String> getNeighborCellBarcodes () {
		List<String> result = new ArrayList<>();
		for (BeadSynthesisErrorData bsed: neighbors)
			result.add(bsed.getCellBarcode());
		Collections.sort(result);
		return result;
	}

	@Override
	public String toString () {
		StringBuilder b = new StringBuilder();
		b.append("Neighbors " + getNeighborCellBarcodes().toString() +"");
		return (b.toString());
	}

	public String getRootSequence() {
		return rootSequence;
	}

	public String getIntendedSequence() {
		return intendedSequence;
	}

	public void setIntendedSequence(final String intendedSequence) {
		this.intendedSequence = intendedSequence;
	}


}
