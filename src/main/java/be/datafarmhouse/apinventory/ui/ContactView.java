package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.contacts.ContactDataGrid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PageTitle("APInventory | Contacts")
@Route(value = "contacts", layout = ApplicationLayout.class)
public class ContactView extends Div {

    private final ContactDataGrid contactDataGrid;

    @PostConstruct
    public void init() {
        add(contactDataGrid);
        setSizeFull();
    }
}

