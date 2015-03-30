package com.movisens.xs.api.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Proband {

	@Expose
	private Integer id;
	@Expose
	private String currentVersion;
	@Expose
	private String status;

	/**
	 * 
	 * @return The id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The currentVersion
	 */
	public String getCurrentVersion() {
		return currentVersion;
	}

	/**
	 * 
	 * @param currentVersion
	 *            The currentVersion
	 */
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	/**
	 * 
	 * @return The status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}