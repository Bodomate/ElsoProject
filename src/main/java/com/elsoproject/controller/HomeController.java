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

@Controller
public class HomeController {

	@Autowired
	StoryRepository storyRepo;
	
	@RequestMapping("/")
	public String stories(Model model, Locale locale) {
		model.addAttribute("pageTitle","Minden napra egy SFJ sztori");
		model.addAttribute("stories",getStories());
		System.out.println((String.format("Request received. Language: %s, Country: %s %n",locale.getLanguage(), locale.getDisplayCountry())));
		return "stories";
	}
	
	@RequestMapping("/user/{id}")
	public String searchForUser(@PathVariable(value="id") String id) throws Exception {
		if (id == null)
			throw new Exception("Nincs ilyen id-val felhasználónk!");
		return "user";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "exceptionHandler";
	}
	
	private List<Story> getStories() {
		List<Story> stories = storyRepo.findAll();
//		ArrayList<Story> stories = new ArrayList<>();
		
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
		
		return stories;
	}
}
