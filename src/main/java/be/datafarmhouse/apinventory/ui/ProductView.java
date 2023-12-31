package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.products.ProductDataGrid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PageTitle("APInventory | Products")
@Route(value = "products", layout = ApplicationLayout.class)
public class ProductView extends Div {

    private final ProductDataGrid productDataGrid;

    @PostConstruct
    public void init() {
        add(productDataGrid);
        setSizeFull();
    }
}

