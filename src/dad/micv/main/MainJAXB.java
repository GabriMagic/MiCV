package dad.micv.main;

import java.io.File;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlType;
import dad.micv.model.CV;
import dad.micv.model.Conocimiento;
import dad.micv.model.Experiencia;
import dad.micv.model.Idioma;
import dad.micv.model.Nacionalidad;
import dad.micv.model.Nivel;
import dad.micv.model.Telefono;
import dad.micv.model.TipoTelefono;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlType
public class MainJAXB {

	public static void main(String[] args) throws Exception {

		CV cv = new CV();

		Nacionalidad americana = new Nacionalidad();
		americana.setDenominacion("Estadounidense");

		Nacionalidad japonesa = new Nacionalidad();
		japonesa.setDenominacion("Japonés");

		cv.getPersonal().setIdentificacion("564654z");
		cv.getPersonal().setNombre("Chuck");
		cv.getPersonal().setApellidos("Norris");
		cv.getPersonal().setFechaNacimiento(LocalDate.of(1942, 10, 6));
		cv.getPersonal().getNacionalidades().add(americana);
		cv.getPersonal().getNacionalidades().add(japonesa);

		ObservableList<Telefono> telefonos = FXCollections.observableArrayList();

		Telefono t1 = new Telefono();
		t1.setTipo(TipoTelefono.MOVIL);
		t1.setNumero("606263803");

		Telefono t2 = new Telefono();
		t2.setTipo(TipoTelefono.DOMICILIO);
		t2.setNumero("922568987");

		Telefono t3 = new Telefono();
		t3.setTipo(TipoTelefono.DOMICILIO);
		t3.setNumero("955875421");

		telefonos.addAll(t1, t2, t3);

		cv.getContacto().setTelefonos(telefonos);

		Experiencia ex = new Experiencia();

		ex.setDenominacion("DAM 2");
		ex.setDesde(LocalDate.of(1994, 6, 9));
		ex.setHasta(LocalDate.of(2017, 6, 9));
		ex.setEmpleador("Pérez Minik");

		cv.getExperiencia().add(ex);

		Conocimiento co = new Conocimiento();
		co.setDenominacion("Liarla parda");
		co.setNivel(Nivel.AVANZADO);
		
		Idioma id = new Idioma();
		id.setCertificacion("Inglés");
		id.setNivel(Nivel.AVANZADO);
		
		cv.getHabilidad().add(id);
		cv.getHabilidad().add(co);
		
		cv.save(new File("micurriculum.xml"));
	}

}
