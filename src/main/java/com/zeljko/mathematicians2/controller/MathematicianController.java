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

	private String lived1;
	private String lived2;
	private int from;
	private int to;

	@RequestMapping("/list")
	public String list(Model model){
		RestTemplate restTemplate = new RestTemplate();
		MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		List<Mathematician> mathematicians = response.getMathematicians();
		List<Mathematician>  mathematicians1 = mathematicians.subList(from, to);
		List<String> lived = new ArrayList<>();
		lived.add(lived1);
		lived.add(lived2);
		model.addAttribute("mathematicians", mathematicians1);
		model.addAttribute("lived", lived);
		return "maths_list";
	}

	@RequestMapping("/listAll")
	public String listAll(){
		lived1 = "700 BC";
		lived2 = "2000 AD";
		from = 0;
		to = 37;
		return "redirect:/list";
	}

	@RequestMapping("/list1")
	public String list1(){
		lived1 = "700 BC";
		lived2 = "1400 AD";
		from = 0;
		to = 13;
		return "redirect:/list";
	}

	@RequestMapping("/list2")
	public String list2(){
		lived1 = "1400 BC";
		lived2 = "1700 AD";
		from = 13;
		to = 21;
		return "redirect:/list";
	}

	@RequestMapping("/list3")
	public String list3(){
		lived1 = "1700 BC";
		lived2 = "1850 AD";
		from = 21;
		to = 29;
		return "redirect:/list";
	}

	@RequestMapping("/list4")
	public String list4(){
		lived1 = "1850 BC";
		lived2 = "2000 AD";
		from = 29;
		to = 37;
		return "redirect:/list";
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
