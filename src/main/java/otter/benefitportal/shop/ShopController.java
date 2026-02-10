package otter.benefitportal.shop;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final static Cart cart = new Cart();

    @GetMapping("/cart/all")
    public Map<Integer, Integer> getCart() {
        return cart.getItemsForUser("temp-id");
    }

    @PostMapping("/cart/add")
    public void addToCart(@RequestParam(name = "itemId") int itemId) {
        cart.addItem("temp-id", itemId, 1);
    }

    @GetMapping("/allProducts")
    public List<Item> getAll() {
         return cart.getAllItems();
    }
}
