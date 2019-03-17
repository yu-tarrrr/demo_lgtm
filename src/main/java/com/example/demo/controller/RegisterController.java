package com.example.demo.controller;

import com.example.demo.controller.resources.Lgtm;
import com.example.demo.controller.resources.RegisterForm;
import com.example.demo.infrastructure.LgtmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final LgtmRepository lgtmRepository;

    @GetMapping
    public String registerForm(RegisterForm registerForm, Model model) {
        model.addAttribute(registerForm);
        return "register";
    }

    @PostMapping(params = "register")
    public String post(Model model, RegisterForm registerForm) {

        // サービスに渡すリクエストの生成
        Lgtm lgtm = new Lgtm(
                null,
                registerForm.getImageUrl(),
                "[![LGTM](" + registerForm.getImageUrl()
                        + ")]" + "(" + registerForm.getImageUrl() + ")",
                Calendar.getInstance().getTime());

        // 実行
        try {
            lgtmRepository.save(lgtm);
        } catch (Exception ex) {
            model.addAttribute(ex);
        }
        return "redirect:/register";
    }
}
