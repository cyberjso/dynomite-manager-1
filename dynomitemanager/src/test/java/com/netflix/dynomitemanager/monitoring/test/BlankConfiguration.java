/**
 * Copyright 2016 Netflix, Inc.
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
package com.netflix.dynomitemanager.monitoring.test;

import java.util.List;

import com.netflix.dynomitemanager.sidecore.IConfiguration;

/**
 * Blank IConfiguration class used for tests.
 *
 * @author diegopacheco
 * @author ipapapa
 * @author akbarahmed
 */
public class BlankConfiguration implements IConfiguration {

	@Override
	public boolean isWarmBootstrap() {
		return false;
	}

	@Override
	public boolean isVpc() {
		return false;
	}

	@Override
	public boolean isRestoreEnabled() {
		return false;
	}

	@Override
	public boolean isRedisPersistenceEnabled() {
		return false;
	}

	@Override
	public String getRedisPersistenceType() {
		return null;
	}

	@Override
	public boolean isDynomiteMultiDC() {
		return false;
	}

	@Override
	public boolean isEurekaHostsSupplierEnabled() {
		return false;
	}

	@Override
	public boolean isBackupEnabled() {
		return false;
	}

	@Override
	public boolean isRedisAofEnabled() {
		return false;
	}

	@Override
	public void initialize() {
	}

	@Override
	public List<String> getZones() {
		return null;
	}

	@Override
	public String getZone() {
		return null;
	}

	@Override
	public String getDynomiteYaml() {
		return null;
	}

	@Override
	public String getDynomiteWriteConsistency() {
		return null;
	}

	@Override
	public String getVpcId() {
		return null;
	}

	@Override
	public int getTimeout() {
		return 0;
	}

	@Override
	public int getDatastoreMaxMemoryPercent() {
		return 0;
	}

	@Override
	public int getServerRetryTimeout() {
		return 0;
	}

	@Override
	public String getDynomiteSeedProvider() {
		return null;
	}

	@Override
	public String getDynomiteIntraClusterSecurity() {
		return null;
	}

	@Override
	public String getRestoreDate() {
		return null;
	}

	@Override
	public String getDataCenter() {
		return null;
	}

	@Override
	public String getDynomiteReadConsistency() {
		return null;
	}

	@Override
	public List<String> getRacks() {
		return null;
	}

	@Override
	public String getRack() {
		return null;
	}

	@Override
	public String getDynomiteProcessName() {
		return null;
	}

	@Override
	public boolean getDynomiteStoragePreconnect() {
		return false;
	}

	@Override
	public String getRedisDataDir() {
		return null;
	}

	@Override
	public int getDynomitePeerPort() {
		return 0;
	}

	@Override
	public int getDynomiteMBufSize() {
		return 0;
	}

	@Override
	public int getMaxTimeToBootstrap() {
		return 0;
	}

	@Override
	public int getDynomiteClientPort() {
		return 0;
	}

	@Override
	public String getInstanceName() {
		return null;
	}

	@Override
	public String getHostname() {
		return null;
	}

	@Override
	public String getHostIP() {
		return null;
	}

	@Override
	public String getDynomiteHashAlgorithm() {
		return null;
	}

	@Override
	public int getDynomiteGossipInterval() {
		return 0;
	}

	@Override
	public String getDynListenPort() {
		return null;
	}

	@Override
	public String getDistribution() {
		return null;
	}

	@Override
	public String getCassandraSeeds() {
		return null;
	}

	@Override
	public String getClientListenPort() {
		return null;
	}

	@Override
	public int getCassandraThriftPort() {
		return 9160;
	}

	@Override
	public String getCassandraKeyspaceName() {
		return null;
	}

	@Override
	public String getBucketName() {
		return null;
	}

	@Override
	public String getCassandraClusterName() {
		return null;
	}

	@Override
	public String getBackupSchedule() {
		return null;
	}

	@Override
	public String getBackupLocation() {
		return null;
	}

	@Override
	public int getBackupHour() {
		return 0;
	}

	@Override
	public boolean getDynomiteAutoEjectHosts() {
		return false;
	}

	@Override
	public String getDynomiteStopScript() {
		return null;
	}

	@Override
	public String getDynomiteStartScript() {
		return null;
	}

	@Override
	public String getDynomiteClusterName() {
		return null;
	}

	@Override
	public String getDynomiteInstallDir() {
		return null;
	}

	@Override
	public int getAllowableBytesSyncDiff() {
		return 0;
	}

	@Override
	public int getDynomiteMaxAllocatedMessages() {
		return 0;
	}

	@Override
	public String getASGName() {
		return null;
	}

	@Override
	public String getACLGroupName() {
		return null;
	}

	@Override
	public String getClassicAWSRoleAssumptionArn() {
		return null;
	}

	@Override
	public String getVpcAWSRoleAssumptionArn() {
		return null;
	}

	@Override
	public boolean isDualAccount() {
		return false;
	}

	@Override
	public boolean isForceWarm() {
		return false;
	}

	@Override
	public String getCrossAccountRack() {
		return null;
	}

	@Override
	public String getDatastoreEngine() {
		return null;
	}

	@Override
	public String getRedisConf() {
		return null;
	}

	@Override
	public String getRedisStartScript() {
		return null;
	}

	@Override
	public String getRedisStopScript() {
		return null;
	}

	// ARDB RocksDB
	// ============

	@Override
	public String getArdbRocksDBConf() {
		return null;
	}

	@Override
	public String getArdbRocksDBStartScript() {
		return null;
	}

	@Override
	public String getArdbRocksDBStopScript() {
		return null;
	}

	@Override
	public int getArdbRocksDBWriteBufferSize() {
		return 0;
	}

	@Override
	public int getArdbRocksDBMaxWriteBufferNumber() {
		return 0;
	}

	@Override
	public int getArdbRocksDBMinWriteBuffersToMerge() {
		return 0;
	}

}
