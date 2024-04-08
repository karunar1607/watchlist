package com.openclassrooms.watchlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
public class WatchlistController {
	
	List<WatchlistItem> watchlistItems =new ArrayList<WatchlistItem>();
	Integer index=1;
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		
		String viewName="watchlist";
		Map <String,Object> model=new HashMap<String,Object>();
		model.put("numberOfMovies", watchlistItems.size());
		model.put("watchlistItems",watchlistItems);
		return new ModelAndView(viewName,model);
		
	}
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchlistItemForm(@RequestParam(required=false) Integer id) {
		String viewName="watchlistItemForm";
		Map<String,Object> model =new HashMap<String,Object>();
		WatchlistItem watchlistItem= findWatchlistItemById(id);
		
		if (watchlistItem==null)
		{
		model.put("watchlistItem", new WatchlistItem());
		
		}
		else {
			model.put("watchlistItem",watchlistItem );
		}
		return new ModelAndView(viewName,model);
		
	}
	private WatchlistItem findWatchlistItemById(Integer id) {
		
		for (WatchlistItem watchlistItem:watchlistItems) {
			
			if (watchlistItem.getId()==id) {
				return watchlistItem;
			}
			
		}
		return null;
	}

	@PostMapping("/watchlistItemForm")

	public ModelAndView submitwatchlistItemForm(@Valid WatchlistItem watchlistItem, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return new ModelAndView("watchlistItemForm");
        }
		WatchlistItem existingWatchlistItem =findWatchlistItemById(watchlistItem.getId());
		if (existingWatchlistItem==null) {
		watchlistItem.setId(index++);
		watchlistItems.add(watchlistItem);
		}else {
			existingWatchlistItem.setTitle(watchlistItem.getTitle());
			existingWatchlistItem.setRating(watchlistItem.getRating());
			existingWatchlistItem.setPriority(watchlistItem.getPriority());
			existingWatchlistItem.setComment(watchlistItem.getComment());
			
		}
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl("/watchlist");
		return new ModelAndView(redirectView);
		
			
	}

}
