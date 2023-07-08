package com.vm.Vyas_Media.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MyErrorController {

        @GetMapping("/error")
        public String handleError() {

                //do something like logging
                return String.format("Something is wrong");
        }

        public String getErrorPath() {
                return String.format("/error");
            }
}