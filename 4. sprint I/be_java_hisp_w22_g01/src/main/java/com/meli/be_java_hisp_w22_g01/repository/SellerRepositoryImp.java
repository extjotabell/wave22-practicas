package com.meli.be_java_hisp_w22_g01.repository;

import com.meli.be_java_hisp_w22_g01.entity.Post;
import com.meli.be_java_hisp_w22_g01.entity.Seller;
import com.meli.be_java_hisp_w22_g01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SellerRepositoryImp implements ISellerRepository{

    private List<Seller> sellerList = new ArrayList<>();
    @Autowired
    private IUserRepository userRepo;

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

        Seller seller1 = new Seller();
        seller1.setPosts(posts1);
        seller1.setUser_id(1);
        seller1.setUser_name("Rick Harrison");

        Seller seller2 = new Seller();
        seller2.setPosts(posts2);
        seller2.setUser_id(2);
        seller2.setUser_name("Zadie Smith");

        Seller seller3 = new Seller();
        seller3.setPosts(posts3);
        seller3.setUser_id(3);
        seller3.setUser_name("Comefulanito");

        //Generar lista de vendedores a followed
        List<Seller> sellers1 = new ArrayList<>();
        sellers1.add(seller1);
        sellers1.add(seller3);

        List<Seller> sellers2 = new ArrayList<>();
        sellers2.add(seller3);

        List<Seller> sellers3 = new ArrayList<>();
        sellers3.add(seller1);
        sellers3.add(seller2);
        sellers3.add(seller3);

        // Usuarios falsos
        User user4 = new User(4, "Lisa", sellers1);
        User user5 = new User(5, "Bart", sellers2);
        User user6 = new User(6, "Maggie", sellers3);

        // Seguidores de los vendedores
        List<User> followers1 = new ArrayList<>();
        followers1.add(user4);
        followers1.add(user6);
        List<User> followers2 = new ArrayList<>();
        followers2.add(user6);
        List<User> followers3 = new ArrayList<>();
        followers3.add(user4);
        followers3.add(user5);
        followers3.add(user6);

        // Agregar followers a los vendedores
        seller1.setFollowers(followers1);
        seller2.setFollowers(followers2);
        seller3.setFollowers(followers3);

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
    public Seller sumAFollower(int idFollower, int idSeller) {

        Seller seller = findById(idSeller);
        seller.getFollowers().add(userRepo.findById(idFollower));
        userRepo.getAllFolloweds(userRepo.findById(idFollower)).add(findById(idSeller));

        return seller;
    }
    @Override
    public List<User> getAllFollowers(Seller seller) {
        return seller.getFollowers();
    }

    @Override
    public void updateUser(int user_id, Seller seller) {
        Seller oldSeller = this.findById(user_id);
        int indexPos = this.sellerList.indexOf(oldSeller);
        this.sellerList.set(indexPos, seller);
    }
}
