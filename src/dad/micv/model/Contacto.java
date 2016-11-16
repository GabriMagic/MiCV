package dad.micv.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlType
public class Contacto {

	private ListProperty<Telefono> telefonos;
	private ListProperty<Email> emails;
	private ListProperty<Web> webs;

	public Contacto() {
		telefonos = new SimpleListProperty<Telefono>(this, "telefonos", FXCollections.observableArrayList());
		emails = new SimpleListProperty<Email>(this, "emails", FXCollections.observableArrayList());
		webs = new SimpleListProperty<Web>(this, "web", FXCollections.observableArrayList());
	}

	public ListProperty<Telefono> telefonosProperty() {
		return this.telefonos;
	}

	@XmlElement
	public ObservableList<Telefono> getTelefonos() {
		return this.telefonosProperty().get();
	}

	public void setTelefonos(final ObservableList<Telefono> telefonos) {
		this.telefonosProperty().set(telefonos);
	}

	public ListProperty<Email> emailsProperty() {
		return this.emails;
	}

	@XmlElement
	public ObservableList<Email> getEmails() {
		return this.emailsProperty().get();
	}

	public void setEmails(final ObservableList<Email> emails) {
		this.emailsProperty().set(emails);
	}

	public ListProperty<Web> websProperty() {
		return this.webs;
	}

	@XmlElement
	public ObservableList<Web> getWebs() {
		return this.websProperty().get();
	}

	public void setWebs(final ObservableList<Web> webs) {
		this.websProperty().set(webs);
	}

}
