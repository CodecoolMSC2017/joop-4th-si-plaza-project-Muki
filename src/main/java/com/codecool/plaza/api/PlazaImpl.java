package com.codecool.plaza.api;

import java.util.List;

public class PlazaImpl implements Plaza {

    private List<Shop> shops;

    public List<Shop> getShops() throws PlazaIsClosedException {
        return null;
    }

    public void addShop(Shop shop) throws ShopAlreadyExistsException, PlazaIsClosedException {

    }

    public void removeShop(Shop shop) throws NoSuchShopException, PlazaIsClosedException {

    }

    public Shop findShopByName(String name) throws NoSuchShopException, PlazaIsClosedException {
        return null;
    }

    public boolean isOpen() {
        return false;
    }

    public void open() {

    }

    public void close() {

    }
}
