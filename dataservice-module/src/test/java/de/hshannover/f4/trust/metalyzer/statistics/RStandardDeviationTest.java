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
package de.hshannover.f4.trust.metalyzer.statistics;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import de.hshannover.f4.trust.metalyzer.statistic.RStandardDeviation;

public class RStandardDeviationTest {
		
		private ArrayList<Integer> list;
		private RStandardDeviation dia;
		
		@Test
		public void thenRSDevaluateRight(){
			givenPositiveListOfData();
			double temp = dia.getStandardDeviation() *100000;
			temp/=100000;
			assertEquals(3.02765, temp, 5);
		}
		
		@Test
		public void thenMinValIsRight(){
			givenPositiveListOfData();
			assertEquals(1,dia.getMinValue(),0);
		}
		
		@Test
		public void thenMaxValIsRight(){
			givenPositiveListOfData();
			assertEquals(10,dia.getMaxValue(),0);
		}
		
		
		private void givenPositiveListOfData(){
			list = new ArrayList<Integer>();
			Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10);
			dia = new RStandardDeviation(list);
		}
		
		
		
		
		

	}


