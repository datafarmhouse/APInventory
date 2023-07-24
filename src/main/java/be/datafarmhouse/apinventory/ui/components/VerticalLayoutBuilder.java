package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VerticalLayoutBuilder {

    private VerticalLayout verticalLayout;

    public VerticalLayoutBuilder() {
        verticalLayout = new VerticalLayout();
    }

    public VerticalLayoutBuilder add(final Component... components) {
        verticalLayout.add(components);
        return this;
    }

    public VerticalLayoutBuilder withAlignItems(final FlexComponent.Alignment alignment) {
        verticalLayout.setAlignItems(alignment);
        return this;
    }

    public VerticalLayoutBuilder withVisible(final boolean visible) {
        verticalLayout.setVisible(visible);
        return this;
    }

    public VerticalLayoutBuilder withWidthFull() {
        verticalLayout.setWidthFull();
        return this;
    }

    public VerticalLayoutBuilder withSizeFull() {
        verticalLayout.setSizeFull();
        return this;
    }

    public VerticalLayoutBuilder withSpacing(final boolean spacing) {
        verticalLayout.setSpacing(spacing);
        return this;
    }

    public VerticalLayoutBuilder withMargin(final boolean margin) {
        verticalLayout.setMargin(margin);
        return this;
    }

    public VerticalLayoutBuilder withPadding(final boolean padding) {
        verticalLayout.setPadding(padding);
        return this;
    }

    public VerticalLayoutBuilder withClassName(final String className) {
        verticalLayout.setClassName(className);
        return this;
    }

    public VerticalLayout build() {
        return verticalLayout;
    }
}
