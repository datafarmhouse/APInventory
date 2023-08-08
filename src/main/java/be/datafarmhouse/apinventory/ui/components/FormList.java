package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.customfield.CustomField;

public class FormList<T> extends CustomField<T> {

    private T value;

    @Override
    protected T generateModelValue() {
        return null;
    }

    @Override
    protected void setPresentationValue(T t) {

    }
}
