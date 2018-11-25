package com.zeljko.mathematicians2.controller;

import com.zeljko.mathematicians2.domain.Mathematician;
import com.zeljko.mathematicians2.domain.MathematicianList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MathematicianController {

	@RequestMapping("/listAll")
	public String listAll(Model model){
    	RestTemplate restTemplate = new RestTemplate();
    	MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		List<Mathematician> mathematicians = response.getMathematicians();
		List<String> live = new ArrayList<>();
		live.add("700 BC");
		live.add("2000 AD");
		model.addAttribute("mathematicians", mathematicians);
		model.addAttribute("live", live);
		return "maths_list";
	}

	@RequestMapping("/list1")
	public String list1(Model model){
		RestTemplate restTemplate = new RestTemplate();
		MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		List<Mathematician> mathematicians = response.getMathematicians();
		List<Mathematician>  mathematicians1 = mathematicians.subList(0, 13);
		List<String> live = new ArrayList<>();
		live.add("700 BC");
		live.add("1400 AD");
		model.addAttribute("mathematicians", mathematicians1);
		model.addAttribute("live", live);
		return "maths_list";
	}

	@RequestMapping("/list2")
	public String list2(Model model){
		RestTemplate restTemplate = new RestTemplate();
		MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		List<Mathematician> mathematicians = response.getMathematicians();
		List<Mathematician>  mathematicians2 = mathematicians.subList(13, 21);
		List<String> live = new ArrayList<>();
		live.add("1400 AD");
		live.add("1700 AD");
		model.addAttribute("mathematicians", mathematicians2);
		model.addAttribute("live", live);
		return "maths_list";
	}

	@RequestMapping("/list3")
	public String list3(Model model){
		RestTemplate restTemplate = new RestTemplate();
		MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		List<Mathematician> mathematicians = response.getMathematicians();
		List<Mathematician>  mathematicians3 = mathematicians.subList(21, 29);
		List<String> live = new ArrayList<>();
		live.add("1700 AD");
		live.add("1850 AD");
		model.addAttribute("mathematicians", mathematicians3);
		model.addAttribute("live", live);
		return "maths_list";
	}

	@RequestMapping("/list4")
	public String list4(Model model){
		RestTemplate restTemplate = new RestTemplate();
		MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		List<Mathematician> mathematicians = response.getMathematicians();
		List<Mathematician>  mathematicians4 = mathematicians.subList(29, 37);
		List<String> live = new ArrayList<>();
		live.add("1850 AD");
		live.add("2000 AD");
		model.addAttribute("mathematicians", mathematicians4);
		model.addAttribute("live", live);
		return "maths_list";
	}

	@RequestMapping(value = "/mathematicianStory/{id}", method = RequestMethod.GET)
	public String mathematicianStory(@PathVariable("id") int mathematicianId, Model model){

		RestTemplate restTemplate = new RestTemplate();
		MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		List<Mathematician> mathematicians = response.getMathematicians();
		Mathematician mathematician = mathematicians.get(mathematicianId);
		model.addAttribute("math", mathematician);
		return "math_story";
	}

}
