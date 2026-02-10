package otter.benefitportal.shop;

import java.util.Objects;

/**
 * Item – a product / benefit that can be added to a cart.
 */
public class Item {

    /* ------------------------------------------------------------------ */
    /*  Fields – keep them private, expose via getters/setters           */
    /* ------------------------------------------------------------------ */

    private String id;          // unique identifier (UUID or Cosmos partition key)
    private String title;       // name of the product
    private String content;     // description
    private String image;       // URI pointing to the image
    private int price;          // price in the smallest currency unit (e.g. cents)

    /* ------------------------------------------------------------------ */
    /*  Constructors                                                     */
    /* ------------------------------------------------------------------ */

    /** Default constructor (required by frameworks such as Jackson). */
    public Item() {}

    /** Minimal constructor – useful when you only know the basics. */
    public Item(String id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    /** Full constructor – all fields. */
    public Item(String id, String title, String content,
                String image, int price) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.price = price;
    }

    /* ------------------------------------------------------------------ */
    /*  Getters / Setters                                               */
    /* ------------------------------------------------------------------ */

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    /* ------------------------------------------------------------------ */
    /*  Utility methods (equals, hashCode, toString)                    */
    /* ------------------------------------------------------------------ */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
