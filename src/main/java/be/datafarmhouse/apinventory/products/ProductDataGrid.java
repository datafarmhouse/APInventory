package be.datafarmhouse.apinventory.products;

import be.datafarmhouse.apinventory.ui.components.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@RequiredArgsConstructor
public class ProductDataGrid extends DataGrid<ProductData> {

    private final ProductRepository productRepository;

    @Override
    protected Class<ProductData> getEntityClass() {
        return ProductData.class;
    }

    @Override
    protected JpaRepository<ProductData, String> getEntityRepository() {
        return productRepository;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{"name"};
    }

    protected FormTabs createForm() {
        return new FormTabs(
                new FormTab(
                        "General",
                        new FormText("Code", "code", binder, true),
                        new FormText("EAN", "ean", binder, true),
                        new FormText("Name", "name", binder, true)
                ),
                new FormTab(
                        "Logistics",
                        new FormNumber("Weight (kg)", "weightInKg", binder),
                        new FormNumber("Length (cm)", "lengthInCm", binder),
                        new FormNumber("Width (cm)", "widthInCm", binder),
                        new FormNumber("Height (cm)", "heightInCm", binder)
                )
        );
    }
}

