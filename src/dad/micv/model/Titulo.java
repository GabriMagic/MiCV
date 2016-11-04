package dad.micv.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlType
public class Titulo {

	private ObjectProperty<LocalDate> desde, hasta;
	private StringProperty denominacion, organizador;

	public Titulo() {
		desde = new SimpleObjectProperty<LocalDate>(this, "FechaInicio");
		hasta = new SimpleObjectProperty<LocalDate>(this, "FechaFin");

		denominacion = new SimpleStringProperty(this, "Deniminación");
		organizador = new SimpleStringProperty(this, "Organizador");
	}

	public ObjectProperty<LocalDate> desdeProperty() {
		return this.desde;
	}

	@XmlElement
	public LocalDate getDesde() {
		return this.desdeProperty().get();
	}

	public void setDesde(final LocalDate desde) {
		this.desdeProperty().set(desde);
	}

	public ObjectProperty<LocalDate> hastaProperty() {
		return this.hasta;
	}

	@XmlElement
	public LocalDate getHasta() {
		return this.hastaProperty().get();
	}

	public void setHasta(final LocalDate hasta) {
		this.hastaProperty().set(hasta);
	}

	public StringProperty denominacionProperty() {
		return this.denominacion;
	}

	@XmlElement
	public String getDenominacion() {
		return this.denominacionProperty().get();
	}

	public void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}

	public StringProperty organizadorProperty() {
		return this.organizador;
	}

	@XmlElement
	public String getOrganizador() {
		return this.organizadorProperty().get();
	}

	public void setOrganizador(final String organizador) {
		this.organizadorProperty().set(organizador);
	}

}
