package org.vaadin.addons.pulltorefresh;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;

import java.time.LocalTime;

@Route
public class BodyScrollView extends PullToRefreshRootLayout {

    PullToRefreshListener listener;

    public BodyScrollView() {
        add(new Paragraph("Try with touch device and do a swipe down gesture on the scroller"));

        for(int i = 0; i< 100; i++) {
            add(new Paragraph("This is a paragraph "+i+" in scroller."));
        }

        setListener(() -> {
            addComponentAsFirst(new Paragraph("Refreshed at "+ LocalTime.now()));
        });

    }
}
