package be.datafarmhouse.apinventory.ui.components;

import be.datafarmhouse.apinventory.ui.HomeView;
import be.datafarmhouse.apinventory.ui.ProductView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class Layout extends AppLayout {

    public Layout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createNavBar());
        addToDrawer(createDrawer());
    }

    private Component createNavBar() {
        final HorizontalLayout layout = new HorizontalLayout();

        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        layout.add(new H3("APInventory"));

        return layout;
    }

    private Component createDrawer() {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.getThemeList().set("dark", true);
        layout.add(new RouterLink("Home", HomeView.class));
        {
            final Accordion accordion = new Accordion();
            accordion.setWidthFull();
            accordion.add(
                    new AccordionPanel(
                            new Horizontal(
                                    VaadinIcon.PACKAGE.create(),
                                    new Text("Inventory")
                            ),
                            new Vertical(
                                    new RouterLink("Products", ProductView.class),
                                    new RouterLink("Stock Events", ProductView.class)
                            )
                    )
            );
            accordion.add(
                    new AccordionPanel(
                            new Horizontal(
                                    VaadinIcon.OUTBOX.create(),
                                    new Text("Sales")
                            ),
                            new Vertical(
                                    new RouterLink("Sales Orders", ProductView.class)
                            )
                    )
            );
            accordion.add(
                    new AccordionPanel(
                            new Horizontal(
                                    VaadinIcon.INBOX.create(),
                                    new Text("Purchases")
                            ),
                            new Vertical(
                                    new RouterLink("Purchase Orders", ProductView.class),
                                    new RouterLink("Vendors", ProductView.class)
                            )
                    )
            );
            accordion.close();
            layout.add(accordion);
        }

        return layout;
    }
}
