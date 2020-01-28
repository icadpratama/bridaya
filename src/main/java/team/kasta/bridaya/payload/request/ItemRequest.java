package team.kasta.bridaya.payload.request;

import team.kasta.bridaya.model.common.Image;

import javax.validation.constraints.NotBlank;

public class ItemRequest {

    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotBlank(message = "Price can't be blank")
    private Long price;

    private Boolean status;

    @NotBlank(message = "Description can't be blank")
    private String description;

    private Image image;

    private Long merchantId;

    public ItemRequest(@NotBlank(message = "Name can't be blank") String name, @NotBlank(message = "Price can't be blank") Long price, Boolean status, @NotBlank(message = "Description can't be blank") String description, Image image, Long merchantId) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.description = description;
        this.image = image;
        this.merchantId = merchantId;
    }

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
