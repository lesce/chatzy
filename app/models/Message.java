package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;
import play.mvc.*;
import play.cache.*;

@Entity
public class Message extends Model {
	public String message;
	public Date timestamp;
	public String nickname;
	public Message(String author,String message) {
		this.message = message;
		this.timestamp = new Date();
		this.nickname = author;
	}
	/*public Message(String message) {
		this.message = message;
		this.timestamp = new Date();
		this.nickname = "guest_"+getId();
	}*/
}