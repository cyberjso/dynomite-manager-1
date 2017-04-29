package com.netflix.dynomitemanager.sidecore;
/**
 * Copyright 2014 Netflix, Inc.
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

import java.util.List;

/**
 * Dynomite Manager configuration.
 */
public interface IConfiguration {

	public void initialize();

	// Dynomite
	// ========

	/**
	 * Determine if Dynomite should auto-eject nodes from the cluster.
	 *
	 * @return true if Dynomite should auto-ejects hosts, false if not
	 */
	public boolean getDynomiteAutoEjectHosts();

	/**
	 * Get the cluster name that is saved in tokens.appId in Cassandra. Cluster
	 * name is used to group Dynomite nodes that are part of the same cluster.
	 * 
	 * @return the cluster name
	 */
	public String getDynomiteClusterName();

	/**
	 * Get the Dynomite gossip interval which is the amount of time (in ms) that
	 * Dynomite should wait between gossip rounds.
	 *
	 * @return the amount of time in ms to wait between gossip rounds
	 */
	public int getDynomiteGossipInterval();

	/**
	 * Get the hash algorithm that Dynomite uses to hash the data's key.
	 *
	 * @return the hash algorithm used to hash the data key
	 */
	public String getDynomiteHashAlgorithm();

	/**
	 * Get the full path to Dynomite's installation directory.
	 *
	 * @return full path to the Dynomite installation directory
	 */
	public String getDynomiteInstallDir();

	/**
	 * Get the intra-cluster (i.e. node-to-node) security option. Maps to the
	 * secure_server_option property in dynomite.yaml.
	 *
	 * @return the intra-cluster security option
	 */
	public String getDynomiteIntraClusterSecurity();

	/**
	 * Get the maximum number of messages that Dynomite will hold in queue.
	 *
	 * @return the maximum number of messages that Dynomite will allocate
	 */
	public int getDynomiteMaxAllocatedMessages();

	/**
	 * Get the size (in bytes) of Dynomite's memory buffer (mbuf).
	 *
	 * @return size of Dynomite mbuf in bytes
	 */
	public int getDynomiteMBufSize();

	/**
	 * Get the Dynomite process name.
	 *
	 * @return the Dynomite process name
	 */
	public String getDynomiteProcessName();

	/**
	 * Get the read consistency level.
	 *
	 * @return the read consistency level
	 */
	public String getDynomiteReadConsistency();

	/**
	 * Get the name of the seed provider that Dynomite uses to learn the
	 * cluster's topology.
	 * 
	 * @return the seed provider name
	 */
	public String getDynomiteSeedProvider();

	/**
	 * Get the full path to the start Dynomite shell script.
	 *
	 * @return full path to the Dynomite start script
	 */
	public String getDynomiteStartScript();

	/**
	 * Get the full path to the stop Dynomite shell script.
	 *
	 * @return full path to the Dynomite stop script
	 */
	public String getDynomiteStopScript();

	/**
	 * Should Dynomite preconnect to the backend storage engine.
	 *
	 * @return true if Dynomite should preconnect to the backend storage engine,
	 *         false if it should not preconnect
	 */
	public boolean getDynomiteStoragePreconnect();

	/**
	 * Get the write consistency level.
	 *
	 * @return the write consistency level
	 */
	public String getDynomiteWriteConsistency();

	/**
	 * Get the full path to the dynomite.yml configuration file.
	 *
	 * @return full path to the dynomite.yml file.
	 */
	public String getDynomiteYaml();

	/**
	 * Determine if Dynomite is configured as a multi-DC (data center) cluster).
	 *
	 * @return true if the Dynomite cluster is running across multiple DCs
	 */
	public boolean isDynomiteMultiDC();

	/**
	 * @return Zone (or zone for AWS)
	 */
	public String getZone();

	/**
	 * @return List of all RAC used for the cluster
	 */
	public List<String> getZones();

	/**
	 * @return Local hostname
	 */
	public String getHostname();

	/**
	 * @return Get instance name (for AWS)
	 */
	public String getInstanceName();

	/**
	 * Get the data center (AWS region).
	 *
	 * @return the data center (AWS region)
	 */
	public String getDataCenter();

	// public void setRegion(String region);

	/**
	 * Get the rack (AWS AZ).
	 *
	 * @return the rack (AWS AZ)
	 */
	public String getRack();

	/**
	 * @return Get the cross account rack if in dual account mode
	 */
	public String getCrossAccountRack();

	public List<String> getRacks();

	/**
	 * Amazon specific setting to query ASG Membership
	 */
	public String getASGName();

	/**
	 * Get the AWS Security Group (SG) assigned to the Dynomite cluster nodes.
	 * 
	 * @return the AWS Security Group
	 */
	public String getACLGroupName();

	/**
	 * @return Get host IP
	 */
	public String getHostIP();

	/**
	 * Get the client port used by Redis (i.e. RESP) clients to query Dynomite
	 * (default: 8102).
	 *
	 * @return the port that Dynomite listens on for client requests
	 */
	public int getDynomiteClientPort();

	/**
	 * Get the peer-to-peer port used by Dynomite to communicate with other
	 * Dynomite nodes.
	 *
	 * @return the peer-to-peer port used for intra-cluster communication
	 */
	public int getDynomitePeerPort();

	public String getDistribution();

	public String getDynListenPort();

	public String getClientListenPort();

	public int getServerRetryTimeout();

	public int getTimeout();

