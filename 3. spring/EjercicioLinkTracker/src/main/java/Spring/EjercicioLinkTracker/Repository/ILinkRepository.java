package Spring.EjercicioLinkTracker.Repository;

import Spring.EjercicioLinkTracker.Entities.Link;

import java.util.List;

public interface ILinkRepository {
    Link createLink(Link link);
    List<Link> getAllLinks();
    Link getLink(int id);
}
