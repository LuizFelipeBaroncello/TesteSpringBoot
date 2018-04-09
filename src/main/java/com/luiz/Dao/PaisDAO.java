package com.luiz.Dao;

import com.luiz.Entity.Pais;

import java.sql.Connection;
import java.util.List;

public interface PaisDAO {

	void insert(Connection conn, Pais pais) throws Exception;
	
	Integer getNextId(Connection conn) throws Exception;

	void edit(Connection conn, Pais pais) throws Exception;

	void delete(Connection conn, Integer idPais) throws Exception;

	Pais find(Connection conn, Integer idPais) throws Exception;

	List<Pais> list(Connection conn) throws Exception;

}