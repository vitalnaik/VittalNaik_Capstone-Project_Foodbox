package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.global.GlobalData;
import com.project.model.Product;
import com.project.repository.UserRepository;
import com.project.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/addToCart/{id}")
    public String addTOCart(@PathVariable("id") int id) {
		GlobalData.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}
	
	@GetMapping("/cart")
	public String getString(Model model) {
		model.addAttribute("cart", GlobalData.cart);
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		
		return "cart";
	}	
	@GetMapping("/cart/removeItem/{index}")
	public String removeCartItem(@PathVariable int index) {
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}
	@GetMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}
	@PostMapping("/payment")
	public String payAndPlaceOrder(Model model) {
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cartCount", GlobalData.cart.size());
		//model.addAttribute("user",userRepository.findUserByEmail(email) );
		
		return "payment";
	}
	
	@GetMapping("/payment/success")
	public String orderSuccess() {
		//model.addAttribute("users",userRepository.findById(id) );
		return "success";
	}
	
	
	
	
	
	
	
}
