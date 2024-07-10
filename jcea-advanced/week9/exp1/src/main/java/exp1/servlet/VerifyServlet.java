package exp1.servlet;
import exp1.mapper.impl.UserMapperImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import exp1.model.User;
@WebServlet(name = "VerifyServlet", urlPatterns = "/VerifyServlet")
public class VerifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        User user = (User) req.getAttribute("user");
        if (Objects.equals(req.getAttribute("option"), "login") == true) {
            User curUser = new UserMapperImpl().selectUserByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (curUser != null && Objects.equals(curUser.getPassword(), user.getPassword()) == true) {
                req.getSession().setAttribute("user", user);
                resp.setHeader("refresh", "1;URL=login-success.jsp");
            }
            else {
                resp.sendRedirect("login.jsp");
            }
        }
        else if (Objects.equals(req.getAttribute("option"), "register") == true) {
            if (new UserMapperImpl().insertUser(user) > 0) {
                resp.setHeader("refresh", "1;URL=register-success.jsp");
            }
            else {
                resp.sendRedirect("register.jsp");
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}