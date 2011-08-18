package org.brukhman.cluster;

import java.util.Set;

import com.hazelcast.core.Hazelcast;

/**
 * A messenger.
 * 
 * @author jbrukh
 *
 */
public final class Messenger {

	private final User user;
	
	/**
	 * Create a new instance.
	 * 
	 * @param user
	 */
	public Messenger(User user) {
		this.user = user;
		Set<User> users = Hazelcast.getSet("users");
		if (users.contains(user)) {
			throw new RuntimeException("User already exists");
		}
		users.add(user);
	}
	
	public final void start() {
		
	}
	
	/**
	 * Start the messenger.
	 * 
	 * @param args
	 */
	public static final void main(String... args) {
		if (args.length < 2 ) {
			System.exit(1);
		}
		
		String user = args[1];
		if (user == null || user.length() < 1) {
			System.exit(1);
		}
		
		Messenger messenger = new Messenger(new User(user));
		messenger.start();
	}
}
