package org.brukhman.hazelchat;

import static com.google.common.base.Preconditions.*;

import java.io.Serializable;

import com.google.common.base.Objects;

/**
 * A user.
 * 
 * @author jbrukh
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7393291681353434649L;
	
	/**
	 * The name of the user.
	 */
	private final String name;
	
	/**
	 * Create a new instane.
	 * 
	 * @param name
	 */
	public User(String name) {
		checkNotNull(name);
		this.name = name;
	}
	
	/**
	 * Get the name of the user.
	 * 
	 * @return
	 */
	public final String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
