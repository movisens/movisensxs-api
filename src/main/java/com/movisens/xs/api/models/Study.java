package com.movisens.xs.api.models;

import com.google.gson.annotations.Expose;
import org.jetbrains.annotations.NotNull;

public class Study {

	@Expose
	@NotNull
	private Integer id;
	@Expose
	@NotNull
	private String name;

	@NotNull
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Study{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Study study = (Study) o;

		if (id != null ? !id.equals(study.id) : study.id != null) return false;
		if (name != null ? !name.equals(study.name) : study.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}