public class Repository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int removeID) {
        Product removeProdukt = findById(removeID);
        if (removeProdukt == null) ;
        throw new NotFoundException(removeID);
    }


    public void removeID(int removeID) {
        Product[] tmp = new Product[products.length - 1];

        int index = 0;
        for (Product product : products) {
            if (product.getId() != removeID) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

