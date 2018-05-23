package umg.software.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ciudadano")
public class Ciudadano {

	@Id
	public String id;
	public String dpi;
	public Object data;
	
	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDpi() {
		return dpi;
	}
	
	public void setDpi(String dpi) {
		this.dpi = dpi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
