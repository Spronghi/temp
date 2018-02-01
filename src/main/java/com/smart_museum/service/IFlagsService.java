package com.smart_museum.service;

import java.util.List;

import com.smart_museum.entity.Flags;

public interface IFlagsService {
    List<Flags> getAllFlags();
    Flags getFlagsById(int flagsId);
    boolean addFlags(Flags flags);
    void updateFlags(Flags flags);
    void deleteFlags(int flagsId);
 	Flags getFlagsByEvidenceId(int evidenceId);
}
