package models;

import java.util.*;
import javax.persistence.*;
import play.db.jpa.*;

@Entity
public class Nick extends Model {
	public String name;
	public Nick(String nickname) {
		this.name = nickname;
	}
}