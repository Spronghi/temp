package com.smart_museum.dao;

import java.util.List;

import com.smart_museum.entity.Flags;

public interface IFlagsDAO {
    List<Flags> getAllFlags();
    Flags getFlagsById(int flagsId);
    void addFlags(Flags flags);
    void updateFlags(Flags flags);
    void deleteFlags(int flagsId);
	Flags getFlagsByEvidenceId(int evidenceId);
}
