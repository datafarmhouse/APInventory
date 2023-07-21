package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Horizontal extends HorizontalLayout {

    public Horizontal(Component... children) {
        super(children);
        setWidthFull();
    }
}
