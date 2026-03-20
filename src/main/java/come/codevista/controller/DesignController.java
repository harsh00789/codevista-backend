package come.codevista.controller;

import come.codevista.design.urlshortner.model.DesignResponse;
import come.codevista.design.urlshortner.service.UrlShornerDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/design")
public class DesignController {
    private final UrlShornerDesignService urlShornerDesignService;

    @Autowired
    public DesignController(UrlShornerDesignService urlShornerDesignService) {
        this.urlShornerDesignService = urlShornerDesignService;
    }

    @GetMapping("/url-shortner")
    public DesignResponse getDesign() {
        return urlShornerDesignService.getDesign();
    }
}
