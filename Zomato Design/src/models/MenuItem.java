package models;

public class MenuItem{
    private String code;
    private String name;
    private Integer price;

    public MenuItem(String code, String name, Integer price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public MenuItem() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
