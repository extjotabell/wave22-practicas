package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepositoryImp implements ISellerRepository{

    private List<Seller> sellerList = new ArrayList<>();
    private UserRepositoryImp userRepo;

    public SellerRepositoryImp() {

        IPostRepository postRepository = new PostRepositoryImp();

        // Post pertenecientes a los vendedores
        List<Post> posts1 = new ArrayList<>();
        posts1.add(postRepository.getPostById(1));

        List<Post> posts2 = new ArrayList<>();
        posts2.add(postRepository.getPostById(2));

        List<Post> posts3 = new ArrayList<>();
        posts3.add(postRepository.getPostById(1));
        posts3.add(postRepository.getPostById(2));

        //Seguidores de los vendedores
        List<User> followers1 = new ArrayList<>();
        List<User> followers2 = new ArrayList<>();

        Seller seller1 = new Seller(posts1, followers1);
        seller1.setUser_id(1);
        seller1.setUser_name("Rick Harrison");

        Seller seller2 = new Seller(posts2, followers2);
        seller2.setUser_id(2);
        seller2.setUser_name("Zadie Smith");

        Seller seller3 = new Seller(posts3, followers2);
        seller3.setUser_id(3);
        seller3.setUser_name("Comefulanito");

        this.sellerList.add(seller1);
        this.sellerList.add(seller2);
        this.sellerList.add(seller3);
    }

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
