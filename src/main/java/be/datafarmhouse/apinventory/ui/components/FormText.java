package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class FormText extends TextField {

    public FormText(final String label, final String propertyName, final Binder binder) {
        this(label, propertyName, binder, false);
    }

    public FormText(final String label, final String propertyName, final Binder binder, final boolean readOnly) {
        super(label);
        setWidthFull();
        setReadOnly(readOnly);

        binder.forField(this).bind(propertyName);
    }
}
