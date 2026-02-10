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
    public Map<String, Integer> getCart() {
        return cart.getItemsForUser("temp-id");
    }

    @PostMapping("/cart/add")
    public void addToCart(@RequestParam(name = "itemId") Item itemId) {
        cart.addItem("temp-id", itemId, 1);
    }

    @GetMapping("/allProducts")
    public List<Item> getAll() {
        Item badge = new Item(
                "1",
                "Premium Badge",
                "Earned by completing 10 benefits",
                "https://picsum.photos/600/400?random=1&category=business",
                499);   // 4.99 USD

        Item coffee = new Item(
                "2",
                "Free Coffee",
                "One free coffee per month",
                "https://picsum.photos/600/400?random=2&category=food",
                0);      // free

        Item gym = new Item(
                "3",
                "Gym Pass",
                "Unlimited gym access for 3 months",
                "https://picsum.photos/600/400?random=3&category=sports",
                2999);   // 29.99 USD

        return Arrays.asList(badge, coffee, gym);
    }
}
