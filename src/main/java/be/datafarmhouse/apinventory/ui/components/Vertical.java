package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Vertical extends VerticalLayout {

    public Vertical(Component... children) {
        super(children);
        setWidthFull();
    }
}
