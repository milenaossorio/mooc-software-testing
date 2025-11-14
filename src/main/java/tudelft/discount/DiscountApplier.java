package tudelft.discount;

public class DiscountApplier {

    private ProductDao dao;

    public DiscountApplier (ProductDao dao) {
        this.dao = dao;
    }

    public void setNewPrices() {

        for(Product product : dao.all()) {
            if(product.getCategory().equals("HOME")) {
                product.setPrice(product.getPrice() * 90 / 100);
            }
            if(product.getCategory().equals("BUSINESS")) {
                product.setPrice(product.getPrice() * 110 / 100);
            }
        }

    }
}
