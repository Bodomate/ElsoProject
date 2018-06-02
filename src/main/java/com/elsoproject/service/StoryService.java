package com.elsoproject.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsoproject.domain.Blogger;
import com.elsoproject.domain.Story;
import com.elsoproject.repository.BloggerRepository;
import com.elsoproject.repository.StoryRepository;

@Service
public class StoryService {

	private StoryRepository storyRepo;
	private BloggerRepository bloggerRepo;
	
	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}
	
	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}

	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	@PostConstruct
	public void init(){
		Blogger blogger = new Blogger("Belső Gyula", 25);
		bloggerRepo.save(blogger);
		
		Story story = new Story("Belső cím","Belső tartalom", new Date(), blogger);
		storyRepo.save(story);
	}
}