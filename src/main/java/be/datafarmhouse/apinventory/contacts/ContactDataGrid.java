package be.datafarmhouse.apinventory.contacts;

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
public class ContactDataGrid extends DataGrid<ContactData> {

    private final ContactRepository contactRepository;

    @Override
    protected Class<ContactData> getEntityClass() {
        return ContactData.class;
    }

    @Override
    protected JpaRepository<ContactData, String> getEntityRepository() {
        return contactRepository;
    }

    @Override
    protected String[] getColumns() {
        return new String[]{"email"};
    }

    protected FormTabs createForm() {
        return new FormTabs(
                new FormTab(
                        "General",
                        new FormText("First Name", "firstName", binder),
                        new FormText("Last Name", "lastName", binder),
                        new FormText("Email", "email", binder),
                        new FormText("Phone", "phone", binder)
                )
        );
    }
}
