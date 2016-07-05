
package interfaces;

import java.util.List;

public interface Operaciones <Entidad> {
    public int create(Entidad e);
    public int update(Entidad e);
    public int delete(Object key);
    public List<Entidad> readAll();
    public Entidad read(Object key);
    public boolean search(String e);
    
}
