package mu.Project.Views;

import mu.Project.Logger;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JDateField extends JCustomField {

    public final static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    JDateField() {
        super(format);

        DefaultFormatterFactory formatterFactory = null;
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
            maskFormatter.setPlaceholderCharacter('_');
            formatterFactory = new DefaultFormatterFactory(maskFormatter);
        } catch (ParseException e) {
            Logger.getInstance().addLog("Couldn't initialize date fields!");
            Logger.getInstance().addLog(e);
        }

        setFormatterFactory(formatterFactory);
    }

}
