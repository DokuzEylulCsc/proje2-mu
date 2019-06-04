package mu.Project.Views;

import mu.Project.Logger;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

class JDecimalField extends JFormattedTextField {
    // only accept decimal characters up to 6 digits
    private final static String format = "######";
    private final static NumberFormat numberFormat = new DecimalFormat("###,###");

    JDecimalField() {
        super(numberFormat);

        try {
            setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(format)));
        } catch (ParseException e) {
            Logger.getInstance().addLog(e);
        }
    }

    protected void processFocusEvent(FocusEvent e) {
        super.processFocusEvent(e);

        if (!e.isTemporary()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    selectAll();
                }
            });
        }

    }

    @Override
    public Integer getValue() {
        try {
            return Integer.valueOf((String) super.getValue());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
