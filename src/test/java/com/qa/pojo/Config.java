package com.qa.pojo;

import java.util.Map;

public class Config {
	
	private Map<String, Environment> environments;
	
	public Map<String, Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, Environment> environments) {
		this.environments = environments;
	}
	
	public static class Environment {
		private String url;
		private int MAX_NUMBER_OF_ATTEMPTS;
		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public int getMAX_NUMBER_OF_ATTEMPTS() {
			return MAX_NUMBER_OF_ATTEMPTS;
		}

		public void setMAX_NUMBER_OF_ATTEMPTS(int MAX_NUMBER_OF_ATTEMPTS) {
			MAX_NUMBER_OF_ATTEMPTS = MAX_NUMBER_OF_ATTEMPTS;
		}

		@Override
		public String toString() {
			return "Environment [url=" + url + ", MAX_NUMBER_OF_ATTEMPTS=" + MAX_NUMBER_OF_ATTEMPTS + "]";
		}

	}

	@Override
	public String toString() {
		return "Config [environments=" + environments + "]";
	}

}
