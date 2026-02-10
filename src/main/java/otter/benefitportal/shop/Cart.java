package otter.benefitportal.shop;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class Cart {
    private final Map<String, Map<String, Integer>> allUserItems = new ConcurrentHashMap<>();
    private final Map<String, Integer> allUserCartValues = new ConcurrentHashMap<>();

    public void addItem(String userId, Item item, int quantity) {
        Map<String, Integer> userItems = allUserItems.computeIfAbsent(userId, k -> new ConcurrentHashMap<>());
        userItems.merge(item.getId(), quantity, Integer::sum);
        allUserCartValues.merge(userId, item.getPrice() * quantity, Integer::sum);
    }

    public int getCartValue(String userId) {
        return allUserCartValues.getOrDefault(userId, 0);
    }

    public Map<String, Integer> getItemsForUser(String userId) {
        return allUserItems.get(userId);
    }
}