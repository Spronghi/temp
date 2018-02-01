package com.smart_museum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smart_museum.entity.Operator;

@Transactional
@Repository
public class OperatorDAO implements IOperatorDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Operator> getAllOperators() {
		String hql = "FROM Operator as operator ORDER BY operator.id";
		return (List<Operator>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Operator getOperatorById(int operatorId) {
		return entityManager.find(Operator.class, operatorId);
	}

	@Override
	public void addOperator(Operator operator) {
		entityManager.persist(operator);
	}

	@Override
	public void updateOperator(Operator operator) {
		Operator oldOperator = getOperatorById(operator.getId());
		oldOperator.setMuseum(operator.getMuseum());
		oldOperator.setAdmin(operator.isAdmin());
		oldOperator.setEmail(operator.getEmail());
		oldOperator.setName(operator.getName());
		oldOperator.setSurname(operator.getSurname());
		oldOperator.setPassword(operator.getPassword());
		oldOperator.setUsername(operator.getUsername());
		entityManager.flush();
	}

	@Override
	public void deleteOperator(int operatorId) {
		entityManager.remove(getOperatorById(operatorId));
	}

	@Override
	public boolean operatorExists(String username) {
		String hql = "FROM Operator as operator WHERE operator.username = ?";
		int count = entityManager.createQuery(hql).setParameter(1, username)
		              .getResultList().size();
		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operator> getOperatorsByMuseum(int museumId) {
		String hql = "FROM Operator as operator WHERE operator.museum.id=? ORDER BY operator.id";
		return (List<Operator>) entityManager.createQuery(hql).setParameter(1, museumId).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Operator getOperatorByUsernameAndPassword(String username, String password) {
		String hql = "FROM Operator as operator WHERE operator.username=? ORDER BY operator.id";
		List<Operator> list = (List<Operator>) entityManager.createQuery(hql).setParameter(1, username).getResultList();
		if(!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
