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
 * This file is part of metalyzer-visualization, version 0.1.1,
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
package de.hshannover.f4.trust.metalyzer.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.hshannover.f4.trust.metalyzer.gui.CategoryPanel;
import de.hshannover.f4.trust.metalyzer.gui.MetalyzerGuiController;

/**
 * @author Daniel Huelse
 *
 */
public class TabCloseHandler implements ActionListener {
	
	private MetalyzerGuiController mGuiController;
	private CategoryPanel mComponent;
	
	public TabCloseHandler(MetalyzerGuiController guiController, CategoryPanel component) {
		this.mGuiController = guiController;
		this.mComponent = component;
	}

	/**
	 * Triggers an {@link ActionEvent} when a tab is closed and 
	 * the {@link MetalyzerGuiController#cleanup(CategoryPanel)} is called
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mGuiController.cleanup(mComponent);
	}

}
