package fr.epita.quiz.services.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.quiz.datamodel.Question;


/**
 * 
 * @author User
 *
 * @param <T>
 * @param <I>
 */
public abstract class GenericDAO<T,I> {
	
	@PersistenceContext
	private EntityManager em;

	
	@Transactional(value=TxType.REQUIRED)
	public  void create(T entity) {	
		em.persist(entity);
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void edit(T entity) {
		em.merge(entity);
	}
	
	public abstract String getQuery();
	public abstract void setParameters(Map<String,Object> parameters, T criteria);
	
	public  List<T> search(T criteria){
		Query searchQuery = em.createQuery(getQuery());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		setParameters(parameters, criteria);
		for (Map.Entry<String,Object> entry : parameters.entrySet() ) {
			searchQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return searchQuery.getResultList();
		
	}
	public  T getById(I id) {
		return em.find(getEntityClass(), id);
	}

	public abstract Class<T> getEntityClass();

	@Transactional
	public void delete(I id) {
		T entity = em.find(getEntityClass(), id);
		em.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(){
		String query = "from " + getclassname();
		Query getallquesry = em.createQuery(query);
		List<T> list = getallquesry.getResultList();
		return list;
	}
	
	public String getclassname() {
		String test = getEntityClass().getSimpleName();
		test = test.substring(test.lastIndexOf(".") + 1);
		return test;
	}
	
	@Transactional
	public void deletChoiceFk(I id, String columnName) {
		
		String query ="delete from "+getclassname()+" where " + columnName + " = " + id;
		System.out.println(query);
		em.createQuery(query).executeUpdate();
	}
	
	public List<T> getByOtherColumnId(I id, String columnName) {

		String query = "from " + getclassname() + " where " + columnName + " = " + id;

		return em.createQuery(query,getEntityClass()).getResultList();

		}
	
}