	public boolean isWarmBootstrap();

	public boolean isForceWarm();

	public int getAllowableBytesSyncDiff();

	public int getMaxTimeToBootstrap();

	// VPC
	public boolean isVpc();

	/**
	 * @return the VPC id of the running instance.
	 */
	public String getVpcId();

	/*
	 * @return the Amazon Resource Name (ARN) for EC2 classic.
	 */
	public String getClassicAWSRoleAssumptionArn();

	/*
	 * @return the Amazon Resource Name (ARN) for VPC.
	 */
	public String getVpcAWSRoleAssumptionArn();

	/*
	 * @return cross-account deployments
	 */
	public boolean isDualAccount();

	// Backup and Restore

	public String getBucketName();

	public String getBackupLocation();

	public boolean isBackupEnabled();

	public boolean isRestoreEnabled();

	public String getBackupSchedule();

	public int getBackupHour();

	public String getRestoreDate();

	// Cassandra
	// =========
	// Cassandra is used to store the Dynomite cluster topology.

	/**
	 * Get the Cassandra cluster name for the topology database (i.e. the
	 * database that stores the complete Dynomite cluster topology).
	 *
	 * @return the Cassandra cluster name for the topology database
	 */
	public String getCassandraClusterName();

	/**
	 * Get the name of the keyspace that stores tokens for the Dynomite cluster.
	 *
	 * @return the keyspace name
	 */
	public String getCassandraKeyspaceName();

	/**
	 * Get the Cassandra thrift port. This port is used by Astyanax.
	 *
	 * @return the Cassandra thrift port
	 */
	public int getCassandraThriftPort();

	/**
	 * Get a comma separated list of Cassandra hostnames or ip addresses. This
	 * list of hosts are the Cassandra seeds.
	 *
	 * @return a comma separated list of Cassandra hostnames or ip addresses
	 */
	public String getCassandraSeeds();

	// Data store (aka backend)
	// ========================

	/**
	 * Get the type of data store engine, such as Redis or ARDB with RocksDB.
	 *
	 * @return RESP backend data store server (redis, ardb-rocksdb)
	 */
	public String getDatastoreEngine();

	/**
	 * Get the maximum percentage of system memory to be allocated to the
	 * backend storage engine, such as Redis or ARDB.
	 *
	 * @return the max percentage of memory allocated to the storage engine
	 */
	public int getDatastoreMaxMemoryPercent();

	// Data store: Redis
	// =================

	/**
	 * Get the full path to the redis.conf configuration file. Netflix:
	 * /apps/nfredis/conf/redis.conf DynomiteDB: /etc/dynomitedb/redis.conf
	 *
	 * @return the {@link String} full path to the redis.conf configuration file
	 */
	public String getRedisConf();

	/**
	 * Get the full path to the directory where Redis stores its AOF or RDB data
	 * files.
	 *
	 * @return the full path to the directory where Redis stores its data files
	 */
	public String getRedisDataDir();

	/**
	 * Get the persistence type of either AOF or RDB.
	 *
	 * @return the persistence type (aof, rdb)
	 */
	public String getRedisPersistenceType();

	/**
	 * Get the full path to the Redis init start script, including any
	 * arguments.
	 *
	 * @return the full path of the Redis init start script
	 */
	public String getRedisStartScript();

	/**
	 * Get the full path to the Redis init stop script, including any arguments.
	 *
	 * @return the full path of the Redis init stop script
	 */
	public String getRedisStopScript();

	/**
	 * Checks if Redis append-only file (AOF) persistence is enabled.
	 *
	 * @return true to indicate that AOF persistence is enabled or false to
	 *         indicate that RDB persistence is enabled
	 */
	public boolean isRedisAofEnabled();

	/**
	 * Determines whether or not Redis will save data to disk.
	 *
	 * @return true if Redis should persist in-memory data to disk or false if
	 *         Redis should only store data in-memory
	 */
	public boolean isRedisPersistenceEnabled();

	// Data store: ARDB with RocksDB
	// =============================

	/**
	 * Get the full path to the rocksdb.conf configuration file.
	 *
	 * @return the {@link String} full path to the rocksdb.conf configuration
	 *         file
	 */
	public String getArdbRocksDBConf();

	/**
	 * Get the maximum number of memtables used by RocksDB. This number includes
	 * both active and immutable memtables.
	 *
	 * @return the maximum number of memtables
	 */
	public int getArdbRocksDBMaxWriteBufferNumber();

	/**
	 * Get the minimum number of memtables to be merged before flushing data to
	 * persistent storage.
	 *
	 * @return the minimum number of memtables that must exist before a flush
	 *         occurs
	 */
	public int getArdbRocksDBMinWriteBuffersToMerge();

	/**
	 * Get the full path to the ARDB RocksDB init start script, including any
	 * arguments.
	 *
	 * @return the full path of the ARDB RocksDB init start script
	 */
	public String getArdbRocksDBStartScript();

	/**
	 * Get the full path to the ARDB RocksDB init stop script, including any
	 * arguments.
	 *
	 * @return the full path of the ARDB RocksDB init stop script
	 */
	public String getArdbRocksDBStopScript();

	/**
	 * Get the ARDB RocksDB write buffer size in MB.
	 *
	 * @return the RocksDB write buffer size in MB
	 */
	public int getArdbRocksDBWriteBufferSize();

	// Eureka
	// ======

	public boolean isEurekaHostsSupplierEnabled();

}