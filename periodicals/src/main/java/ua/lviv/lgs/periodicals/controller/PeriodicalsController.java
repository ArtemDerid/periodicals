package ua.lviv.lgs.periodicals.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.periodicals.service.PeriodicalsDTOHelper;
import ua.lviv.lgs.periodicals.service.PeriodicalsService;

@Controller
public class PeriodicalsController {

	@Autowired
	PeriodicalsService periodicalsService;

	@RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
	public ModelAndView createPeriodical(@RequestParam MultipartFile image, @RequestParam String name,
			@RequestParam String description, @RequestParam double price) throws IOException {
		periodicalsService.save(PeriodicalsDTOHelper.createEntity(image, name, description, price));
		return new ModelAndView("redirect:/home");
	}

}