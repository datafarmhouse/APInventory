package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.ui.components.HorizontalLayoutBuilder;
import be.datafarmhouse.apinventory.ui.components.SideNavBuilder;
import be.datafarmhouse.apinventory.ui.components.SideNavItemBuilder;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.sidenav.SideNavItem;

public class ApplicationLayout extends AppLayout {

    public ApplicationLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(createNavBar());
        addToDrawer(createDrawer());
    }

    private Component createNavBar() {
        return new HorizontalLayoutBuilder()
                .withWidthFull().withSpacing(false)
                .withAlignItems(FlexComponent.Alignment.CENTER)
                .add(new DrawerToggle())
                .add(new H3("APInventory"))
                .build();
    }

    private Component createDrawer() {
        return SideNavBuilder.builder()
                .add(
                        new SideNavItem("Home", HomeView.class),
                        SideNavItemBuilder.builder("Inventory").add(
                                new SideNavItem("Products", ProductView.class, VaadinIcon.PACKAGE.create()),
                                new SideNavItem("Stock Events", ProductView.class)
                        ).build(),
                        SideNavItemBuilder.builder("Sales").add(
                                new SideNavItem("Sales Orders", ProductView.class, VaadinIcon.INBOX.create())
                        ).build(),
                        SideNavItemBuilder.builder("Purchases").add(
                                new SideNavItem("Purchase Orders", ProductView.class, VaadinIcon.OUTBOX.create()),
                                new SideNavItem("Vendors", VendorView.class),
                                new SideNavItem("Contacts", ContactView.class)
                        ).build()
                )
                .build();
    }
}
