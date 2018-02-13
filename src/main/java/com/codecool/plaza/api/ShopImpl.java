package com.codecool.plaza.api;

import java.util.List;
import java.util.Map;

public class ShopImpl implements Shop {

    private String name;
    private String owner;
    private Map<Long, ShopImplEntry> products;

    public ShopImpl(String name, String owner){
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return null;
    }

    public String getOwner() {
        return null;
    }

    public boolean isOpen() {
        return false;
    }

    public void open() {

    }

    public void close() {

    }

    public List<Product> findByName(String name) throws ShopIsClosedException {
        return null;
    }

    public boolean hasProduct(long barcode) throws ShopIsClosedException {
        return false;
    }

    public void addNewProduct(Product product, int quantity, float price) throws ProductAlreadyExistsException, ShopIsClosedException {

    }

    public Product buyProduct(long barcode) throws NoSuchProductException, ShopIsClosedException {
        return null;
    }

    public List<Product> buyProducts(long barcode, int quantity) throws NoSuchProductException, OutOfStockException, ShopIsClosedException {
        return null;
    }

        class ShopImplEntry {

            private Product product;
            private int quantity;
            private float price;

            ShopImplEntry(Product product, int quantity, float price) {
                this.product = product;
                this.quantity = quantity;
                this.price = price;
            }

            public Product getProduct(){
                return product;
            }

            public void setProduct(Product product) {
                this.product = product;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public void increaseQuantity(int amount) {
                this.quantity += amount;
            }

            private void decreaseQuantity(int amount) throws NoSuchProductException {
                if (quantity - amount < 0) {
                    throw new NoSuchProductException();
                }
                this.quantity -= amount;
            }

            public float getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String toString(){

            }
        }
}
