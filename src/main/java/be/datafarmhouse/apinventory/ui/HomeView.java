package be.datafarmhouse.apinventory.ui;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("APInventory | Home")
@Route(value = "", layout = ApplicationLayout.class)
public class HomeView extends Div {

    public HomeView() {
        add(new H1("Hello there."));
    }
}

