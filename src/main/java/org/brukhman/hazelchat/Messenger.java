package org.brukhman.hazelchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.MessageListener;

/**
 * A messenger.
 * 
 * @author jbrukh
 *
 */
public final class Messenger implements MessageListener<Message> {

	private final User user;
	
	/**
	 * Create a new instance.
	 * 
	 * @param user
	 */
	public Messenger(User user) {
		this.user = user;
	}
	
	public final void start() {
		System.out.println("Starting for user: " + user);
		final ITopic<Message> topic = Hazelcast.getTopic("default");
		topic.addMessageListener(this);
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)); // yes, this never gets closed
		while(true) {
			String line = null;
			try {
				line = br.readLine();
			} catch (IOException e) {}
			Message message = new Message(user, line);
			topic.publish(message);
		}
	}
	
	public void onMessage(Message message) {
		System.out.println(String.format("%s: %s", message.getSourceUser(), 
				message.getText()));
	}
	
	/**
	 * Start the messenger.
	 * 
	 * @param args
	 */
	public static final void main(String... args) {
		if (args.length < 1 ) {
			System.exit(1);
		}
		
		String user = args[0];
		if (user == null || user.length() < 1) {
			System.exit(1);
		}
		
		Messenger messenger = new Messenger(new User(user));
		messenger.start();
	}

	
}
