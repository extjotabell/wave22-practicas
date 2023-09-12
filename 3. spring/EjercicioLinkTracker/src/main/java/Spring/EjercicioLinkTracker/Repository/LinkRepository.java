package Spring.EjercicioLinkTracker.Repository;
import Spring.EjercicioLinkTracker.Entities.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {
    private List<Link> links = new ArrayList<>();

    @Override
    public Link createLink(Link link) {
        Link newLink = new Link(this.links.size() +1, link.getUrl(), 0, true, link.getPassword());
        this.links.add(newLink);
        return link;
    }

    @Override
    public List<Link> getAllLinks() {
        return links;
    }


    @Override
    public Link getLink(int id){
        return this.links.stream().filter(x->x.getId() == id).findFirst().orElse(null);
    }





}
