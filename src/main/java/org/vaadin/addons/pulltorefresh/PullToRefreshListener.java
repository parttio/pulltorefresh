package org.vaadin.addons.pulltorefresh;

import java.io.Serializable;

public interface PullToRefreshListener extends Serializable {
    void onRefresh();
}
