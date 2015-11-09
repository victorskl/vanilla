package com.sankholin.vanilla.four.view;

import com.sankholin.vanilla.four.ProductUI;
import com.sankholin.vanilla.four.model.Product;
import com.sankholin.vanilla.four.service.ProductService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = ProductAddView.NAME, ui = ProductUI.class)
public class ProductAddView extends FormLayout implements View {

    public static final String NAME = "add";

    @Autowired
    private transient ProductService productService;

    @PostConstruct
    public void init() {
        UI.getCurrent().getPage().setTitle("Add Product");

        setSizeFull();
        setSpacing(true);
        addStyleName("addFormMargin");

        Product product = new Product();

        // Using 9.Binding Components to Data - https://vaadin.com/book/-/page/datamodel.itembinding.html
        BeanFieldGroup<Product> binder = new BeanFieldGroup<>(Product.class);
        binder.setItemDataSource(product);
        binder.setBuffered(true);

        addComponent(binder.buildAndBind("Name", "name"));
        addComponent(binder.buildAndBind("Price", "price"));
        addComponent(binder.buildAndBind("Stock", "stockCount"));

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        layout.addComponent(new Button("Submit", event -> {
            try {
                binder.commit();
                productService.addProduct(product);
                UI.getCurrent().getNavigator().navigateTo(ProductListView.NAME);
            } catch (FieldGroup.CommitException e) {
                //e.printStackTrace();
            }
        }));

        layout.addComponent(new Button("Reset", event -> {
            binder.discard();
            Notification.show("Discarded!");
        }));

        addComponent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        //
    }
}