package org.tektutor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage( String message ) {
		this.message = message;
	} 

}
