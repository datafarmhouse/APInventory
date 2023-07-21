package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.product.ProductData;
import be.datafarmhouse.apinventory.product.ProductRepository;
import be.datafarmhouse.apinventory.ui.components.*;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("APInventory | Products")
@Route(value = "products", layout = Layout.class)
public class ProductView extends AbstractCRUD<ProductData> {

    public ProductView(final ProductRepository productRepository) {
        super(productRepository, ProductData.class);
    }

    protected Component createForm() {
        return new DFHTabs(
                new DFHTab(
                        "General",
                        new FormText("Code", "code", binder, true),
                        new FormText("EAN", "ean", binder, true),
                        new FormText("Name", "name", binder, true)
                ),
                new DFHTab(
                        "Logistics",
                        new FormNumber("Weight (kg)", "weightInKg", binder),
                        new FormNumber("Length (cm)", "lengthInCm", binder),
                        new FormNumber("Width (cm)", "widthInCm", binder),
                        new FormNumber("Height (cm)", "heightInCm", binder)
                )
        );
    }
}

