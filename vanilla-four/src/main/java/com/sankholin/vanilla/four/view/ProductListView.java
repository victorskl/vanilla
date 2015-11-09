package com.sankholin.vanilla.four.view;

import com.sankholin.vanilla.four.ProductUI;
import com.sankholin.vanilla.four.model.Product;
import com.sankholin.vanilla.four.service.ProductService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = ProductListView.NAME, ui = ProductUI.class)
public class ProductListView extends Table implements View {

    public static final String NAME = "product";

    @Autowired
    private transient ProductService productService;

    @PostConstruct
    public void init() {
        UI.getCurrent().getPage().setTitle("Product List");

        // Set table data source
        // using 9.Binding Components to Data - https://vaadin.com/book/-/page/datamodel.container.html
        BeanItemContainer<Product> beanItemContainer = new BeanItemContainer<>(Product.class, productService.getAllProducts());
        setContainerDataSource(beanItemContainer);

        setSizeFull();
        setRowHeaderMode(Table.RowHeaderMode.INDEX);

        setColumnHeaders("ID", "Name", "Price", "Stock Count");
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //
    }
}