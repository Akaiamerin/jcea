package exp1.servlet;
import exp1.mapper.impl.UserMapperImpl;
import exp1.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "SelectServlet", urlPatterns = "/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        List<User> userList = new UserMapperImpl().selectAllUser();
        PrintWriter pw = resp.getWriter();
        for (int i = 0; i < userList.size(); i++) {
            pw.print("<div>");
            pw.print(userList.get(i).getId() + " ");
            pw.print(userList.get(i).getUsername() + " ");
            pw.print(userList.get(i).getPassword());
            pw.print("</div>");
        }
        pw.flush();
        pw.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}