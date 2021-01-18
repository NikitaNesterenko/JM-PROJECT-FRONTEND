package jm.stockx.components.purchase;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import jm.stockx.dto.ItemInfoDtoDecimal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
@Setter
public class InfoProductPage extends VerticalLayout {
    //@Autowired
    ItemInfoDtoDecimal item;

    private HorizontalLayout headPage = new HorizontalLayout();
    private HorizontalLayout namePage = new HorizontalLayout();
    private HorizontalLayout menuPage = new HorizontalLayout();
    private HorizontalLayout bodyPage = new HorizontalLayout();
    private HorizontalLayout infoProductPage = new HorizontalLayout();
    private HorizontalLayout graphProductPage = new HorizontalLayout();
    private HorizontalLayout compilationModelProductPage = new HorizontalLayout();

    private HorizontalLayout picturePage = new HorizontalLayout();

    private Div sizeMenuDiv = new Div();
    private Div currentPrice = new Div();
    private Div lovestPriceDiv = new Div();
    private Div highestPriceDiv = new Div();
    private Div productPictureDiv = new Div();
    private Div infoProductDiv1 = new Div();
    private Div infoProductDiv2 = new Div();
    private Div graphProductDiv1 = new Div();
    private Div graphProductDiv2 = new Div();

    private Div compilationProductDiv1 = new Div();
    private Div compilationProductDiv2 = new Div();
    private Div compilationProductDiv3 = new Div();
    private Div compilationProductDiv4 = new Div();
    private Div compilationProductDiv5 = new Div();


    private Div nameProductDiv = new Div();

    public InfoProductPage() {
    }

    public InfoProductPage(ItemInfoDtoDecimal item) {
        this.item = item;
        initProductInfoPage();
    }

    private void configureCompilationProductDiv1() {
        H3 text = new H3();
        text.setText("compilationProductDiv_1");
        compilationProductDiv1.getStyle().set("font-size", "70px");
        compilationProductDiv1.getStyle().set("width", "30vh");
        compilationProductDiv1.getStyle().set("margin", "0 auto");
        compilationProductDiv1.getStyle().set("padding", "0 0 0");
        compilationProductDiv1.getStyle().set("border", "6px dotted DarkOrange");
        compilationProductDiv1.add(text);

    }

    private void configureCompilationProductDiv2() {
        H3 text = new H3();
        text.setText("compilationProductDiv_2");
        compilationProductDiv2.getStyle().set("font-size", "70px");
        compilationProductDiv2.getStyle().set("width", "30vh");
        compilationProductDiv2.getStyle().set("margin", "0 auto");
        compilationProductDiv2.getStyle().set("padding", "0 0 0");
        compilationProductDiv2.getStyle().set("border", "6px dotted DarkOrange");
        compilationProductDiv2.add(text);
    }

    private void configureCompilationProductDiv3() {
        H3 text = new H3();
        text.setText("compilationProductDiv_3");
        compilationProductDiv3.getStyle().set("font-size", "70px");
        compilationProductDiv3.getStyle().set("width", "30vh");
        compilationProductDiv3.getStyle().set("margin", "0 auto");
        compilationProductDiv3.getStyle().set("padding", "0 0 0");
        compilationProductDiv3.getStyle().set("border", "6px dotted DarkOrange");
        compilationProductDiv3.add(text);
    }

    private void configureCompilationProductDiv4() {
        H3 text = new H3();
        text.setText("compilationProductDiv_4");
        compilationProductDiv4.getStyle().set("font-size", "70px");
        compilationProductDiv4.getStyle().set("width", "30vh");
        compilationProductDiv4.getStyle().set("margin", "0 auto");
        compilationProductDiv4.getStyle().set("padding", "0 0 0");
        compilationProductDiv4.getStyle().set("border", "6px dotted DarkOrange");
        compilationProductDiv4.add(text);
    }

    private void configureCompilationProductDiv5() {
        H3 text = new H3();
        text.setText("compilationProductDiv_5");
        compilationProductDiv5.getStyle().set("font-size", "70px");
        compilationProductDiv5.getStyle().set("width", "30vh");
        compilationProductDiv5.getStyle().set("margin", "0 auto");
        compilationProductDiv5.getStyle().set("padding", "0 0 0");
        compilationProductDiv5.getStyle().set("border", "6px dotted DarkOrange");
        compilationProductDiv5.add(text);
    }

    private void configureNewsPicture() {
        Image firstNewsPic = new Image("product/retro-se.jpg", "black-white-nike");
        firstNewsPic.getStyle().set("margin", "0 0 0 0");

        productPictureDiv.getStyle().set("font-size", "70px");
        productPictureDiv.getStyle().set("width", "100vh");
        productPictureDiv.getStyle().set("margin", "0 auto");
        productPictureDiv.getStyle().set("padding", "0 0 0");
        productPictureDiv.getStyle().set("border", "6px dotted DarkOrange");
        productPictureDiv.add(firstNewsPic);
        picturePage.add(productPictureDiv);
    }


    private void configureGraphProductDive_1() {
        H3 text = new H3();
        text.setText("Граффик");
        graphProductDiv1.getStyle().set("font-size", "70px");
        graphProductDiv1.getStyle().set("width", "100vh");
        graphProductDiv1.getStyle().set("hight", "70px");
        graphProductDiv1.getStyle().set("margin", "0 auto");
        graphProductDiv1.getStyle().set("padding", "0 0 0");
        graphProductDiv1.getStyle().set("border", "6px dotted DarkOrange");
        graphProductDiv1.add(text);
    }

