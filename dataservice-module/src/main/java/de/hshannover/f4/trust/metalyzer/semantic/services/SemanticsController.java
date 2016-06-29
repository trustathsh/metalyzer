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
package de.hshannover.f4.trust.metalyzer.semantic.services;

import de.hshannover.f4.trust.metalyzer.api.MetalyzerAPI;
import de.hshannover.f4.trust.metalyzer.statistic.StatisticController;

/**
 * @author Michael Felchner
 * @author Mihaela Stein
 * @author Sven Steinbach
 * 
 * Controller-Class to instantiate all Service- and Resource-Classes and to
 * delegate the incoming requests from the Resource-Classes to the specific
 * Service-Classes. It also delegates the requests of all semantics-services to
 * the MetalyzerAPI.
 * 
 */
public class SemanticsController {
	// Enums for the 3 different types of semantic-requests.
	public enum RequestType {
		TIMESTAMP_REQUEST, TIMEINTERVAL_REQUEST, CURRENT_REQUEST
	}

	// Semantics-Services, Semantics-Resources, MetalyzerAPI and
	// statisticController
	private static SemanticsController semController;

	private UserService userServ;
	private DeviceService devServ;
	private IpAddressService ipServ;
	private MacAddressService macServ;

	private StatisticController evaCon;

	private String connectionName;

	private SemanticsController() {
		connectionName = "default";
	}

	private void init() {
		userServ = new UserService();
		devServ = new DeviceService();
		ipServ = new IpAddressService();
		macServ = new MacAddressService();
	}

	/**
	 * GetInstance-Method for singleton-pattern.
	 * 
	 * @return an object of the SemanticsController.
	 */
	public static synchronized SemanticsController getInstance() {
		if (semController == null) {
			semController = new SemanticsController();
			semController.init();
		}

		return semController;
	}

	/**
	 * To get the connection to MetalyzerAPI.
	 * 
	 * @return an object of the MetalyzerAPI.
	 */
	public MetalyzerAPI getAPI() {
		if (connectionName != null) {
			return MetalyzerAPI.getInstance(connectionName);
		} else {
			return MetalyzerAPI.getInstance(MetalyzerAPI.DEFAULT_CONNECTION);
		}
	}

	public void setConnection(String connectionName) {
		if (connectionName != null) {
			this.connectionName = connectionName;
		}
	}

	/**
	 * To get the instance of the UserService.
	 * 
	 * @return Returns an object of the UserService.
	 */
	public UserService getUserService() {
		return userServ;
	}

	/**
	 * To get the instance of the DeviceService.
	 * 
	 * @return Returns an object of the DeviceService.
	 */
	public DeviceService getDeviceService() {
		return devServ;
	}

	/**
	 * To get the instance of the IpAddressService.
	 * 
	 * @return Returns an object of the IpAddressService.
	 */
	public IpAddressService getIpAddressService() {
		return ipServ;
	}

	/**
	 * To get the instance of the MacAddressService.
	 * 
	 * @return Returns an object of the MacAddressService.
	 */
	public MacAddressService getMacAddressService() {
		return macServ;
	}

	/**
	 * To get the connection to the statisticsController.
	 * 
	 * @return Returns an object of the StatisticController.
	 */
	public StatisticController getEvaluationController() {
		return evaCon;
	}
}
