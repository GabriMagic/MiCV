package dad.micv.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlType
public class Experiencia {

	private ObjectProperty<LocalDate> desde, hasta;
	private StringProperty denominacion, empleador;

	public Experiencia() {
		desde = new SimpleObjectProperty<LocalDate>(this, "FechaInicio");
		hasta = new SimpleObjectProperty<LocalDate>(this, "FechaFin");
		denominacion = new SimpleStringProperty(this, "Deniminación");
		empleador = new SimpleStringProperty(this, "Organizador");
	}

	public ObjectProperty<LocalDate> desdeProperty() {
		return this.desde;
	}

	@XmlElement
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
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
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
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

	public StringProperty empleadorProperty() {
		return this.empleador;
	}

	@XmlElement
	public String getEmpleador() {
		return this.empleadorProperty().get();
	}

	public void setEmpleador(final String empleador) {
		this.empleadorProperty().set(empleador);
	}

	@Override
	public String toString() {
		return "Desde: " + getDesde().toString() + "\nHasta:" + getHasta().toString() + "\nDenominacion: "
				+ getDenominacion() + "\nEmpleador: " + getEmpleador();
	}

}
