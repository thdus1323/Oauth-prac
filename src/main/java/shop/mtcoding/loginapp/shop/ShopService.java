package shop.mtcoding.loginapp.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public List<Shop> 상품목록(){
        List<Shop> shopList = shopRepository.findAll();
        return shopList;
    }
}