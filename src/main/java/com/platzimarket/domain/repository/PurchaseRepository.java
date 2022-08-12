package com.platzimarket.domain.repository;

import com.platzimarket.domain.Purchase;
import com.platzimarket.domain.PurchaseItem;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save (Purchase purchase);
}
