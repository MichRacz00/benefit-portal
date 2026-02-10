package otter.benefitportal.shop;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @PostMapping
    @RequestMapping("/cart/add")
    public void addToCart() {

    }
}
