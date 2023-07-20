package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.ui.components.Layout;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("APInventory")
@Route(value = "", layout = Layout.class)
public class HomeView extends Div {

    public HomeView() {
        add(new Html("<label>Hello there.</label>"));
    }
}

