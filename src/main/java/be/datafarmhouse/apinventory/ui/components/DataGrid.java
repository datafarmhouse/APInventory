package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

@Log4j2
public abstract class DataGrid<T> extends CustomField<T> {

    protected T value;
    protected Grid<T> grid;
    protected VerticalLayout detailView;
    protected Binder<T> binder;
    protected Button saveButton;
    protected DataProvider<T, ?> gridData;
    protected Page<T> dataPage;
    protected boolean selectionOnly = false;
    protected int pageSize = 10;
    protected int page = 0;

    public DataGrid() {
        initView();
        loadData();
    }


    protected abstract Class<T> getEntityClass();

    protected abstract JpaRepository<T, String> getEntityRepository();

    protected String[] getColumns() {
        return new String[]{"code"};
    }

    protected abstract Component createForm();

    public void setSelectionOnly(final boolean selectionOnly) {
        this.selectionOnly = selectionOnly;
        log.info("selectionOnly: {}", selectionOnly);
    }

    private void initView() {
        setSizeFull();
        binder = new Binder<>(getEntityClass());
        final SplitLayout mainLayout = new SplitLayout();
        mainLayout.setSizeFull();
        mainLayout.setSplitterPosition(50);

        grid = new Grid<>(getEntityClass());
        grid.setColumns(getColumns());
        grid.asSingleSelect().addValueChangeListener(event -> setSelection(event.getValue()));

        final Button createButton = new Button(VaadinIcon.FILE_ADD.create(), this::onCreateEvent);
        final Button refreshButton = new Button(VaadinIcon.REFRESH.create(), event -> gridData.refreshAll());

        Button prevButton = new Button(VaadinIcon.CHEVRON_LEFT.create(), event -> {
            if (dataPage.hasPrevious()) {
                dataPage = getEntityRepository().findAll(dataPage.previousPageable());
                grid.setItems(dataPage.getContent());
            }
        });
        prevButton.setEnabled(dataPage != null && dataPage.hasPrevious());
        prevButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button nextButton = new Button(VaadinIcon.CHEVRON_RIGHT.create(), event -> {
            if (dataPage.hasNext()) {
                dataPage = getEntityRepository().findAll(dataPage.nextPageable());
                grid.setItems(dataPage.getContent());
            }
        });
        nextButton.setEnabled(dataPage != null && dataPage.hasNext());
        nextButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // primary
        mainLayout.addToPrimary(
                new VerticalLayoutBuilder()
                        .withSizeFull()
                        .add(
                                new H2(getEntityClass().getSimpleName()),
                                HorizontalLayoutBuilder.builder()
                                        .withWidthFull()
                                        .withJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN)
                                        .add(
                                                HorizontalLayoutBuilder.builder().add(
                                                        refreshButton, createButton
                                                ).build()
                                        )
                                        .add(
                                                HorizontalLayoutBuilder.builder().add(
                                                        prevButton, nextButton
                                                ).build()
                                        )
                                        .build(),
                                grid
                        )
                        .build()
        );

        mainLayout.addToSecondary(this.detailView = new VerticalLayoutBuilder().withSizeFull().withVisible(false).add(createButtonPanel(), createForm()).build());

        add(mainLayout);
    }

    private void loadData() {
        gridData = DataProvider.fromCallbacks(
                // First callback fetches items based on the requested range
                query -> getEntityRepository().findAll(PageRequest.of(query.getOffset() / query.getLimit(), query.getLimit())).stream(),
                // Second callback fetches the total count of items
                query -> Math.toIntExact(getEntityRepository().count()));
        grid.setDataProvider(gridData);
    }

    public void setSelection(final T value) {
        log.info("selectionOnly: {}", selectionOnly);
        detailView.setVisible(!selectionOnly && value != null);
        this.value = value;
        binder.setBean(value);

        if (value == null) {
            grid.deselectAll();
        }

        // notify listeners
        updateValue();
    }

    @Override
    public T getValue() {
        log.info("value: {}", value);
        return value;
    }

    private Component createButtonPanel() {

        saveButton = new Button("SAVE", VaadinIcon.FILE.create());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.addClickListener(event -> {
            log.info("saveButton clicked {}", value);
            setSelection(getEntityRepository().save(value));
            gridData.refreshAll();
        });

        final Button deleteButton = new Button("DELETE", VaadinIcon.FILE_REMOVE.create());
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        deleteButton.addClickListener(event -> {
            getEntityRepository().delete(value);
            setSelection(null);
            gridData.refreshAll();
        });

        return new HorizontalLayoutBuilder().add(saveButton, deleteButton).build();
    }

    @SneakyThrows
    private void onCreateEvent(final ClickEvent<Button> event) {
        setSelection(getEntityClass().getDeclaredConstructor().newInstance());
    }

    @Override
    protected T generateModelValue() {
        return this.value;
    }

    @Override
    protected void setPresentationValue(final T value) {
        this.value = value;
    }
}