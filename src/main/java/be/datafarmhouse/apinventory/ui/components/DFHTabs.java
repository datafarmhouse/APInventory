package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;

import java.util.Arrays;

public class DFHTabs extends VerticalLayout {

    private VerticalLayout content;

    public DFHTabs(final DFHTab... dfhTabs) {
        this.content = new VerticalLayout();
        this.content.setSizeFull();
        Arrays.stream(dfhTabs).map(DFHTab::getContent).forEach(this.content::add);
        final Tabs tabs = new Tabs(dfhTabs);

        tabs.addSelectedChangeListener(event -> {
            event.getPreviousTab().setVisible(false);
            event.getSelectedTab().setVisible(true);
        });
        tabs.getSelectedTab().setVisible(true);

        add(tabs, content);
    }
}
