package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.stock.StockEventDataGrid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PageTitle("APInventory | Stock Events")
@Route(value = "stock-events", layout = ApplicationLayout.class)
public class StockEventView extends Div {

    private final StockEventDataGrid stockEventDataGrid;

    @PostConstruct
    public void init() {
        add(stockEventDataGrid);
        setSizeFull();
    }
}

