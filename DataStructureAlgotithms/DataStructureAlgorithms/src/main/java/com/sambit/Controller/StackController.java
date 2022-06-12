package com.sambit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StackController {

/*	1. Stack is a linear Data structure which follows the principle of Last in First out, That means the element that which will inserted last will be removes first.
	2. In a Programming structure putting of an element into a stack we use push method and for removing an element from the stack is called pop method.
	3. */

	private int[] array;
	private int size;


	@ResponseBody
	@GetMapping(value = "/stackCreation")
	public String stackCreation(){
		System.out.println("Hello Welcome Home.");

		return null;
	}
}
