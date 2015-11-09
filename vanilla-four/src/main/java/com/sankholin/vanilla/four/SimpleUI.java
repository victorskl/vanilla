package com.sankholin.vanilla.four;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * NOTES:
 * a. Using default 'valo' theme. Potentially we can remove custom themes directory all together
 * if no theme customization is required. i.e. rm -rf webapp/VAADIN/themes
 *
 * b. Similarly if we do not need widgetset customization, and use 'vaadin-client-compiled'
 * we can also remove @Widgetset("com.sankholin.vanilla.four.widgetset.Main") and widgetset
 * descriptor 'com.sankholin.vanilla.four.widgetset.Main.gwt.xml' as well.
 *
 * This will simplify dev even more if we are just ok with Vaadin default look and feel,
 * and built-in widgetset. i.e. not require to use any 3rd party addon widgetset.
 */
@Theme("valo")
@Widgetset("com.sankholin.vanilla.four.widgetset.Main")
public class SimpleUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);

    }
}