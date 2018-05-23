package umg.software.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servicio")
public class Servicio {
	
	@Id
	public String id;
	public int codigoServicio;
	public String nombre;

	public Servicio() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCodigoServicio() {
		return codigoServicio;
	}
	
	public void setCodigoServicio(int codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
