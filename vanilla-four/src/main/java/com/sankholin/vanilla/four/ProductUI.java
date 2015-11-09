package com.sankholin.vanilla.four;

import com.sankholin.vanilla.four.view.ProductAddView;
import com.sankholin.vanilla.four.view.ProductListView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Version;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("product")
@Widgetset("com.sankholin.vanilla.four.widgetset.Main")
public class ProductUI extends UI {

    @Autowired
    private SpringViewProvider springViewProvider;

    @Override
    protected void init(VaadinRequest request) {

        Component header = buildHeader();
        Component footer = buildFooter();
        Component center = buildCenter();

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.addComponent(header);
        mainLayout.addComponent(center);
        mainLayout.addComponent(footer);
        mainLayout.setExpandRatio(center, 1f);
        setContent(mainLayout);

        Notification.show("Welcome to " + BRAND.concat(" ").concat(DESCRIPTION));
    }

    private Component buildCenter() {
        HorizontalSplitPanel center = new HorizontalSplitPanel();
        center.addStyleName("center");
        center.setSplitPosition(10, Unit.PERCENTAGE);
        center.setMinSplitPosition(10, Unit.PERCENTAGE);
        center.setMaxSplitPosition(25, Unit.PERCENTAGE);

        // Using 11.9. Navigating in an Application - https://vaadin.com/book/-/page/advanced.navigator.html
        VerticalLayout viewContainer = new VerticalLayout();
        viewContainer.setSizeFull();

        final Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(springViewProvider);
        navigator.addView(ProductListView.NAME, new ProductListView());
        navigator.addView(ProductAddView.NAME, new ProductAddView());
        navigator.navigateTo(ProductListView.NAME);

        CssLayout menu = new CssLayout();
        menu.setPrimaryStyleName(ValoTheme.MENU_ROOT);
        menu.setSizeFull();

        Button homeBtn = new Button("Home");
        homeBtn.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        homeBtn.setIcon(FontAwesome.HOME);
        homeBtn.addClickListener(event -> getPage().setLocation("index.jsp"));
        menu.addComponent(homeBtn);

        Button productBtn = new Button("Product");
        productBtn.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        productBtn.setIcon(FontAwesome.FILE);
        productBtn.addStyleName("selected");
        productBtn.addClickListener(event -> navigator.navigateTo(ProductListView.NAME));
        menu.addComponent(productBtn);

        Button addBtn = new Button("Add");
        addBtn.setPrimaryStyleName(ValoTheme.MENU_ITEM);
        addBtn.setIcon(FontAwesome.PLUS);
        addBtn.addClickListener(event -> navigator.navigateTo(ProductAddView.NAME));
        menu.addComponent(addBtn);

        navigator.addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {
                for (int i = 0; i < menu.getComponentCount(); i++) {
                    Component component = menu.getComponent(i);
                    component.removeStyleName("selected");
                    if (component.getCaption().equalsIgnoreCase(event.getViewName())) {
                        component.addStyleName("selected");
                    }
                }
            }
        });

        center.setFirstComponent(menu);
        center.setSecondComponent(viewContainer);

        return center;
    }

    private Component buildHeader() {

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addStyleName("header");
        layout.setHeight("100px");

        HorizontalLayout brandLayout = new HorizontalLayout();
        Label brand = new Label(BRAND);
        brand.addStyleName(ValoTheme.LABEL_H1);
        brand.addStyleName("brandLabel");
        Label description = new Label(DESCRIPTION);
        description.addStyleName(ValoTheme.LABEL_H2);
        brandLayout.addComponent(brand);
        brandLayout.addComponent(description);
        brandLayout.setComponentAlignment(description, Alignment.MIDDLE_LEFT);

        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Victor", FontAwesome.USER, selectedItem -> Notification.show("May be account details!"));
        menuBar.addItem("Logout", FontAwesome.SIGN_OUT, selectedItem -> Notification.show("Should logout now!"));
        menuBar.addStyleName("userMenu");

        layout.addComponent(brandLayout);
        layout.addComponent(menuBar);
        layout.setComponentAlignment(brandLayout, Alignment.MIDDLE_LEFT);
        layout.setComponentAlignment(menuBar, Alignment.MIDDLE_RIGHT);

        return layout;
    }

    private Component buildFooter() {

        VerticalLayout layout = new VerticalLayout();
        layout.addStyleName("footer");
        layout.setHeight("50px");

        HorizontalLayout copyMark = new HorizontalLayout();
        copyMark.setSpacing(true);
        Label label = new Label(BRAND.concat(" ").concat(DESCRIPTION));
        Link link = new Link("SKL Software Ltd", new ExternalResource("http://sankholin.com"));
        link.setTargetName("_blank");
        copyMark.addComponent(label);
        copyMark.addComponent(new Label("-"));
        copyMark.addComponent(link);

        HorizontalLayout powerMark = new HorizontalLayout();
        powerMark.setSpacing(true);
        Label poweredBy = new Label("Powered by Vaadin " + Version.getFullVersion()
                + ", Spring Framework, et al");
        powerMark.addComponent(poweredBy);

        layout.addComponent(copyMark);
        layout.addComponent(powerMark);

        layout.setComponentAlignment(copyMark, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(powerMark, Alignment.MIDDLE_CENTER);

        return layout;
    }

    public static final String BRAND = "V4";
    public static final String DESCRIPTION = "Enterprise Product Tracking System";
}