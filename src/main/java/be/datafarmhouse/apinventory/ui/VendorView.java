package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.orders.purchase.VendorDataGrid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PageTitle("APInventory | Vendors")
@Route(value = "vendors", layout = ApplicationLayout.class)
public class VendorView extends Div {

    private final VendorDataGrid vendorDataGrid;

    @PostConstruct
    public void init() {
        add(vendorDataGrid);
        setSizeFull();
    }
}

