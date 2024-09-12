package exp1.listener;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import exp1.model.User;
@WebListener
public class OnlineListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext application = event.getServletContext();
        List<User> onlineUserList = new ArrayList<>();
        application.setAttribute("onlineUserList", onlineUserList);
    }
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        ServletContext application = event.getSession().getServletContext();
        List<User> onlineUserList = (List<User>) application.getAttribute("onlineUserList");
        User user = (User) event.getValue();
        int index = -1;
        for (int i = 0; i < onlineUserList.size(); i++) {
            if (Objects.equals(onlineUserList.get(i).getUsername(), user.getUsername()) == true) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            onlineUserList.add(user);
            application.setAttribute("onlineUserList", onlineUserList);
        }
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        ServletContext application = event.getSession().getServletContext();
        List<User> onlineUserList = (List<User>) application.getAttribute("onlineUserList");
        User user = (User) event.getValue();
        onlineUserList.remove(user);
        application.setAttribute("onlineUserList", onlineUserList);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext application = event.getSession().getServletContext();
        User user = (User) event.getSession().getAttribute("user");
        List<User> onlineUserList = (List<User>) application.getAttribute("onlineUserList");
        onlineUserList.remove(user);
        application.setAttribute("onlineUserList", onlineUserList);
    }
}