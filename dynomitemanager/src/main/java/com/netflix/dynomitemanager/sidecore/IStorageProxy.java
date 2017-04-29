package com.netflix.dynomitemanager.sidecore;

/**
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
import java.io.IOException;

public interface IStorageProxy {

	/**
	 * @return Storage is alive
	 */
	boolean isAlive();

	/**
	 * @return Getting the up time of the storage
	 */
	long getUptime();

	/**
	 * @return The status of the warm up
	 */
	Bootstrap warmUpStorage(String[] peers);

	/**
	 * @return Turn slave to master
	 */
	boolean resetStorage();

	boolean takeSnapshot();

	boolean loadingData();

	void stopPeerSync();

	String getEngine();

	int getEngineNumber();

	void updateConfiguration() throws IOException;

	String getStartupScript();

	String getStopScript();

	String getIpAddress();

	int getPort();

	long getStoreMaxMem();

	long getTotalAvailableSystemMemory();
}