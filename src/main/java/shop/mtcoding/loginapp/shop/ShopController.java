package shop.mtcoding.loginapp.shop;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.loginapp.user.User;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ShopController {
    private final ShopService shopService;
    private final HttpSession session;

    @GetMapping("/shop")
    public String shop(HttpServletRequest request){
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null) throw new RuntimeException("인증된 사용자가 아닙니다");

        List<Shop> shopList = shopService.상품목록();
        request.setAttribute("shopList", shopList);
        return "main";
    }
}