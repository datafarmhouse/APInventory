package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.sidenav.SideNavItem;

public class SideNavItemBuilder {

    private final SideNavItem sideNavItem;

    private SideNavItemBuilder(final String label) {
        this.sideNavItem = new SideNavItem(label);
    }


    public static SideNavItemBuilder builder(final String text) {
        return new SideNavItemBuilder(text);
    }

    public SideNavItemBuilder add(final SideNavItem... sections) {
        this.sideNavItem.addItem(sections);
        return this;
    }

    public SideNavItem build() {
        return this.sideNavItem;
    }
}
