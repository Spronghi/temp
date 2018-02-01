package com.smart_museum.dao;
import java.util.List;
import com.smart_museum.entity.Operator;

public interface IOperatorDAO {
    List<Operator> getAllOperators();
    List<Operator> getOperatorsByMuseum(int museumId);
    Operator getOperatorByUsernameAndPassword(String username, String password);
    Operator getOperatorById(int operatorId);
    void addOperator(Operator operator);
    void updateOperator(Operator operator);
    void deleteOperator(int operatorId);
    boolean operatorExists(String name);
}
 
