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
 * This file is part of metalyzer-common, version 0.1.0,
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
package de.hshannover.f4.trust.metalyzer;

/**
 * Just an enum of all used Property-Key-Strings.
 *
 * @author Johannes Busch
 *
 */
public enum PropertyStrings {
	// Identifier Property Strings
	AR_NAME("/access-request[@name]"),

	DEVICE_NAME("/device/name"),

	IP_VALUE("/ip-address[@value]"),
	IP_TYPE("/ip-address[@type]"),

	MAC_VALUE("/mac-address[@value]"),

	IDENT_NAME("/identity[@name]"),
	IDENT_TYPE("/identity[@type]"),
	//---------------------------------------------------------------------------

	// Metadata Property Strings
	CAP_NAME("/meta:capability/name"),

	ROLE_NAME("/meta:role/name"),

	DEV_ATTR("/meta:device-attribute/name"),

	LAY2_PORT("/meta:layer2-information/port"),
	LAY2_VLAN("/meta:layer2-information/vlan"),
	LAY2_VLAN_NAME("/meta:layer2-information/vlan-name");
	//----------------------------------------------------------------------

	private String desc;

	private PropertyStrings(String desc) {
		this.desc = desc;
	}

	public String get() {
		return desc;
	}
}
