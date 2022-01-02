package be.businesstraining.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="flats")
public class Flat {
    @Id
    private String id;
    private String title;
    private BigDecimal price;
    private String imageUrl;
    public Flat() {
    }

    public Flat(String id, String title, BigDecimal price, String imageUrl) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price + '\'' +
                ", image=" + imageUrl +
                '}';
    }
}

