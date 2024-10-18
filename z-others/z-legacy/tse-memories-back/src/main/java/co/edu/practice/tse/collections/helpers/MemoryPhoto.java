package co.edu.practice.tse.collections.helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class MemoryPhoto {
    private String urlPhoto;
    private String title;
    private String description;
}
