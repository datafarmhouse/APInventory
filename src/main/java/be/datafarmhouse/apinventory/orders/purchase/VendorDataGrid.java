package be.datafarmhouse.apinventory.orders.purchase;

import be.datafarmhouse.apinventory.ui.components.DataGrid;
import be.datafarmhouse.apinventory.ui.components.FormTab;
import be.datafarmhouse.apinventory.ui.components.FormTabs;
import be.datafarmhouse.apinventory.ui.components.FormText;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class VendorDataGrid extends DataGrid<VendorData> {

    private final VendorRepository vendorRepository;

    @Override
    protected Class<VendorData> getEntityClass() {
        return VendorData.class;
    }

    @Override
    protected JpaRepository<VendorData, String> getEntityRepository() {
        return vendorRepository;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{"name"};
    }

    protected FormTabs createForm() {
        return new FormTabs(
                new FormTab(
                        "General",
                        new FormText("Name", "name", binder),
                        new FormText("Email", "email", binder),
                        new FormText("Phone", "phone", binder)
                ),
                new FormTab(
                        "Company",
                        new FormText("VAT", "vatNumber", binder),
                        new FormText("Bank IBAN", "bankAccount", binder)
                ),
                new FormTab(
                        "Address",
                        new FormText("Line1", "address.line1", binder),
                        new FormText("Line2", "address.line2", binder),
                        new FormText("City", "address.city", binder),
                        new FormText("Postal Code", "address.postalCode", binder),
                        new FormText("Country", "address.country", binder)
                ),
                new FormTab(
                        "Contact"//,
                        //new FormEntity("Contact Person", "contactPerson", binder)
                )
        );
    }
}

