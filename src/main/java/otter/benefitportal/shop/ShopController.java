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
        Item cup = new Item(
                "1",
                "Kubek Ocipieje",
                "Powiedz innym co czujesz tym prestiżowym kubkiem z firmy Niejebajka. Specjał Walentynkowy!",
                "/images/cup.webp",
                50);

        Item coke = new Item(
                "2",
                "Cola Zero",
                "Codzienny napój na lepszy humor. Najlepiej smakuje schłodzony. 330ml, puszka zwrotna.",
                "/images/coke-zero.png",
                1);

        Item singha = new Item(
                "3",
                "Singha Beer",
                "Hello my firend, tasty cold beer, just for you special price",
                "/images/singha.png",
                20);

        return Arrays.asList(cup, coke, singha);
    }
}
