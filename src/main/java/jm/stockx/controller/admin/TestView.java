package jm.stockx.controller.admin;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
//import jm.stockx.BrandService;
import jm.stockx.dto.BrandDto;
//import jm.stockx.entity.Brand;

@Route("brand/all")
public class TestView extends VerticalLayout {

//    private final BrandServiceDto brandService;
    final Grid<BrandDto> grid;

    public TestView(
//            BrandService brandService
    ) {
//        this.brandService = brandService;
        this.grid = new Grid<>(BrandDto.class);
        add(grid);
        listCustomers();
    }

    private void listCustomers() {
        grid.setItems(
//                brandService.getAll()
        );
    }
}
