package be.datafarmhouse.apinventory.ui;

import be.datafarmhouse.apinventory.product.ProductData;
import be.datafarmhouse.apinventory.product.ProductRepository;
import be.datafarmhouse.apinventory.ui.components.AbstractCRUD;
import be.datafarmhouse.apinventory.ui.components.Layout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("APInventory | Products")
@Route(value = "products", layout = Layout.class)
public class ProductView extends AbstractCRUD<ProductData> {

    public ProductView(final ProductRepository productRepository) {
        super(productRepository, ProductData.class);
    }

    protected VerticalLayout createForm() {
        final TextField codeField = new TextField("Code");
        codeField.setWidthFull();
        binder.forField(codeField).bind(ProductData::getCode, ProductData::setCode);
        final TextField nameField = new TextField("Name");
        nameField.setWidthFull();
        binder.forField(nameField).bind(ProductData::getName, ProductData::setName);
        final TextArea contentField = new TextArea("Content");
        contentField.setWidthFull();
        contentField.setHeight("500px");
        binder.forField(contentField).bind(ProductData::getDescription, ProductData::setDescription);


        VerticalLayout tab1Content = new VerticalLayout(
                codeField, nameField
        );
        tab1Content.setSizeFull();
        tab1Content.setPadding(true);
        tab1Content.setSpacing(true);
        HorizontalLayout tab2Content = new HorizontalLayout(contentField);
        tab2Content.setVisible(false);
        tab2Content.setSizeFull();


        final Tab tab1 = new Tab();
        final Tab tab2 = new Tab();
        tab1.setLabel("General");
        tab2.setLabel("Content");
        final Tabs tabs = new Tabs(tab1, tab2);

        tabs.addSelectedChangeListener(event -> {
            final Tab tab = event.getSelectedTab();
            tab1Content.setVisible(false);
            tab2Content.setVisible(false);
            if (tab == tab1) {
                tab1Content.setVisible(true);
            } else if (tab == tab2) {
                tab2Content.setVisible(true);
            }
        });

        final VerticalLayout tabsContent = new VerticalLayout(tab1Content, tab2Content);
        tabsContent.setPadding(false);
        tabsContent.setSpacing(false);

        return new VerticalLayout(tabs, tabsContent);
    }
}

