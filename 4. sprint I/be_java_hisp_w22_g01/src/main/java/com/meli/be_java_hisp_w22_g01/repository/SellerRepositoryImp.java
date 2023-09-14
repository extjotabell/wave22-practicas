package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepositoryImp implements ISellerRepository{

    private List<Seller> sellerList = new ArrayList<>();
    private UserRepositoryImp userRepo;
    @Override
    public void save(Seller seller) {
        sellerList.add(seller);
    }

    @Override
    public List<Seller> getAll() {
        return sellerList;
    }

    @Override
    public Seller findById(int seller_id) {
        return sellerList.stream().filter(seller -> seller.getUser_id() == seller_id).findFirst().orElse(null);
    }

    @Override
    public void sumAFollower(int idFollower, int idSeller) {

        Seller seller = findById(idSeller);
        seller.getFollowers().add(userRepo.findById(idFollower));

    }
}
