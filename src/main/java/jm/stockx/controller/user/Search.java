package jm.stockx.controller.user;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import jm.stockx.dto.ItemSearchDto;
import jm.stockx.http.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route("search")
public class Search extends VerticalLayout {
    @Autowired
    private SearchService searchService;

    private final TextField searchField;
    private final VerticalLayout buttonLayout;

    public Search() {
        searchField = new TextField();
        buttonLayout = new VerticalLayout();

        configure();
        add(searchField);

        searchField.addValueChangeListener(e -> updateList());
    }

    private void updateList() {
        remove(buttonLayout);
        buttonLayout.removeAll();

        String search = searchField.getValue();
        List<ItemSearchDto> searchItems = searchService.getItemSearchDtoBySearch(search);

        for (ItemSearchDto item : searchItems) {
                Button button = new Button(item.getCount() + " result found in " + item.getItemCategoryStr());
                configureButton(button);
                buttonLayout.add(button);
        }

        if (searchItems.isEmpty() && !search.isEmpty()) {
            Button button = new Button("NOTHING TO SEE HERE! TAKE A TRIP TO THE BROWSE PAGE OR SUGGEST A PRODUCT");
            configureButton(button);
            buttonLayout.add(button);
        }
        add(buttonLayout);
    }
    private void configure() {
        setSpacing(false);
        setPadding(false);
        setMargin(false);

        searchField.getStyle().set("color", "black");
        searchField.getStyle().set("background-color", "white");
        searchField.setWidthFull();
        searchField.getStyle().set("margin", "0");
        searchField.setWidthFull();
        searchField.setClearButtonVisible(true);
        searchField.setValueChangeMode(ValueChangeMode.EAGER);

        buttonLayout.setMargin(false);
        buttonLayout.setPadding(false);
        buttonLayout.setSpacing(false);

    }

    private void configureButton(Button button) {
        button.getStyle().set("color", "black");
        button.getStyle().set("background-color", "white");
        button.getStyle().set("margin", "0");
        button.getStyle().set("padding", "0");
        button.setWidthFull();
    }



}
