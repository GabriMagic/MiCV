package dad.micv.main;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public String marshal(LocalDate value) throws Exception {
		return value.toString();
	}

	@Override
	public LocalDate unmarshal(String Localdate) throws Exception {
		return LocalDate.parse(Localdate);
	}

}
