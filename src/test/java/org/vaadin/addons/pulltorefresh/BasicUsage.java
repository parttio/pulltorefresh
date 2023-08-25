package org.vaadin.addons.pulltorefresh;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalTime;

@Route
public class BasicUsage extends VerticalLayout {
    public BasicUsage() {
        add(new Paragraph("Try with touch device and do a swipe down gesture on the scroller"));

        VerticalLayout layout = new VerticalLayout();
        for(int i = 0; i< 100; i++) {
            layout.add(new Paragraph("This is a paragraph "+i+" in scroller."));
        }
        Scroller scroller = new PullToRefreshScroller(() -> {
            layout.addComponentAsFirst(new Paragraph("Refreshed at "+ LocalTime.now()));
        });
        scroller.setContent(layout);

        scroller.setHeight("50vh");
        add(scroller);

        add(new Button("Try whole viewport refresh", e-> {
            UI.getCurrent().navigate(BodyScrollView.class);
        }));
    }
}
