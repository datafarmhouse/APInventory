package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractCRUD<T extends CRUDEntity> extends Div {

    protected final JpaRepository<T, String> repository;
    protected final Class<T> entityClass;

    protected T selection;
    protected Grid<T> grid;
    protected VerticalLayout rightLayout;
    protected Binder<T> binder;
    protected Button createButton;
    protected Button saveButton;
    protected DataProvider<T, ?> gridData;

    public AbstractCRUD(final JpaRepository<T, String> repository, final Class<T> entityClass) {
        this.repository = repository;
        this.entityClass = entityClass;
        initView();
        loadData();
    }

    protected abstract Component createForm();

    private void initView() {
        binder = new Binder<>(entityClass);
        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        grid = new Grid<>(entityClass);
        grid.setHeight(75, Unit.VH);
        grid.setColumns("code");
        grid.asSingleSelect().addValueChangeListener(event -> setSelection(event.getValue()));

        createButton = new Button("ADD", VaadinIcon.FILE_ADD.create());
        createButton.addClickListener(this::onCreateEvent);

        final VerticalLayout leftLayout = new VerticalLayout();
        leftLayout.setSizeFull();
        leftLayout.add(new HorizontalLayout(createButton));
        leftLayout.add(grid);

        rightLayout = new VerticalLayout();
        rightLayout.setVisible(false);
        rightLayout.setSizeFull();
        rightLayout.add(createButtonPanel(), createForm());

        splitLayout.addToPrimary(leftLayout);
        splitLayout.addToSecondary(rightLayout);
        splitLayout.setSplitterPosition(50);

        add(splitLayout);
    }

    private void loadData() {
        gridData = DataProvider.fromCallbacks(
                // First callback fetches items based on the requested range
                query -> repository.findAll(
                        PageRequest.of(query.getOffset() / query.getLimit(), query.getLimit())
                ).stream(),
                // Second callback fetches the total count of items
                query -> Math.toIntExact(repository.count())
        );
        grid.setDataProvider(gridData);
    }

    private void setSelection(final T template) {
        if (template != null) {
            rightLayout.setVisible(true);
            selection = template;
            binder.setBean(template);
        } else {
            rightLayout.setVisible(false);
            binder.setBean(null);
            selection = null;
            grid.deselectAll();
        }
    }

    private Component createButtonPanel() {

        saveButton = new Button("SAVE", VaadinIcon.FILE.create());
        saveButton.addClickListener(event -> {
            if (selection.getCode() == null) {
                repository.save(selection);
                setSelection(null);
                gridData.refreshAll();
            } else {
                setSelection(repository.save(selection));
            }
        });

        final Button deleteButton = new Button("DELETE", VaadinIcon.FILE_REMOVE.create());
        deleteButton.addClickListener(event -> {
            repository.delete(selection);
            setSelection(null);
            gridData.refreshAll();
        });

        return new VerticalLayout(new HorizontalLayout(saveButton, deleteButton));
    }

    @SneakyThrows
    private void onCreateEvent(final ClickEvent<Button> event) {
        setSelection(entityClass.getDeclaredConstructor().newInstance());
    }
}

