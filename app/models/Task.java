package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;



@Entity
public class Task extends Model {
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Id
	public String Id;
	
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	@Required
	public String contents;

}
