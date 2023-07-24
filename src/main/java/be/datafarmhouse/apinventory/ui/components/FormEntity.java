package be.datafarmhouse.apinventory.ui.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import lombok.extern.log4j.Log4j2;

import java.util.function.Function;
import java.util.function.Supplier;

@Log4j2
public class FormEntity<T> extends CustomField<T> {

    private T value;
    private final Function<T, String> labelGenerator;
    private final TextField label;
    private final boolean readOnly;

    public FormEntity(final String label, final String propertyName, final Binder binder, final Supplier<DataGrid<T>> createGrid, final Function<T, String> labelGenerator) {
        this(label, propertyName, binder, createGrid, labelGenerator, false);
    }

    public FormEntity(final String label, final String propertyName, final Binder binder, final Supplier<DataGrid<T>> createGrid, final Function<T, String> labelGenerator, final boolean readOnly) {
        setWidthFull();
        setReadOnly(true);
        this.labelGenerator = labelGenerator;
        this.readOnly = readOnly;

        this.label = new TextField(label);
        this.label.setWidthFull();
        this.label.setReadOnly(true);

        add(
                HorizontalLayoutBuilder.builder()
                        .withSpacing(false)
                        .withAlignItems(FlexComponent.Alignment.END)
                        .add(
                                this.label,
                                new Button(
                                        VaadinIcon.SEARCH.create(),
                                        event -> {
                                            final Dialog dialog = new Dialog();
                                            final DataGrid<T> dataGrid = createGrid.get();
                                            final Button selectButton = new Button("Select", clickEvent -> {
                                                setValue(dataGrid.getValue());
                                                dialog.close();
                                                updateValue();
                                            });

                                            selectButton.setEnabled(false);

                                            dataGrid.setSelectionOnly(true);
                                            dataGrid.addValueChangeListener(selectEvent -> {
                                                selectButton.setEnabled(selectEvent.getValue() != null);
                                            });

                                            dialog.setWidthFull();
                                            dialog.setCloseOnEsc(true);
                                            dialog.setCloseOnOutsideClick(true);
                                            dialog.getFooter().add(selectButton);
                                            dialog.add(dataGrid);
                                            dialog.open();
                                        }
                                ),
                                new Button(
                                        VaadinIcon.DEL.create(),
                                        clickEvent -> {
                                            setValue(null);
                                            updateValue();
                                        }
                                )
                        ).build()
        );


        binder.forField(this).bind(propertyName);
    }

    @Override
    protected T generateModelValue() {
        return this.value;
    }

    @Override
    protected void setPresentationValue(final T value) {
        this.value = value;
    }

    @Override
    public void setValue(final T value) {
        super.setValue(value);
        this.label.setValue(value == null ? " --- " : labelGenerator.apply(value));
    }
}
