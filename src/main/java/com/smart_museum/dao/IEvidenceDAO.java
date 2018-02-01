package com.smart_museum.dao;
import java.util.List;
import com.smart_museum.entity.Evidence;
public interface IEvidenceDAO {
    List<Evidence> getAllEvidences();
    Evidence getEvidenceById(int evidenceId);
    List<Evidence> getEvidencesByMuseumId(int museumId);
    void addEvidence(Evidence evidence);
    void updateEvidence(Evidence evidence);
    void deleteEvidence(int evidenceId);
    boolean evidenceExists(String title, String category);
}
 
