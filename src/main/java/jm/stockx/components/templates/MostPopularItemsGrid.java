package jm.stockx.components.templates;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.List;

public class MostPopularItemsGrid extends Div {
    private HorizontalLayout headGrid = new HorizontalLayout();
    private HorizontalLayout bodyGrid = new HorizontalLayout();
    private Paragraph gridName = new Paragraph("Most Popular");
    private Paragraph linkName = new Paragraph("See All");
    private Paragraph popupText = new Paragraph("The 'Most Popular' products are a curated collection of our best selling items.");


    public MostPopularItemsGrid(List<ProductTile> popularItems) {
        configureHeadGrid();
        configureBodyGrid(popularItems);
        add(headGrid);
        add(bodyGrid);
    }

    private void initGrid() {
    }

    private void configureHeadGrid() {
        headGrid.setMargin(true);
        headGrid.setPadding(true);
        headGrid.setAlignItems(FlexComponent.Alignment.END);

        configureGridName();
        headGrid.add(gridName);

        configureLinkName();
        Anchor linkSeeAll = new Anchor("#");
        linkSeeAll.getStyle().set("text-decoration", "none");
        linkSeeAll.add(linkName);
        headGrid.add(linkSeeAll);
    }

    private void configureBodyGrid(List<ProductTile> popularItems) {

    }
    private void configureGridName() {
        gridName.getStyle().set("font-size", "18pt");
        gridName.getStyle().set("font-weight", "bold");
        gridName.getStyle().set("font-family", "CALIBRI");
        gridName.getStyle().set("line-height", "0.7em");
    }

    private void configureLinkName() {
        linkName.getStyle().set("font-size", "14pt");
        linkName.getStyle().set("color", "#08a05c");
        linkName.getStyle().set("font-weight", "bold");
        linkName.getStyle().set("font-family", "CALIBRI");
        linkName.getStyle().set("line-height", "0.9em");
    }

    private void configurePopupText() {
        popupText.getStyle().set("font-size", "18pt");
        popupText.getStyle().set("font-weight", "bold");
        popupText.getStyle().set("font-family", "CALIBRI");
        popupText.getStyle().set("line-height", "0.7em");
    }
}
