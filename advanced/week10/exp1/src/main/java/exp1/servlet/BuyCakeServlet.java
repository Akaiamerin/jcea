package exp1.servlet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exp1.mapper.CakeMapper;
import exp1.mapper.impl.CakeMapperImpl;
import exp1.model.Cake;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "BuyCakeServlet", urlPatterns = "/BuyCakeServlet")
public class BuyCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        CakeMapper cakeMapper = new CakeMapperImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        String data = req.getReader().readLine();
        if (data != null && data.length() > 0) {
            JsonNode jsonNode = objectMapper.readTree(objectMapper.readTree(data).get("data").toString()).get("buyCakeIdList");
            for (JsonNode node : jsonNode) {
                Cake cake = new Cake();
                cake.setId(node.asInt());
                cakeMapper.updateNumberById(cake);
            }
        }
        List<Cake> cakeList = cakeMapper.selectAllCake();
        PrintWriter pw = resp.getWriter();
        pw.print("{");
        pw.print("\"cakeList\":" + objectMapper.writeValueAsString(cakeList));
        pw.print("}");
        pw.flush();
        pw.close();
        req.getRequestDispatcher("online-cake-shop.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}