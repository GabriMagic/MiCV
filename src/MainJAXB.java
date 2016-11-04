
import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlType;

import dad.micv.model.CV;
import dad.micv.model.Nacionalidad;

@XmlType
public class MainJAXB {

	public static void main(String[] args) throws Exception {

		Nacionalidad americana = new Nacionalidad();
		americana.setDenominacion("Estadounidense");

		Nacionalidad japonesa = new Nacionalidad();
		japonesa.setDenominacion("Japonés");

		CV cv = new CV();
		cv.getPersonal().setIdentificacion("564654z");
		cv.getPersonal().setNombre("Chuck");
		cv.getPersonal().setApellidos("Norris");
		cv.getPersonal().setFechaNacimiento(LocalDate.of(1942, 10, 6));
		cv.getPersonal().getNacionalidades().add(americana);
		cv.getPersonal().getNacionalidades().add(japonesa);

		cv.save(new File("micurriculum.xml"));
	}

}
