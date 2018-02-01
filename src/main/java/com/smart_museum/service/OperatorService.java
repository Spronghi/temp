package com.smart_museum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_museum.dao.IOperatorDAO;
import com.smart_museum.entity.Operator;
@Service
public class OperatorService implements IOperatorService {
	@Autowired
	private IOperatorDAO operatorDAO;
	@Override
	public Operator getOperatorById(int operatorId) {
		Operator obj = operatorDAO.getOperatorById(operatorId);
		return obj;
	}	
	@Override
	public List<Operator> getAllOperators(){
		return operatorDAO.getAllOperators();
	}
	@Override
	public synchronized boolean addOperator(Operator operator){
       if (operatorDAO.operatorExists(operator.getUsername())) {
    	   return false;
       } else {
    	   operatorDAO.addOperator(operator);
    	   return true;
       }
	}
	@Override
	public void updateOperator(Operator operator) {
		operatorDAO.updateOperator(operator);
	}
	@Override
	public void deleteOperator(int operatorId) {
		operatorDAO.deleteOperator(operatorId);
	}
	@Override
	public List<Operator> getOperatorsByMuseum(int museumId) {
		return operatorDAO.getOperatorsByMuseum(museumId);
	}
	@Override
	public Operator getOperatorByUsernameAndPassword(String username, String password) {
		if (operatorDAO.operatorExists(username)) {
			return operatorDAO.getOperatorByUsernameAndPassword(username, password);
		} else {
			return null;   
		}
	}
}
