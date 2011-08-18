package org.brukhman.cluster;

import static com.google.common.base.Preconditions.*;

/**
 * A user.
 * 
 * @author jbrukh
 *
 */
public class User {

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
	
}
