package com.bazyl.education.Model;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Item implements Cloneable {

    private static String PRICE_PATTERN = "\\d+";
    private static String TYPE_PRODUCER_PATTERN = "[\\w\\s]+";
    private static String PHONE_PATTERN = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";

    private String type = "unknown";
    private int quantity;
    private String price = "unknown";
    private String producer = "unknown";
    private String producerPhoneNumber = "unknown";
    private String producationDate = "unknown";
    private String expirationDate = "unknown";

    public Item(String type, String price, String producer) {
        setType(type);
        setPrice(price);
        setProducer(producer);
    }

    public Item(Item item) {
        this(item.getType(), item.getPrice(), item.getProducer());
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    public String getProducerPhoneNumber() {
        return producerPhoneNumber;
    }

    public String getProducationDate() {
        return producationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Illegal quantity argument!");
        }
        this.quantity = quantity;
    }

    public void setType(String type) {
        if ((type == null) || (!type.matches(TYPE_PRODUCER_PATTERN))) {
            throw new IllegalArgumentException("Illegal type argument!");
        }
        this.type = type;
    }

    public void setPrice(String price) {
        if ((price == null) || (!price.matches(PRICE_PATTERN))) {
            throw new IllegalArgumentException("Illegal price argument!");
        }
        this.price = price;
    }

    public void setProducer(String producer) {
        if ((producer == null) || (!producer.matches(TYPE_PRODUCER_PATTERN))) {
            throw new IllegalArgumentException("Illegal producer argument!");
        }
        this.producer = producer;
    }

    public void setProducerPhoneNumber(String producerPhoneNumber) {
        if ((producerPhoneNumber == null) || (!producerPhoneNumber.matches(PHONE_PATTERN))) {
            throw new IllegalArgumentException("Illegal phone argument!");
        }
        this.producerPhoneNumber = producerPhoneNumber;
    }

    public void setProducationDate(String producationDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.parse(producationDate);
            this.producationDate = producationDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void setExpirationDate(String expirationDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.parse(expirationDate);
            this.expirationDate = expirationDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!getType().equals(item.getType())) return false;
        if (!getPrice().equals(item.getPrice())) return false;
        return getProducer().equals(item.getProducer());
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getProducer().hashCode();
        return result;
    }

    @Override
    public Item clone() {
        try {
            return (Item) super.clone();
        } catch (CloneNotSupportedException exep) {
            exep.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("type='").append(type).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price='").append(price).append('\'');
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", producerPhoneNumber='").append(producerPhoneNumber).append('\'');
        sb.append(", producationDate='").append(producationDate).append('\'');
        sb.append(", expirationDate='").append(expirationDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
