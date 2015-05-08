package com.movisens.xs.api.models;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Study {

	@Expose
	private long id;
	@Expose
	private String name;
	@Expose
	private boolean deleted;

	/**
	 * 
	 * @return The id
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The deleted
	 */
	public boolean getDeleted() {
		return deleted;
	}

	/**
	 * 
	 * @param deleted
	 *            The deleted
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}