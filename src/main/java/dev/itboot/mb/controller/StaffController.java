package dev.itboot.mb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.itboot.mb.model.Staff;
import dev.itboot.mb.service.StaffService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StaffController {
    // mapperをserviceに変更
    private final StaffService service;

    // mapperをserviceに変更
    @GetMapping("/")
    public String getAllStaffs(Model model) {
        model.addAttribute("page", service.selectAll());
        return "list";
    }

    // 以下を追加
    @GetMapping("/add")
    public String addStaff(@ModelAttribute Staff staff) {
        return "form";
    }

    @PostMapping("/process")
    public String process(@Validated @ModelAttribute Staff staff,
            BindingResult result) {

        if (result.hasErrors()) {
            return "form";
        }
        service.save(staff);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editStaff(@PathVariable Long id, Model model) {
        model.addAttribute("staff", service.selectByPrimaryKey(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id) {
        service.deleteByPrimaryKey(id);
        return "redirect:/";
    }
}
