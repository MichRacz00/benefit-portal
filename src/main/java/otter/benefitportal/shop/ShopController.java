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
                10);

        Item allegro = new Item(
                "4",
                "Kupon Allegro",
                "Wszystko i nic - idealne żeby się zagracić",
                "/images/allegro.png",
                50);

        Item rossman = new Item(
                "5",
                "Rossman",
                "Kiedy potrzebujesz tylko wejść coś zobaczyć",
                "/images/rossmann.jpg",
                50);

        Item hug = new Item(
                "6",
                "Przytulasek",
                "Kiedy życie daje w kość",
                "/images/hug.png",
                1);

        Item kiss = new Item(
                "7",
                "Buziaczek",
                "Wyraz miłości od Twojej wyderki",
                "/images/kiss.png",
                1);

        Item conversation = new Item(
                "8",
                "Szczera Rozmowa",
                "Najelpsza żeby się wyżalić",
                "/images/conversation.png",
                1);

        Item italianCookies = new Item(
                "9",
                "Fior di Cacao",
                "Najsmaczniejszy dupoposzerzacz na południe od Tyrolu.",
                "/images/italian-cookies.jpg",
                35);

        Item mcdonalds = new Item(
                "10",
                "McDonalds",
                "Zamawiamy Wieśniaka",
                "/images/mcdonalds.png",
                25);

        Item kimLong = new Item(
                "11",
                "Kim Long",
                "Smaki Azji",
                "/images/kim-long.png",
                25);

        Item hebe = new Item(
                "12",
                "Hebe",
                "Gorszy Rossmann",
                "/images/hebe.png",
                50);

        return Arrays.asList(cup, coke, singha, allegro, rossman, hug, kiss, conversation, italianCookies, mcdonalds, kimLong, hebe);
    }
}
