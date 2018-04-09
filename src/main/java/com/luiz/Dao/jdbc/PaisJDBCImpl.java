package com.luiz.Dao.jdbc;



import com.luiz.Dao.PaisDAO;
import com.luiz.Entity.Pais;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaisJDBCImpl implements PaisDAO {


    public void insert(Connection conn, Pais pais) throws Exception {

        PreparedStatement myStmt = conn.prepareStatement("insert into en_pais (id_pais, nome) values (?, ?)");

        myStmt.setInt(1, this.getNextId(conn));
        myStmt.setString(2, pais.getNome());

        myStmt.execute();
        conn.commit();

    }

    public void edit(Connection conn, Pais pais) throws Exception {

        PreparedStatement myStmt = conn.prepareStatement("update en_pais set nome = (?) where id_pais = (?)");

        myStmt.setString(1, pais.getNome());
        myStmt.setInt(2, pais.getIdPais());

        myStmt.execute();
        conn.commit();
    }

    public void delete(Connection conn, Integer idPais) throws Exception {

        PreparedStatement myStmt = conn.prepareStatement("delete from en_pais where id_pais=?");

        myStmt.setInt(1, idPais);

        myStmt.execute();
        conn.commit();

    }

    public List<Pais> list(Connection conn) throws Exception {

        PreparedStatement myStmt = conn.prepareStatement("select * from en_pais order by nome");
        ResultSet myRs = myStmt.executeQuery();

        List<Pais> listOfPaises = new ArrayList<Pais>();

        while (myRs.next()) {

            Integer idPais = myRs.getInt("id_pais");
            String nomePais = myRs.getString("nome");

            listOfPaises.add(new Pais(idPais, nomePais));
        }

        return listOfPaises;
    }

    public Pais find(Connection conn, Integer idPais) throws Exception {

        PreparedStatement myStmt = conn.prepareStatement("select * from en_pais where id_pais=?");

        myStmt.setInt(1, idPais);

        ResultSet myRs = myStmt.executeQuery();

        if (myRs.next()) {

            Integer id = myRs.getInt("id_pais");
            String nomePais = myRs.getString("nome");

            return new Pais(id, nomePais);


        }
        throw new Exception();
    }

    @Override
    public Integer getNextId(Connection conn) throws Exception {
        PreparedStatement myStmt = conn.prepareStatement("select nextval('seq_en_pais')");
        ResultSet rs = myStmt.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

}
