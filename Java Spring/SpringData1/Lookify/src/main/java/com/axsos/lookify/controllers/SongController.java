package com.axsos.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.lookify.models.Song;
import com.axsos.lookify.services.SongService;

@Controller
public class SongController {
	 private final SongService songService;
	 
	 public SongController(SongService songService) {
		 this.songService = songService;
	 }
	    @RequestMapping("/{any}")
	    public String nothing(@PathVariable String any) {
	    	return "redirect:/dashboard";
	    }

	 @RequestMapping("/")
	 public String index() {
		 return "index.jsp";
	 }
	 @RequestMapping("/dashboard")
	 public String dashboard(Model model) {
	     List<Song> songs = songService.allSongs();
	     model.addAttribute("songs", songs);
	     return "dashboard.jsp";
	 }
	 
	 @RequestMapping("/songs/new")
	 public String viewNew(@ModelAttribute("song") Song song) {
	     return "new.jsp";
	 }
	 @RequestMapping(value="/songs/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
	     if (result.hasErrors()) {
	         return "new.jsp";
	     } else {
	         this.songService.createSong(song);
	         return "redirect:/dashboard";
	     }
	 }
	 @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	 public String destroy(@PathVariable("id") Long id) {
		 this.songService.deleteSongById(id);
		 return "redirect:/dashboard";
	 }

	 @RequestMapping("/songs/{id}")
	 public String show(@PathVariable Long id ,Model model) {
		 Song song=this.songService.getSongById(id);
		 if (song==null)
			 return "redirect:/dashboard";
	     model.addAttribute("song", song);
	     return "show.jsp";
	 }
	 
	 @RequestMapping(value="/search", method=RequestMethod.POST)
	 public String searchByForm(@RequestParam String artist) {
		 return "redirect:/search/"+artist;
	 }
	 @RequestMapping("/search/topTen")
	 public String search(Model model) {
		 List<Song> songs=this.songService.getTop10();
		 model.addAttribute("songs",songs);
		 return "top10.jsp";
	 }

	 @RequestMapping("/search/{artist}")
	 public String search(@PathVariable String artist,Model model) {
		 List<Song> songs=this.songService.filterArtist(artist);
		 model.addAttribute("songs",songs);
		 model.addAttribute("artist",artist);
		 return "search.jsp";
	 }



}
