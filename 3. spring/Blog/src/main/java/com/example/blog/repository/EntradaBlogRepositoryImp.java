package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.AlreadyExistsException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository{

    Map<Integer, EntradaBlog> blogMap = new HashMap<>();

    public EntradaBlogRepositoryImp(){
        EntradaBlog entradaBlog = new EntradaBlog(1, "Título", "Facundo Hermida", "2023-09-08");
        EntradaBlog entradaBlog1 = new EntradaBlog(2, "Título blog", "Santiago Langer", "2023-05-02");
        EntradaBlog entradaBlog2 = new EntradaBlog(3, "Tercer título", "Belen Santochi", "2022-09-08");
        EntradaBlog entradaBlog3 = new EntradaBlog(4, "Cuarto título", "Luis Felipe Alzamora Milla", "2022-03-18");

        blogMap.put(entradaBlog.getId(), entradaBlog);
        blogMap.put(entradaBlog1.getId(), entradaBlog1);
        blogMap.put(entradaBlog2.getId(), entradaBlog2);
        blogMap.put(entradaBlog3.getId(), entradaBlog3);
    }

    @Override
    public Integer save(EntradaBlog entradaBlog) {
        if(blogMap.get(entradaBlog.getId())!= null){
            throw new AlreadyExistsException("El blog con id " + entradaBlog.getId() + " ya existe");
        }
        blogMap.put(entradaBlog.getId(), entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public EntradaBlog get(Integer id) {
        return blogMap.get(id);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return new ArrayList<EntradaBlog>(blogMap.values());
    }
}
