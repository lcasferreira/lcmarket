package com.lcferreira.market.model;

import java.io.Serializable;

import lombok.Setter;

public abstract class BasicEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6036254045100407606L;
	
	@Setter
	protected Long id;
	
	public abstract Long getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicEntity other = (BasicEntity) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}
	
	
}
