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
package de.hshannover.f4.trust.metalyzer.statistics;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.TestCase;

import org.junit.Test;

import de.hshannover.f4.trust.metalyzer.statistic.RMean;

public class RMeanTest extends TestCase {
	private RMean rMean;
	private ArrayList<Integer> testList;
	
	@Test
	public void testRMeanForPosValues() {
		givenListOfPosIntegerValues();
		whenRMeanAddPosArrayList();
		thenPosListShouldBeEvaluateRight();
	}
	
	@Test
	public void testRMeanByEmptyList(){
		givenAnEmptyArrayList();
		thenResultShouldBeNull();
	}
	private void givenListOfPosIntegerValues(){
		testList = new ArrayList<Integer>();
		Collections.addAll(testList, 1,2,3,4,5,6,7,8,9,10);
			
	}
	
	private void whenRMeanAddPosArrayList(){
		rMean = new RMean(testList);
	}
	
	private void thenPosListShouldBeEvaluateRight(){
		assertEquals("Value should be 5.5", 5.5, rMean.getMean());
	}
	
	private void givenAnEmptyArrayList(){
		testList = new ArrayList<Integer>();
		rMean = new RMean(testList);
	}
	private void thenResultShouldBeNull(){
		assertEquals("Value should be 0 when list ist empty", 0.0, rMean.getMean());
	}
}
