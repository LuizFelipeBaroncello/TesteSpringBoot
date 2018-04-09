package com.luiz.Service;

import com.luiz.Dao.PaisDAO;
import com.luiz.Entity.Pais;
import com.luiz.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PaisService {

    @Autowired
    private PaisDAO paisDao;

    public Collection<Pais> getTodosOsPaises() throws Exception {
        return paisDao.list(new ConnectionFactory().getConnection());
    }

    public Pais getPais(int id) throws Exception {
        return paisDao.find(new ConnectionFactory().getConnection(), id);
    }

}
