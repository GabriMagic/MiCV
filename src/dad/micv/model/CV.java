package dad.micv.model;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlType
@XmlRootElement
public class CV {

	private ObjectProperty<Personal> personal;
	private ObjectProperty<Contacto> contacto;
	private ListProperty<Titulo> titulo;
	private ListProperty<Experiencia> experiencia;
	private ListProperty<Conocimiento> habilidad;

	public CV() {
		personal = new SimpleObjectProperty<Personal>(this, "personal", new Personal());
		contacto = new SimpleObjectProperty<Contacto>(this, "contacto", new Contacto());
		titulo = new SimpleListProperty<Titulo>(this, "titulo", FXCollections.observableArrayList());
		experiencia = new SimpleListProperty<Experiencia>(this, "experiencia", FXCollections.observableArrayList());
		habilidad = new SimpleListProperty<Conocimiento>(this, "habilidad", FXCollections.observableArrayList());
	}

	public void save(File file) throws Exception {
		JAXBContext context = JAXBContext.newInstance(CV.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(this, file);
	}

	public static CV read(File file) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(CV.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (CV) unmarshaller.unmarshal(file);
	}

	public ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}

	@XmlElement
	public Personal getPersonal() {
		return this.personalProperty().get();
	}

	public void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}

	public ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}

	@XmlElement
	public Contacto getContacto() {
		return this.contactoProperty().get();
	}

	public void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}

	public ListProperty<Titulo> tituloProperty() {
		return this.titulo;
	}

	@XmlElement
	public ObservableList<Titulo> getTitulo() {
		return this.tituloProperty().get();
	}

	public void setTitulo(final ObservableList<Titulo> titulo) {
		this.tituloProperty().set(titulo);
	}

	public ListProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}

	@XmlElement
	public ObservableList<Experiencia> getExperiencia() {
		return this.experienciaProperty().get();
	}

	public void setExperiencia(final ObservableList<Experiencia> experiencia) {
		this.experienciaProperty().set(experiencia);
	}

	public ListProperty<Conocimiento> habilidadProperty() {
		return this.habilidad;
	}

	@XmlElement
	public ObservableList<Conocimiento> getHabilidad() {
		return this.habilidadProperty().get();
	}

	public void setHabilidad(final ObservableList<Conocimiento> habilidad) {
		this.habilidadProperty().set(habilidad);
	}

}
