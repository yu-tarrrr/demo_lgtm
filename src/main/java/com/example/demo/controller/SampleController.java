package com.example.demo.controller;

import com.example.demo.controller.resources.Lgtm;
import com.example.demo.infrastructure.LgtmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SampleController {
    private final LgtmRepository lgtmRepository;

    @GetMapping("lgtm")
    public String get(Model model) {
        List<Lgtm> imageList = lgtmRepository.findAll();
        model.addAttribute("imageList", imageList);
        return "top";
    }

    /**
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public String delete(Model model,@RequestParam(name = "q") Integer id) {
        try {
            lgtmRepository.deleteById(id);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage()); ex.getStackTrace();
        }
        return "redirect:/lgtm";
    }
}
