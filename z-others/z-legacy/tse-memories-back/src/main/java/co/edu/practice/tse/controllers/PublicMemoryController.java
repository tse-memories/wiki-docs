package co.edu.practice.tse.controllers;

import co.edu.practice.tse.dtos.PublicMemoryDto;
import co.edu.practice.tse.dtos.helpers.VisualizationDto;
import co.edu.practice.tse.services.PublicMemoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://tse-memories.web.app/")
//@CrossOrigin(origins = "http://localhost:3000/")
public class PublicMemoryController {
    @Autowired
    private PublicMemoryServiceImpl publicMemoryService;
    private final Logger logger = LoggerFactory.getLogger(PublicMemoryController.class);

    @PostMapping("/post/public-memory")
    public ResponseEntity<PublicMemoryDto> saveOrUpdateNewPublicMemory(@RequestBody PublicMemoryDto publicMemoryDto) {
        logger.info("[PublicMemory] POST Recuerdo Público");
        return new ResponseEntity(this.publicMemoryService.saveOrUpdateNewPublicMemory(publicMemoryDto), HttpStatus.OK);
    }

    @GetMapping("/get/public-memories/{userId}")
    public ResponseEntity<List<PublicMemoryDto>> getAllUserPublicMemories(@PathVariable("userId") String userId) {
        logger.info("[PublicMemory] GET Todos los Recuerdos Públicos");

        return new ResponseEntity(this.publicMemoryService.getAllPublicMemoriesByUserId(userId), HttpStatus.OK);

    }

    @GetMapping("/get/public-memory/{memoryId}")
    public ResponseEntity<List<PublicMemoryDto>> getPublicMemoryByMemoryId(@PathVariable("memoryId") String memoryId) {
        logger.info("[PublicMemory] GET un Recuerdo Público");

        return new ResponseEntity(this.publicMemoryService.getMemoryByMemoryId(memoryId), HttpStatus.OK);

    }

    @PutMapping("/put/public-memory/count-view/{memoryId}")
    public ResponseEntity<String> countPublicMemoryView(@RequestBody VisualizationDto visualizationDto, @PathVariable("memoryId") String memoryId) {
        logger.info("[PublicMemory] PUT Registro de Visita a Recuerdo Público");
        return new ResponseEntity(this.publicMemoryService.registerPublicMemoryView(memoryId, visualizationDto), HttpStatus.OK);
    }

    @GetMapping("/get/public-memories/owner-email/{email}")
    public ResponseEntity<List<PublicMemoryDto>> getAllMemoriesByOwnerEmail(@PathVariable("email") String email) {
        logger.info("[PublicMemory] GET todos los Recuerdos Públicos Por Email Del Dueño");
        return new ResponseEntity(this.publicMemoryService.getAllMemoriesByOwnerEmail(email), HttpStatus.OK);
    }

    @DeleteMapping("/delete/public-memory/{userId}/{memoryId}")
    public ResponseEntity<String> deletePublicMemory(@PathVariable("memoryId") String memoryId, @PathVariable("userId") String userId) {
        logger.info("[PrivateMemory] DELETE Recuerdo Público");
        return this.publicMemoryService.deletePublicMemoryById(memoryId, userId);
    }

    @GetMapping("/get/public-memories/name-or-tagname/{nameOrTagName}")
    public ResponseEntity<List<PublicMemoryDto>> getAllMemoriesByNameOrTagname(@PathVariable("nameOrTagName") String nameOrTagName) {
        logger.info("[GeneralController] GET All memories by name or tagName");
        return new ResponseEntity(this.publicMemoryService.getAllPublicMemoriesByNameOrTagName(nameOrTagName), HttpStatus.OK);
    }
}