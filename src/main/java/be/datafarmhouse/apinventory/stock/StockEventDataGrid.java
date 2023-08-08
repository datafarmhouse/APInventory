package be.datafarmhouse.apinventory.stock;

import be.datafarmhouse.apinventory.ui.components.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
@RequiredArgsConstructor
public class StockEventDataGrid extends DataGrid<StockEventData> {

    private final StockEventRepository stockEventRepository;

    @Override
    protected boolean createAllowed() {
        return false;
    }

    @Override
    protected Class<StockEventData> getEntityClass() {
        return StockEventData.class;
    }

    @Override
    protected JpaRepository<StockEventData, String> getEntityRepository() {
        return stockEventRepository;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{"product.ean", "product.name", "quantity", "event"};
    }

    protected FormTabs createForm() {
        return new FormTabs(
                new FormTab(
                        "General",
                        new FormText("Product EAN", "product.ean", binder, true),
                        new FormText("Product Name", "product.name", binder, true),
                        new FormNumber("Quantity", "quantity", binder, true),
                        new FormNumber("Event", "event", binder, true)
                )
        );
    }
}

