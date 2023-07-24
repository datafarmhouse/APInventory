package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.data.binder.Binder;

import java.util.function.Function;

public class FormEntity<T> extends CustomField<T> {

    private final Function<T, String> labelGenerator;
    private final DataGrid<T> dataGrid;
    private final boolean readOnly;

    public FormEntity(final String label, final String propertyName, final Binder binder, final DataGrid<T> dataGrid, final Function<T, String> labelGenerator) {
        this(label, propertyName, binder, dataGrid, labelGenerator, false);
    }

    public FormEntity(final String label, final String propertyName, final Binder binder, final DataGrid<T> dataGrid, final Function<T, String> labelGenerator, final boolean readOnly) {
        setLabel(label);
        setWidthFull();
        setReadOnly(true);
        this.labelGenerator = labelGenerator;
        this.dataGrid = dataGrid;
        this.readOnly = readOnly;


        binder.forField(this).bind(propertyName);
    }

    @Override
    protected T generateModelValue() {
        return null;
    }

    @Override
    protected void setPresentationValue(final T value) {

    }
}
