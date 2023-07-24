package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HorizontalLayoutBuilder {

    private HorizontalLayout horizontalLayout;

    public HorizontalLayoutBuilder() {
        horizontalLayout = new HorizontalLayout();
    }

    public static HorizontalLayoutBuilder builder() {
        return new HorizontalLayoutBuilder();
    }

    public HorizontalLayoutBuilder add(final Component... components) {
        horizontalLayout.add(components);
        return this;
    }

    public HorizontalLayoutBuilder withAlignItems(final FlexComponent.Alignment alignment) {
        horizontalLayout.setAlignItems(alignment);
        return this;
    }

    public HorizontalLayoutBuilder withJustifyContentMode(final FlexComponent.JustifyContentMode justifyContentMode) {
        horizontalLayout.setJustifyContentMode(justifyContentMode);
        return this;
    }

    public HorizontalLayoutBuilder withVisible(final boolean visible) {
        horizontalLayout.setVisible(visible);
        return this;
    }

    public HorizontalLayoutBuilder withWidthFull() {
        horizontalLayout.setWidthFull();
        return this;
    }

    public HorizontalLayoutBuilder withSizeFull() {
        horizontalLayout.setSizeFull();
        return this;
    }

    public HorizontalLayoutBuilder withSpacing(final boolean spacing) {
        horizontalLayout.setSpacing(spacing);
        return this;
    }

    public HorizontalLayoutBuilder withMargin(final boolean margin) {
        horizontalLayout.setMargin(margin);
        return this;
    }

    public HorizontalLayoutBuilder withPadding(final boolean padding) {
        horizontalLayout.setPadding(padding);
        return this;
    }

    public HorizontalLayoutBuilder withClassName(final String className) {
        horizontalLayout.setClassName(className);
        return this;
    }

    public HorizontalLayout build() {
        return horizontalLayout;
    }
}
