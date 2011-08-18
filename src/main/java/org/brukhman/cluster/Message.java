package org.brukhman.cluster;

import static com.google.common.base.Preconditions.*;

import java.util.Date;

/**
 * A chat message.
 * 
 * @author jbrukh
 *
 */
public final class Message {

	/**
	 * The source user.
	 */
	private final User sourceUser;
	
	/**
	 * The message.
	 */
	private final String message;
	
	/**
	 * The time this message was generated.
	 */
	private final Date timestamp;
	
	/**
	 * Create a new instance.
	 * 
	 * @param sourceUser
	 * @param message
	 */
	public Message(User sourceUser, String message) {
		checkNotNull(sourceUser);
		checkNotNull(message);
		this.sourceUser = sourceUser;
		this.message = message;
		this.timestamp = new Date();
	}

	/**
	 * Get the source user.
	 * 
	 * @return
	 */
	public final User getSourceUser() {
		return sourceUser;
	}

	/**
	 * Get the message (get it?).
	 * 
	 * @return
	 */
	public final String getMessage() {
		return message;
	}
	
	/**
	 * Get the timestamp.
	 * 
	 * @return
	 */
	public final Date getTimestamp() {
		return timestamp;
	}
}
