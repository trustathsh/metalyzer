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
 * This file is part of metalyzer-dataservice-module, version 0.1.0,
 * implemented by the Trust@HsH research group at the Hochschule Hannover.
 * %%
 * Copyright (C) 2012 - 2014 Trust@HsH
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

import java.util.HashSet;
import java.util.List;

import de.hshannover.f4.trust.visitmeta.interfaces.Identifier;
import de.hshannover.f4.trust.visitmeta.interfaces.Link;
import de.hshannover.f4.trust.visitmeta.interfaces.Metadata;

/**
 * Abstract super class for a Metadata filter.
 * 
 * @author Johannes Busch
 * 
 */
public abstract class MetadataFilter extends GenericElementFilter<Metadata> {

	protected HashSet<String> meta;
	protected HashSet<String> idents;

	/**
	 * Initialiases a new filter with the given identifier and metadata filters.
	 * 
	 * @param idents
	 * @param meta
	 */
	public MetadataFilter(HashSet<String> meta, HashSet<String> idents) {
		this.meta = meta;
		this.idents = idents;
	}

	/**
	 * Filters the given identifier list against the internal filters.
	 */
	@Override
	public void filter(List<Identifier> idents) {
		for (Identifier i : idents) {
			if (this.idents.contains(i.getTypeName())) {

				filterMetadata(i.getMetadata());

				for (Link l : i.getLinks()) {
					filterMetadata(l.getMetadata());
				}
			}
		}
	}

	/**
	 * Filters the metadata.
	 * 
	 * @param metadata
	 */
	protected abstract void filterMetadata(List<Metadata> metadata);

}
