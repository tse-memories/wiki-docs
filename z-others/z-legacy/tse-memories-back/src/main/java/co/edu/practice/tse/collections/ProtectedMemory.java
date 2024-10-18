package co.edu.practice.tse.collections;

import co.edu.practice.tse.collections.helpers.Location;
import co.edu.practice.tse.collections.helpers.MemoryPhoto;
import co.edu.practice.tse.collections.helpers.Visualization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProtectedMemory extends PublicMemory{
    private List<String> authorizedEmailList;

    public ProtectedMemory(String id, String name, LocalDate memoryDate, LocalDate creationDate, String visibility, List<String> tagList, String creatorId, List<MemoryPhoto> memoryPhotoList, Location location, List<Visualization> visualizationList, List<String> authorizedEmailList) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creatorId, memoryPhotoList, location, visualizationList);
        this.authorizedEmailList = authorizedEmailList;
    }
}
