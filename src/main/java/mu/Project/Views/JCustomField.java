package mu.Project.Views;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.text.Format;

public abstract class JCustomField extends JFormattedTextField {

    public JCustomField(Format format) {
        super(format);
    }

    /**
     * Select all text when refocused.
     */
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

}
