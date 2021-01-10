package com.axsos.lookify.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.lookify.models.Song;
import com.axsos.lookify.repositories.SongRepository;

@Service

public class SongService {
	 private final SongRepository songRepository;
	 public SongService(SongRepository songRepository) {
		 this.songRepository=songRepository;
	}
	public List<Song>allSongs(){
		return this.songRepository.findAll();
	}
	public Song getSongById(Long id) {
		Optional<Song> song= this.songRepository.findById(id);
		if(song.isPresent())
			return song.get();
		return null;
	}
	public List<Song>filterArtist(String artist){
		return this.songRepository.findByArtist(artist);
	}
	public Song createSong(Song song) {
		return this.songRepository.save(song);
	}
	public void deleteSongById(Long id) {
		this.songRepository.deleteById(id);
	}
	public List<Song>getTop10(){
		List<Song> songs=this.songRepository.findAll();
		Collections.sort(songs, Comparator.comparing(Song -> Song.getRating()));
		Collections.reverse(songs);
		if (songs.size()<10)
			return songs;
		return songs.subList(0, 10);
	}
}
