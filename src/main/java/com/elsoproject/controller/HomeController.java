package com.elsoproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elsoproject.domain.Story;
import com.elsoproject.repository.StoryRepository;
import com.elsoproject.service.StoryService;

@Controller
public class HomeController {

	private StoryService storyService;
	
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	@RequestMapping("/")
	public String stories(Model model) {
		model.addAttribute("pageTitle","Minden napra egy SFJ sztori");
		model.addAttribute("stories",storyService.getStories());
		return "stories";
	}
	
	@RequestMapping("/story")
	public String story(Model model) {
		model.addAttribute("pageTitle","Minden napra egy SFJ sztori");
		model.addAttribute("story",storyService.getStory());
		return "story";
	}
	
	@RequestMapping("/user/{id}")
	public String searchForUser(@PathVariable(value="id") String id) throws Exception {
		if (id == null)
			throw new Exception("Nincs ilyen id-val felhasználónk!");
		return "blogger";
	}
	@RequestMapping("/title/{title}")
	public String searchForTitle(@PathVariable(value="title") String title,Model model) throws Exception {
		if (title == null)
			throw new Exception("Nincs ilyen címmel sztorink!");
		model.addAttribute("story",storyService.getSpecificStory(title));
		return "story";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "exceptionHandler";
	}
	
//	private List<Story> getStories() {
//		List<Story> stories = storyRepo.findAll();
//		ArrayList<Story> stories = new ArrayList<>();
//		
//		Story story1 = new Story();
//		story1.setTitle("Első sztorim");
//		story1.setPosted(new Date());
//		story1.setAuthor("Bogyi");
//		story1.setContent("<p>Na ez már éles adat!</p>");
//
//		Story story2 = new Story();
//		story2.setTitle("Második sztorim");
//		story2.setPosted(new Date());
//		story2.setAuthor("Feri");
//		story2.setContent("<p>Feri nem érdekel</p>");
//
//		stories.add(story1);
//		stories.add(story2);
//		
//		return stories;
//	}
}
