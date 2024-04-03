package app.controllers;

import app.dto.MarkerRequestTo;
import app.dto.MarkerResponseTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.services.MarkerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/markers")
public class MarkerController {
    @Autowired
    MarkerService markerService;

    @GetMapping
    public ResponseEntity<List<MarkerResponseTo>> getMarkers() {
        return ResponseEntity.status(200).body(markerService.getMarkers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarkerResponseTo> getMarker(@PathVariable Long id) {
        return ResponseEntity.status(200).body(markerService.getMarkerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarker(@PathVariable Long id) {
        markerService.deleteMarker(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<MarkerResponseTo> saveMarker(@RequestBody MarkerRequestTo marker) {
        MarkerResponseTo savedMarker = markerService.saveMarker(marker);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMarker);
    }

    @PutMapping()
    public ResponseEntity<MarkerResponseTo> updateMarker(@RequestBody MarkerRequestTo marker) {
        return ResponseEntity.status(HttpStatus.OK).body(markerService.updateMarker(marker));
    }

    @GetMapping("/byTweet/{id}")
    public ResponseEntity<MarkerResponseTo> getMarkerByTweetId(@PathVariable Long id){
        return ResponseEntity.status(200).body(markerService.getMarkerByTweetId(id));
    }
}