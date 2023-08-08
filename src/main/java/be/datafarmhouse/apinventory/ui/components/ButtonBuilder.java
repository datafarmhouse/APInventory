package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class ButtonBuilder {

    private final Button button;

    private ButtonBuilder() {
        button = new Button();
    }

    public static ButtonBuilder builder() {
        return new ButtonBuilder();
    }

    public ButtonBuilder withIcon(final Component icon) {
        button.setIcon(icon);
        return this;
    }

    public ButtonBuilder withText(final String text) {
        button.setText(text);
        return this;
    }

    public ButtonBuilder withThemeVariants(final ButtonVariant... variants) {
        button.addThemeVariants(variants);
        return this;
    }

    public ButtonBuilder withClickListener(final ComponentEventListener<ClickEvent<Button>> listener) {
        button.addClickListener(listener);
        return this;
    }

    public Button build() {
        return button;
    }
}
