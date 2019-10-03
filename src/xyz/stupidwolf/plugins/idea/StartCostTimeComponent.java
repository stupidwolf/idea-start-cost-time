package xyz.stupidwolf.plugins.idea;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.BaseComponent;
import org.jetbrains.annotations.NotNull;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ResourceBundle;

public class StartCostTimeComponent implements BaseComponent {
    private final static String START_COST_TIME_CONTENT = "startCostTime";
    private static ResourceBundle msg = ResourceBundle.getBundle("i18n.msg", new UTF8Control());
    private static final String KEY_START_COST_TIME = "start.cost.time";

    @Override
    public void initComponent() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long startTime = runtimeMXBean.getStartTime();
        Notification notification = new Notification(START_COST_TIME_CONTENT,
                msg.getString(KEY_START_COST_TIME), (System.currentTimeMillis() - startTime) + " ms",
                NotificationType.INFORMATION);

        Notifications.Bus.notify(notification);
    }

    @Override
    public void disposeComponent() {
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "startCostTimeComponent";
    }
}
