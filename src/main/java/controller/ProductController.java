package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProductController {

    @GetMapping("/products")
    public void showProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("products", ProductService.products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showProduct.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/create")
    public String create(){
        return "create";
    }
}
