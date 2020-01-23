package ash.servlet.analysis.web.controller.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestCleanupFilter implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent event) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
    }
}
