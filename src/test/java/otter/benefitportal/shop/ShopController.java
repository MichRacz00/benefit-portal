package otter.benefitportal.shop;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.cosmos.util.CosmosPagedIterable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final CosmosClient cosmosClient;

    public ShopController(CosmosClient cosmosClient) {
        this.cosmosClient = cosmosClient;
    }

    @PostMapping
    @RequestMapping("/cart/add")
    public void addToCart() {

    }

    @GetMapping
    @RequestMapping("/allProducts")
    public List<Item> getAll() {
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
}
