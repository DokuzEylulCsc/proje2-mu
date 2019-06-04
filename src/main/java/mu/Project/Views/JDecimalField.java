package mu.Project.Views;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class JDecimalField extends JCustomField {

    public final static NumberFormat numberFormat = new DecimalFormat();

    JDecimalField() {
        super(numberFormat);
    }
}
