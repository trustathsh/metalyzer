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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import de.hshannover.f4.trust.metalyzer.gui.CategoryPanel;
import de.hshannover.f4.trust.metalyzer.gui.MetalyzerGuiController;

/**
 * @author Daniel Huelse
 * 
 */
public class BrowserSelectionHandler extends MouseAdapter {

	private TreePath mSelectionPath;
	private JTree mTree;
	private MetalyzerGuiController mGuiController;

	public BrowserSelectionHandler(JTree tree,
			MetalyzerGuiController guiController) {
		this.mTree = tree;
		this.mGuiController = guiController;
	}

	/**
	 * Triggers a MouseEvent, which initializes the {@link CategoryPanel}
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			mSelectionPath = mTree.getPathForLocation(e.getX(), e.getY());
			if (mSelectionPath != null) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) mSelectionPath
						.getLastPathComponent();
				if (selectedNode != null) {
					if (selectedNode.isLeaf()) {
						mGuiController.selectCategory(mSelectionPath);
					}
				}
			}
		}
	}

}
