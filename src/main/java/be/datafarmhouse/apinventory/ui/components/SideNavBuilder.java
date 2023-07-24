package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;

public class SideNavBuilder {

    private final SideNav sideNav;

    private SideNavBuilder() {
        this.sideNav = new SideNav();
    }

    public static SideNavBuilder builder() {
        return new SideNavBuilder();
    }

    public SideNavBuilder add(final SideNavItem... sections) {
        this.sideNav.addItem(sections);
        return this;
    }

    public SideNav build() {
        return this.sideNav;
    }
}
