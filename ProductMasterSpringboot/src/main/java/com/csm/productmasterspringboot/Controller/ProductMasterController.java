package com.csm.productmasterspringboot.Controller;

import com.csm.productmasterspringboot.Model.ProductMaster;
import com.csm.productmasterspringboot.Repository.ProductMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductMasterController {
    @Autowired
    private ProductMasterRepository productMasterRepository;

    @GetMapping(value = "ProductMaster")
    public String productMaster(Model model){
        List<ProductMaster> productMasterList = productMasterRepository.findAll();
        model.addAttribute("productMasterList", productMasterList);
        return "ProductMaster";
    }

    @PostMapping(value = "/saveProductMaster")
    public String saveProductMaster(@ModelAttribute("productMaster")ProductMaster productMaster, Model model){
//        ProductMaster productMaster = new ProductMaster();
//        productMaster.setpId(pId);
//        productMaster.setpName(pName);
//        productMaster.setpDesc(pDesc);
//        productMaster.setpPrice(pPrice);
        System.out.println(productMaster);
        productMasterRepository.save(productMaster);
        List<ProductMaster> productMasterList = productMasterRepository.findAll();
        System.out.println(productMasterList);
        model.addAttribute("productMasterList", productMasterList);
        return "ProductMaster";
    }

    @GetMapping("/delete/{pId}")
    public String deleteProduct(@PathVariable("pId")int pId, Model model){
        productMasterRepository.deleteById(pId);
        List<ProductMaster> productMasterList = productMasterRepository.findAll();
        model.addAttribute("productMasterList", productMasterList);
        return "ProductMaster";
    }
    @GetMapping("/edit/{pId}")
    public String editProduct(@PathVariable("pId")int pId, Model model){
        ProductMaster productMaster = productMasterRepository.getById(pId);
        List<ProductMaster> productMasterList = productMasterRepository.findAll();
        model.addAttribute("productMasterList", productMasterList);
        model.addAttribute("productMaster", productMaster);
        return "ProductMaster";
    }
}
