package com.zeljko.mathematicians2.controller;

import com.zeljko.mathematicians2.domain.Mathematician;
import com.zeljko.mathematicians2.domain.MathematicianList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MathematicianController {

	private String lived1;
	private String lived2;
	private int from;
	private int to;
	private List<Mathematician> mathematicians;

	@GetMapping("/list")
	public String list(Model model){
		RestTemplate restTemplate = new RestTemplate();
		MathematicianList response = restTemplate.getForObject("http://localhost:8080/data/maths.json", MathematicianList.class);
		assert response != null;
		mathematicians = response.getMathematicians();
		List<Mathematician>  mathematicians1 = mathematicians.subList(from, to);
		List<String> lived = new ArrayList<>();
		lived.add(lived1);
		lived.add(lived2);
		model.addAttribute("mathematicians", mathematicians1);
		model.addAttribute("lived", lived);
		return "math_list";
	}

	@GetMapping("/listAll")
	public String listAll(){
		lived1 = "700 BC";
		lived2 = "2000 AD";
		from = 0;
		to = 80;
		return "redirect:/list";
	}

	@GetMapping("/list1")
	public String list1(){
		lived1 = "700 BC";
		lived2 = "1400 AD";
		from = 0;
		to = 13;
		return "redirect:/list";
	}

	@GetMapping("/list2")
	public String list2(){
		lived1 = "1400 AD";
		lived2 = "1700 AD";
		from = 13;
		to = 35;
		return "redirect:/list";
	}

	@GetMapping("/list3")
	public String list3(){
		lived1 = "1700 AD";
		lived2 = "1850 AD";
		from = 35;
		to = 62;
		return "redirect:/list";
	}

	@GetMapping("/list4")
	public String list4(){
		lived1 = "1850 AD";
		lived2 = "2000 AD";
		from = 62;
		to = 80;
		return "redirect:/list";
	}

	@GetMapping("/mathematicianStory/{id}")
	public String mathematicianStory(@PathVariable("id") int mathematicianId, Model model){

		Mathematician mathematician = mathematicians.get(mathematicianId);
		model.addAttribute("math", mathematician);
		return "math_story";
	}

}
