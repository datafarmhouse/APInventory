package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;

public class FormLayoutBuilder {

    private FormLayout formLayout;

    private FormLayoutBuilder() {
        formLayout = new FormLayout();
    }

    public static FormLayoutBuilder builder() {
        return new FormLayoutBuilder();
    }

    public FormLayoutBuilder add(final Component... components) {
        formLayout.add(components);
        return this;
    }

    public FormLayoutBuilder withVisible(final boolean visible) {
        formLayout.setVisible(visible);
        return this;
    }

    public FormLayoutBuilder withWidthFull() {
        formLayout.setWidthFull();
        return this;
    }

    public FormLayoutBuilder withSizeFull() {
        formLayout.setSizeFull();
        return this;
    }

    public FormLayoutBuilder withClassName(final String className) {
        formLayout.setClassName(className);
        return this;
    }

    public FormLayout build() {
        return formLayout;
    }
}
