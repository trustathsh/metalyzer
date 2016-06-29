/*
 * #%L
 * =====================================================
 *   _____                _     ____  _   _       _   _
 *  |_   _|_ __ _   _ ___| |_  / __ \| | | | ___ | | | |
 *    | | | '__| | | / __| __|/ / _` | |_| |/ __|| |_| |
 *    | | | |  | |_| \__ \ |_| | (_| |  _  |\__ \|  _  |
 *    |_| |_|   \__,_|___/\__|\ \__,_|_| |_||___/|_| |_|
 *                             \____/
 * 
 * =====================================================
 * 
 * Hochschule Hannover
 * (University of Applied Sciences and Arts, Hannover)
 * Faculty IV, Dept. of Computer Science
 * Ricklinger Stadtweg 118, 30459 Hannover, Germany
 * 
 * Email: trust@f4-i.fh-hannover.de
 * Website: http://trust.f4.hs-hannover.de/
 * 
 * This file is part of metalyzer-dataservice-module, version 0.1.1,
 * implemented by the Trust@HsH research group at the Hochschule Hannover.
 * %%
 * Copyright (C) 2013 - 2016 Trust@HsH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package de.hshannover.f4.trust.metalyzer.api.finder.util;

import java.util.ArrayList;
import java.util.List;

import de.hshannover.f4.trust.visitmeta.interfaces.Identifier;
import de.hshannover.f4.trust.visitmeta.interfaces.IdentifierGraph;

/**
 * Abstract super class which defines filter methods for the elements filters.
 * 
 * @author Johannes Busch
 */
public abstract class GenericElementFilter<T> {
	List<T> elements = new ArrayList<T>();

	/**
	 * Filters the given list. Filtering is defined by class type.
	 * 
	 * @param idents
	 */
	public abstract void filter(List<Identifier> idents);

	/**
	 * Filters the given list of Graphs. Filtering is defined by class type.
	 * 
	 * @param graphs
	 */
	public void filterGraphs(List<IdentifierGraph> graphs) {
		for (IdentifierGraph g : graphs) {
			filter(g.getIdentifiers());
		}
	}

	/**
	 * Returns the filtered list.
	 * 
	 * @return
	 */
	public List<T> getList() {
		return elements;
	}

	/**
	 * Returns a copy of the filtered list and erases the internal list. This
	 * filter can be used several times without creating new filter objects.
	 * 
	 * @return
	 */
	public List<T> getListAndRefresh() {
		List<T> idents = new ArrayList<T>(elements);

		elements = new ArrayList<T>();

		return idents;
	}
}
