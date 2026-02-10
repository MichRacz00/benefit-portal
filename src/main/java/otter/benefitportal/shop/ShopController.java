package otter.benefitportal.shop;

import com.azure.cosmos.CosmosClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    //private final CosmosClient cosmosClient;

   // public ShopController(CosmosClient cosmosClient) {
        //this.cosmosClient = cosmosClient;
   // }

    @PostMapping("/cart/add")
    public void addToCart() {

    }

    @GetMapping("/allProducts")
    public List<Item> getAll() {
        /*
        try {
            String sql = "SELECT * FROM c;";

            SqlQuerySpec querySpec = new SqlQuerySpec(sql, (List<SqlParameter>) null);

            List<Item> items = new ArrayList<>();

            CosmosContainer container = cosmosClient
                    .getDatabase("shop")
                    .getContainer("products");

            CosmosPagedIterable<Item> result = container
                    .queryItems(querySpec, new CosmosQueryRequestOptions(), Item.class);

            result.stream().forEach(items::add);

            return items;

        } catch (Exception e) {
            System.err.println("Error retrieving all items: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve all items", e);
        }
    }
         */

        Item badge = new Item(
                "1",
                "Premium Badge",
                "Earned by completing 10 benefits",
                "https://example.com/badge.png",
                499);   // 4.99 USD

        Item coffee = new Item(
                "2",
                "Free Coffee",
                "One free coffee per month",
                "https://example.com/coffee.png",
                0);      // free

        Item gym = new Item(
                "3",
                "Gym Pass",
                "Unlimited gym access for 3 months",
                "https://example.com/gym.png",
                2999);   // 29.99 USD

        // 2️⃣  Return them as a list
        return Arrays.asList(badge, coffee, gym);
    }
}
