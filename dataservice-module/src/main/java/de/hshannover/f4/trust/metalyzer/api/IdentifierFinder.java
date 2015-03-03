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
 * Copyright (C) 2013 - 2015 Trust@HsH
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
package de.hshannover.f4.trust.metalyzer.api;

import java.util.Collection;

import de.hshannover.f4.trust.metalyzer.api.exception.MetalyzerAPIException;
import de.hshannover.f4.trust.visitmeta.interfaces.Identifier;

/**
 * IdentifierFinder Interface
 * 
 * Specifies all get / filter methods for Identifiers.
 * 
 * @author Johannes Busch
 * 
 */
public interface IdentifierFinder {

	/**
	 * Returns an unfiltered List of all current identifiers.
	 * 
	 * @return
	 * @throws MetalyzerAPIException
	 */
	public Collection<Identifier> getCurrent();

	/**
	 * Returns an filered list of current identifiers.
	 * 
	 * @param filter
	 *            given identifier filter.
	 * @return
	 * @throws MetalyzerAPIException
	 */
	public Collection<Identifier> getCurrent(StandardIdentifierType filter);

	/**
	 * Returns an unfiltered list of identifies at the given timestamp.
	 * 
	 * @param timestamp
	 * @return
	 * @throws MetalyzerAPIException
	 */
	public Collection<Identifier> get(long timestamp);

	/**
	 * Returns an filtered list of identifies at the given timestamp.
	 * 
	 * @param filter
	 *            given identifier filter.
	 * @param timestamp
	 * @return
	 * @throws MetalyzerAPIException
	 */
	public Collection<Identifier> get(StandardIdentifierType filter,
			long timestamp);

	/**
	 * Returns an unfiltered delta of identifiers.
	 * 
	 * @param from
	 * @param to
	 * @return
	 * @throws MetalyzerAPIException
	 */
	public MetalyzerDelta<Identifier> get(long from, long to);

	/**
	 * Returns an filtered delta of identifiers.
	 * 
	 * @param filter
	 *            given identifier filter.
	 * @param from
	 * @param to
	 * @return
	 * @throws MetalyzerAPIException
	 */
	public MetalyzerDelta<Identifier> get(StandardIdentifierType filter,
			long from, long to);

	/**
	 * Returns the number of all current identifiers.
	 * 
	 * @return
	 */
	public long count();

	/**
	 * Returns the number of all identifiers at the given timestamp.
	 * 
	 * @param timestamp
	 * @return
	 */
	public long count(long timestamp);

	/**
	 * Returns the number of all identifiers in the given delta.
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public long count(long from, long to);
}
