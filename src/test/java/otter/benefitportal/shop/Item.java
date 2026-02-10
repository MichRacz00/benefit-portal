package otter.benefitportal.shop;

/**
 * Item – a product / benefit that can be added to a cart.
 *
 * <p>
 *   This class follows the same layout as the {@code Memo} you showed:
 *   a no‑arg constructor, a minimal constructor, a full constructor,
 *   private fields with public getters/setters, and a {@code Type} enum.
 * </p>
 */
public class Item {

    /* ------------------------------------------------------------------ */
    /*  Fields – keep them private, expose via getters/setters           */
    /* ------------------------------------------------------------------ */
    private String id;          // unique identifier (UUID or Cosmos partition key)
    private String userId;      // owner / creator (optional)
    private String title;       // name of the product
    private String content;     // description
    private Type type;         // enum: PRODUCT, SERVICE, DISCOUNT, etc.

    /* ------------------------------------------------------------------ */
    /*  Constructors                                                     */
    /* ------------------------------------------------------------------ */

    /** Default constructor (required by frameworks like Jackson). */
    public Item() {}

    /** Minimal constructor – id will be generated elsewhere. */
    public Item(String userId, Type type) {
        this.userId = userId;
        this.type   = type;
    }

    /** Full constructor – all fields. */
    public Item(String id, String userId, String title, String content,
                Type type) {
        this.id      = id;
        this.userId  = userId;
        this.title   = title;
        this.content = content;
        this.type    = type;
    }

    /* ------------------------------------------------------------------ */
    /*  Getters / Setters                                               */
    /* ------------------------------------------------------------------ */

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }

    /* ------------------------------------------------------------------ */
    /*  Helper enum – feel free to extend it with more item types.        */
    /* ------------------------------------------------------------------ */
    public enum Type {
        PRODUCT,
        SERVICE,
        DISCOUNT,
        GIFT_CARD
    }

    /* ------------------------------------------------------------------ */
    /*  toString / equals / hashCode (optional but handy)                */
    /* ------------------------------------------------------------------ */

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return id != null && id.equals(item.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}