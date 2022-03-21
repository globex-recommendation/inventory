package com.redhat.coolstore;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Cacheable;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
public class Inventory extends PanacheEntity {

    public String itemId;
    public String location;
    public int quantity;
    public String link;

    public Inventory() {

    }

    public static List<Inventory> findByItemId(String itemId){
        return find("itemId", itemId).<Inventory>stream().collect(Collectors.toList());
    }

}