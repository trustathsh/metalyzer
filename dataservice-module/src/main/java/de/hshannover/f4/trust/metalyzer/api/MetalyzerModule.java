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
package de.hshannover.f4.trust.metalyzer.api;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import de.hshannover.f4.trust.metalyzer.semantic.debug.SemanticsMain;
import de.hshannover.f4.trust.metalyzer.semantic.rest.SemanticsDeviceResource;
import de.hshannover.f4.trust.metalyzer.semantic.rest.SemanticsIpAddressResource;
import de.hshannover.f4.trust.metalyzer.semantic.rest.SemanticsMacAddressResource;
import de.hshannover.f4.trust.metalyzer.semantic.rest.SemanticsUserResource;
import de.hshannover.f4.trust.metalyzer.statistic.rest.StatisticRessource;
import de.hshannover.f4.trust.visitmeta.interfaces.DataserviceModule;
import de.hshannover.f4.trust.visitmeta.interfaces.ifmap.ConnectionManager;
import de.hshannover.f4.trust.visitmeta.util.FileUtils;
import de.hshannover.f4.trust.visitmeta.util.OperatingSystemUtils;

public class MetalyzerModule implements DataserviceModule {

	public static final String METALYZER_MODULE_VERSION = "${project.version}";

	private static Logger logger = Logger.getLogger(MetalyzerModule.class);

	private ConnectionManager mManager;

	@Override
	public void setConnectionManager(ConnectionManager manager) {
		mManager = manager;
	}

	@Override
	public boolean init() {
		MetalyzerAPI.setConnectionManager(mManager);

		Map<String, String> env = System.getenv();
		String envRHome = env.get("R_HOME");

		if (envRHome != null) {
			logger.info("R_HOME: " + envRHome);

			String osName = System.getProperty("os.name");

			switch (osName) {
			case OperatingSystemUtils.OS_NAME_WINDOWS:
				FileUtils.appendToLibraryPath(envRHome + File.separator
						+ "library" + File.separator + "rJava" + File.separator
						+ "jri " + File.separator + "x64" + File.separator);
				// R_HOME should be something like 'C:\Program Files\R\R-3.0.2'
				break;
			case OperatingSystemUtils.OS_NAME_LINUX:
				FileUtils.appendToLibraryPath(envRHome + File.separator
						+ "site-library" + File.separator + "rJava"
						+ File.separator + "jri" + File.separator);
				// R_HOME should be '/usr/lib/R'
				break;
			case OperatingSystemUtils.OS_NAME_MAC_OSX:
				FileUtils.appendToLibraryPath(envRHome + File.separator
						+ "library" + File.separator + "rJava" + File.separator
						+ "jri" + File.separator);
				// R_HOME should be '/Library/Frameworks/R.framework/Resources'
				break;
			default:
				break;
			}

			logger.info(getName() + " v" + METALYZER_MODULE_VERSION
					+ " started successfully");

			// startDebug();

			return true;
		} else {
			logger.error("R_HOME is not set, not initializing " + getName()
					+ " v" + METALYZER_MODULE_VERSION);
			return false;
		}
	}

	@Override
	public Set<Class<?>> getRestClasses() {
		Set<Class<?>> result = new HashSet<>();

		result.add(SemanticsDeviceResource.class);
		result.add(SemanticsIpAddressResource.class);
		result.add(SemanticsMacAddressResource.class);
		result.add(SemanticsUserResource.class);

		result.add(StatisticRessource.class);

		return result;
	}

	@Override
	public String getName() {
		return "Metalyzer dataservice module";
	}

	@Override
	public boolean start() {
		return true;
	}

	@SuppressWarnings("unused")
	private void startDebug() {
		logger.info("Starting Metalyzer Debug...");
		SemanticsMain semanticsMain = new SemanticsMain();
		Thread semanticsMainThread = new Thread(semanticsMain,
				"Semantics Debug Thread");
		semanticsMainThread.start();
		logger.info("Metalyzer Debug started successfully.");
	}
}
