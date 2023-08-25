package org.vaadin.addons.pulltorefresh;


import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.orderedlayout.Scroller;

@JavaScript("https://unpkg.com/pulltorefreshjs@0.1.22/dist/index.umd.js")
public class PullToRefreshScroller extends Scroller {

    private final PullToRefreshListener listener;

    public PullToRefreshScroller(PullToRefreshListener listener) {
        super();
        this.listener = listener;
        getElement().executeJs("""
            var el = this;
            PullToRefresh.init({
                mainElement: el, 
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
}
