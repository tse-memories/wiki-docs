package co.edu.practice.tse.dtos;

import co.edu.practice.tse.dtos.helpers.EnumVisibilityDto;
import co.edu.practice.tse.dtos.helpers.LocationDto;
import co.edu.practice.tse.dtos.helpers.MemoryPhotoDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProtectedMemoryDto extends PublicMemoryDto {
    @NotEmpty                           //El unico ID es el del Creador
    private List<String> authorizedEmailList;

    @Builder
    public ProtectedMemoryDto(String id, String name, LocalDate memoryDate, LocalDate creationDate, String visibility, List<String> tagList, String creatorId, List<MemoryPhotoDto> memoryPhotoList, LocationDto location, List<VisualizationDto> visualizationList, List<String> authorizedEmailList) {
        super(id, name, memoryDate, creationDate, visibility, tagList, creatorId, memoryPhotoList, location, visualizationList);
        this.authorizedEmailList = authorizedEmailList;
        this.validateMemoryVisibility(visibility);
    }

    private void validateMemoryVisibility(String visibility) throws IllegalArgumentException {
        if(!EnumVisibilityDto.enumValueIsValid(visibility)&& !visibility.equalsIgnoreCase("protegido")) {
            throw new IllegalArgumentException("El tipo de visibilidad no es válida");
        }
    }
}
