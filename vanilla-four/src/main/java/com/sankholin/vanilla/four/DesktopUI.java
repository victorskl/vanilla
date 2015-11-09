package com.sankholin.vanilla.four;

import com.sankholin.vanilla.four.model.Product;
import com.sankholin.vanilla.four.service.ProductService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI(path = "desktop")
@Theme("product")
@Widgetset("com.sankholin.vanilla.four.widgetset.Main")
@Title("Product Desktop - Single-page Application")
public class DesktopUI extends UI {

    @Autowired
    private transient ProductService productService;

    private BeanItemContainer<Product> beanItemContainer;

    @Override
    protected void init(VaadinRequest request) {

        Table table = new Table();
        beanItemContainer = new BeanItemContainer<>(Product.class, productService.getAllProducts());
        table.setContainerDataSource(beanItemContainer);
        table.setRowHeaderMode(Table.RowHeaderMode.INDEX);
        table.setColumnHeaders("ID", "Name", "Price", "Stock Count");

        Button button = new Button("Add");
        button.addClickListener(new AddButtonClickListener());

        CustomLayout customLayout = new CustomLayout("desktop");
        customLayout.setSizeFull();
        customLayout.addComponent(table, "product-table");
        customLayout.addComponent(button, "add-product");
        setContent(customLayout);

        Notification.show("Welcome to " + ProductUI.BRAND.concat(" ").concat(ProductUI.DESCRIPTION));
    }

    private void reloadTableContainerDataSource() {
        beanItemContainer.removeAllItems();
        beanItemContainer.addAll(productService.getAllProducts());
    }

    class AddButtonClickListener implements Button.ClickListener {

        @Override
        public void buttonClick(Button.ClickEvent clickEvent) {

            Window subWindow = new Window("Add Product");
            subWindow.setWidth("330px");
            subWindow.setHeight("250px");
            subWindow.center();
            subWindow.setModal(true);

            FormLayout subContent = new FormLayout();
            subContent.setMargin(true);

            Product product = new Product();
            BeanFieldGroup<Product> binder = new BeanFieldGroup<>(Product.class);
            binder.setItemDataSource(product);
            binder.setBuffered(true);

            subContent.addComponent(binder.buildAndBind("Name", "name"));
            subContent.addComponent(binder.buildAndBind("Price", "price"));
            subContent.addComponent(binder.buildAndBind("Stock", "stockCount"));
            subContent.addComponent(new Button("Submit", event -> {
                try {
                    binder.commit();
                    productService.addProduct(product);
                    //beanItemContainer.addItem(product);
                    reloadTableContainerDataSource();
                    subWindow.close();
                    Notification.show("Successfully added!");
                } catch (FieldGroup.CommitException e) {
                    //e.printStackTrace();
                }
            }));

            subWindow.setContent(subContent);
            addWindow(subWindow);
        }
    }
}