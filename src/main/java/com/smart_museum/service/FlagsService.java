package com.smart_museum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart_museum.dao.IFlagsDAO;
import com.smart_museum.entity.Flags;

@Service
public class FlagsService implements IFlagsService {
	@Autowired
	private IFlagsDAO flagsDAO;
	@Override
	public Flags getFlagsById(int flagsId) {
		Flags obj = flagsDAO.getFlagsById(flagsId);
		return obj;
	}	
	@Override
	public List<Flags> getAllFlags(){
		return flagsDAO.getAllFlags();
	}
	@Override
	public synchronized boolean addFlags(Flags flags){
    	   flagsDAO.addFlags(flags);
    	   return true;
	}
	@Override
	public void updateFlags(Flags flags) {
		flagsDAO.updateFlags(flags);
	}
	@Override
	public void deleteFlags(int flagsId) {
		flagsDAO.deleteFlags(flagsId);
	}
	@Override
	public Flags getFlagsByEvidenceId(int evidenceId) {
		return flagsDAO.getFlagsByEvidenceId(evidenceId);
	}
}
