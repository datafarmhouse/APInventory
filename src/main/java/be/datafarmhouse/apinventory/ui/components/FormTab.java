package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;

public class FormTab extends Tab {

    private VerticalLayout content;

    public FormTab(final String label, final Component... children) {
        super(label);
        this.content = new VerticalLayout(children);
        this.content.setSizeFull();
        setVisible(false);
    }

    public Component getContent() {
        return content;
    }

    @Override
    public void setVisible(boolean visible) {
        this.content.setVisible(visible);
    }
}
