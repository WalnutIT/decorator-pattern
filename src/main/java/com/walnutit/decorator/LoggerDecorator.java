/**
 * Copyright 2020 - 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walnutit.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Daniel Krentzlin
 *
 */
public class LoggerDecorator extends Decorator {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerDecorator.class);

	/**
	 * @param component
	 */
	public LoggerDecorator(Component component) {
		super(component);
	}

	@Override
	public int doBusinessLogic(int value1, int value2)
			 {
		LOGGER.debug("value1: " + value1);
		LOGGER.debug("value2: " + value2);
		LOGGER.info("Starting doing business logic");
		int result = 0;
		try {
			result = component.doBusinessLogic(value1, value2);
		} catch (Exception e) {
			LOGGER.error("Couldn't procceed business logic", e);
		}
		LOGGER.info("Finished doing business logic");
		LOGGER.debug(
				"The result of business the business logic is:"
						+ result);
		return result;
	}

}
