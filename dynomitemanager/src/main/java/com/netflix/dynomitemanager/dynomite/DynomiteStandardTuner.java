package com.netflix.dynomitemanager.dynomite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netflix.dynomitemanager.IInstanceState;
import com.netflix.dynomitemanager.identity.InstanceIdentity;
import com.netflix.dynomitemanager.sidecore.IConfiguration;
import com.netflix.dynomitemanager.sidecore.IStorageProxy;
import com.netflix.dynomitemanager.sidecore.utils.ProcessTuner;

/**
 * Generate and write the dynomite.yaml configuration file to disk.
 */
@Singleton
public class DynomiteStandardTuner implements ProcessTuner {

	private static final Logger logger = LoggerFactory.getLogger(DynomiteStandardTuner.class);
	private static final String ROOT_NAME = "dyn_o_mite";

	protected final IConfiguration config;
	protected final InstanceIdentity ii;
	protected final IInstanceState instanceState;
	protected final IStorageProxy storageProxy;

	@Inject
	public DynomiteStandardTuner(IConfiguration config, InstanceIdentity ii, IInstanceState instanceState,
			IStorageProxy storageProxy) {
		this.config = config;
		this.ii = ii;
		this.instanceState = instanceState;
		this.storageProxy = storageProxy;
	}

	/**
	 * Generate dynomite.yaml.
	 *
	 * @param yamlLocation
	 *            path to the dynomite.yaml file
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void writeAllProperties(String yamlLocation) throws IOException {
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		Yaml yaml = new Yaml(options);
		File yamlFile = new File(yamlLocation);
		Map map = (Map) yaml.load(new FileInputStream(yamlFile));
		Map entries = (Map) map.get(ROOT_NAME);

		entries.put("auto_eject_hosts", config.getDynomiteAutoEjectHosts());
		entries.put("rack", config.getRack());
		entries.put("distribution", config.getDistribution());
		entries.put("dyn_listen", config.getDynListenPort());
		entries.put("dyn_seed_provider", config.getDynomiteSeedProvider());
		entries.put("gos_interval", config.getDynomiteGossipInterval());
		entries.put("hash", config.getDynomiteHashAlgorithm());
		entries.put("listen", config.getClientListenPort());
		entries.put("preconnect", config.getDynomiteStoragePreconnect());
		entries.put("server_retry_timeout", config.getServerRetryTimeout());
		entries.put("timeout", config.getTimeout());
		entries.put("tokens", ii.getTokens());
		entries.put("secure_server_option", config.getDynomiteIntraClusterSecurity());
		entries.remove("redis");
		entries.put("datacenter", config.getDataCenter());
		entries.put("read_consistency", config.getDynomiteReadConsistency());
		entries.put("write_consistency", config.getDynomiteWriteConsistency());
		entries.put("pem_key_file", "/apps/dynomite/conf/dynomite.pem");

		List seedp = (List) entries.get("dyn_seeds");
		if (seedp == null) {
			seedp = new ArrayList<String>();
			entries.put("dyn_seeds", seedp);
		} else {
			seedp.clear();
		}

		List<String> seeds = ii.getSeeds();
		if (seeds.size() != 0) {
			for (String seed : seeds) {
				seedp.add(seed);
			}
		} else {
			entries.remove("dyn_seeds");
		}

		List servers = (List) entries.get("servers");
		if (servers == null) {
			servers = new ArrayList<String>();
			entries.put("servers", servers);
		} else {
			servers.clear();
		}

		entries.put("data_store", storageProxy.getEngineNumber());
		servers.add(storageProxy.getIpAddress() + ":" + storageProxy.getPort() + ":" + 1);

		if (!this.instanceState.getYmlWritten()) {
			logger.info("YAML Dump: ");
			logger.info(yaml.dump(map));
			storageProxy.updateConfiguration();
		} else {
			logger.info("Updating dynomite.yml with latest information");
		}
		yaml.dump(map, new FileWriter(yamlLocation));

		this.instanceState.setYmlWritten(true);
	}

	/**
	 * UNUSED METHOD
	 *
	 * @param yamlFile
	 * @param autobootstrap
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void updateAutoBootstrap(String yamlFile, boolean autobootstrap) throws IOException {
		DumperOptions options = new DumperOptions();
		options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		Yaml yaml = new Yaml(options);
		@SuppressWarnings("rawtypes")
		Map map = (Map) yaml.load(new FileInputStream(yamlFile));
		// Do not bootstrap in restore mode
		map.put("auto_bootstrap", autobootstrap);
		logger.info("Updating yaml" + yaml.dump(map));
		yaml.dump(map, new FileWriter(yamlFile));
	}

}
