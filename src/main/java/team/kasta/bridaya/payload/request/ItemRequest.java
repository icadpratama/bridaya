package team.kasta.bridaya.payload.request;

import javax.validation.constraints.NotBlank;

public class ItemRequest {

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Price can't be blank")
    private Long price;

    private Boolean status;

    @NotBlank(message = "Description can't be blank")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
