package service;

import java.util.ArrayList;

import com.dao.CategoriaDAO;

import model.Categoria;

public class CategoryService {
public static ArrayList<Categoria> getAll(){
	return CategoriaDAO.getAll();
}
}