    private void configureGraphProductDive_2() {
        H3 text = new H3();
        text.setText("graphProductDiv_2");
        graphProductDiv2.getStyle().set("font-size", "70px");
        graphProductDiv2.getStyle().set("width", "50vh");
        graphProductDiv2.getStyle().set("margin", "0 auto");
        graphProductDiv2.getStyle().set("padding", "0 0 0");
        graphProductDiv2.getStyle().set("border", "6px dotted DarkOrange");
        graphProductDiv2.add(text);
    }


    private void configureInfoProductDive_1() {
        H3 text = new H3();
        text.setText(item.getName());
        infoProductDiv1.getStyle().set("font-size", "70px");
        infoProductDiv1.getStyle().set("width", "50vh");
        infoProductDiv1.getStyle().set("hight", "70px");
        infoProductDiv1.getStyle().set("margin", "0 auto");
        infoProductDiv1.getStyle().set("padding", "0 0 0");
        infoProductDiv1.getStyle().set("border", "6px dotted DarkOrange");
        infoProductDiv1.add(text);
    }

    private void configureInfoProductDive_2() {
        H3 text = new H3();
        text.setText("infoProductDiv_2");
        infoProductDiv2.getStyle().set("font-size", "70px");
        infoProductDiv2.getStyle().set("width", "100vh");
        infoProductDiv2.getStyle().set("margin", "0 auto");
        infoProductDiv2.getStyle().set("padding", "0 0 0");
        infoProductDiv2.getStyle().set("border", "6px dotted DarkOrange");
        infoProductDiv2.add(text);
    }

    private void configureProductDiv() {
        H3 text = new H3();
        text.setText(item.getName());
        nameProductDiv.getStyle().set("font-size", "70px");
        nameProductDiv.getStyle().set("width", "100vh");
        nameProductDiv.getStyle().set("margin", "0 auto");
        nameProductDiv.getStyle().set("padding", "0 0 0");
        nameProductDiv.getStyle().set("border", "6px dotted DarkOrange");
        nameProductDiv.add(text);
    }

    public void configureSizeMenu() {
        Select<String> valueSelect = new Select<>();
        valueSelect.setItems("40", "41", "42");
        valueSelect.setValue(item.getSize().toString());
        valueSelect.getStyle().set("width", "25vh");
        sizeMenuDiv.add(valueSelect);
    }

    public void configureCurrentPrice() {
        H3 text = new H3();
        text.setText(item.getPrice().toString());
        currentPrice.getStyle().set("font-size", "70px");
        currentPrice.getStyle().set("width", "25vh");
        currentPrice.getStyle().set("margin", "0 auto");
        currentPrice.getStyle().set("padding", "0 0 0");
        currentPrice.getStyle().set("border", "6px dotted DarkOrange");
        currentPrice.add(text);
    }

    public void configureLovestPrice() {
        H3 text = new H3();
        text.setText(item.getLowestAsk().toString());
        lovestPriceDiv.getStyle().set("font-size", "70px");
        lovestPriceDiv.getStyle().set("width", "25vh");
        lovestPriceDiv.getStyle().set("margin", "0 auto");
        lovestPriceDiv.getStyle().set("padding", "0 0 0");
        lovestPriceDiv.getStyle().set("border", "6px dotted DarkOrange");
        lovestPriceDiv.add(text);


    }

    public void configureHighestPriceDiv() {
        H3 text = new H3();
        text.setText(item.getHighestBid().toString());
        highestPriceDiv.getStyle().set("font-size", "70px");
        highestPriceDiv.getStyle().set("width", "25vh");
        highestPriceDiv.getStyle().set("margin", "0 auto");
        highestPriceDiv.getStyle().set("padding", "0 0 0");
        highestPriceDiv.getStyle().set("border", "6px dotted DarkOrange");
        highestPriceDiv.add(text);
    }

    private void configureMenuPage() {
        configureSizeMenu();
        configureCurrentPrice();
        configureLovestPrice();
        configureHighestPriceDiv();
        menuPage.add(sizeMenuDiv, currentPrice, lovestPriceDiv, highestPriceDiv);
    }

    private void configureInfoProductPage() {
        configureInfoProductDive_1();
        configureInfoProductDive_2();
        infoProductPage.add(infoProductDiv1, infoProductDiv2);
    }

    private void configureGraphProductPage() {
        configureGraphProductDive_1();
        configureGraphProductDive_2();
        graphProductPage.add(graphProductDiv1, graphProductDiv2);
    }

    private void configureСompilationModelProductPage() {
        configureCompilationProductDiv1();
        configureCompilationProductDiv2();
        configureCompilationProductDiv3();
        configureCompilationProductDiv4();
        configureCompilationProductDiv5();
        compilationModelProductPage.add(compilationProductDiv1, compilationProductDiv2, compilationProductDiv3, compilationProductDiv4, compilationProductDiv5);
    }


    private void initProductInfoPage() {
        // headPage.setWidthFull();
        menuPage.setWidthFull();
        namePage.setWidthFull();
        picturePage.setWidthFull();
        graphProductPage.setWidthFull();
        productPictureDiv.setWidthFull();
        infoProductPage.setWidthFull();
        compilationModelProductPage.setWidthFull();
        configureProductDiv();
        configureMenuPage();
        // headPage.add(navPanel);
        namePage.add(nameProductDiv);
        configureNewsPicture();
        configureInfoProductPage();
        configureСompilationModelProductPage();
        configureGraphProductPage();
        // add(headPage, namePage, menuPage, picturePage, infoProductPage, compilationModelProductPage, graphProductPage);
        add(namePage, menuPage, picturePage, infoProductPage, compilationModelProductPage, graphProductPage);
    }

}
