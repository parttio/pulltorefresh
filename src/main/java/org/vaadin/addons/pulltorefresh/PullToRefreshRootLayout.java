package org.vaadin.addons.pulltorefresh;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@JavaScript("https://unpkg.com/pulltorefreshjs@0.1.22/dist/index.umd.js")
public class PullToRefreshRootLayout extends VerticalLayout {

    PullToRefreshListener listener;

    public PullToRefreshRootLayout() {
        getElement().executeJs("""
            var el = this;
            PullToRefresh.init({
                onRefresh: function() {
                    el.$server.refreshCompleted();
                }
            });
        """);
    }

    @ClientCallable
    private void refreshCompleted() {
        listener.onRefresh();
    }


    public void setListener(PullToRefreshListener listener) {
        this.listener = listener;
    }

}
