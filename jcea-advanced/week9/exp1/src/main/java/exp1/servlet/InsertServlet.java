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
@WebServlet(name = "InsertServlet", urlPatterns = "/InsertServlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        PrintWriter pw = resp.getWriter();
        if (new UserMapperImpl().insertUser(user) > 0) {
            pw.print("增加用户信息成功");
            resp.setHeader("refresh", "1;URL=login-success.jsp");
        }
        else {
            pw.print("增加用户信息失败");
            resp.setHeader("refresh", "1;URL=login-success.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}