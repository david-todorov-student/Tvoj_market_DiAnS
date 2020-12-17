package mk.ukim.finki.dians.tvoj_market.web.controllers;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.OpeningHours;
import mk.ukim.finki.dians.tvoj_market.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/markets")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public String getMarketsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Market> markets = marketService.findAll();
        model.addAttribute("markets", markets);
        model.addAttribute("bodyContent", "markets");
//        return "markets";
        return "master-template";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteMarket(@PathVariable Long id) {
        this.marketService.deleteById(id);
        return "redirect:/markets";
    }

    @GetMapping("/edit-form/{id}")
    public String editMarketPage(@PathVariable Long id, Model model) {
        try {
            Market market = this.marketService.findById(id);
            model.addAttribute("market", market);
//            model.addAttribute("bodyContent", "add-market");
//            return "master-template";
            return "add-market";
        } catch (RuntimeException e) {
            return "redirect:/markets?error=" + e.getMessage();
        }
    }

    @GetMapping("/add-form")
    public String addMarketPage(Model model) {
        model.addAttribute("bodyContent", "add-market");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveMarket(@RequestParam Double latitude,
                             @RequestParam Double longitude,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String address,
                             @RequestParam(required = false) String opening,
                             @RequestParam(required = false) String closing,
                             @RequestParam(required = false) String website,
                             @RequestParam(required = false) String phoneNumber
    ) {
        if (opening != null && !opening.isEmpty() && closing != null && !closing.isEmpty()) {
            OpeningHours hours = new OpeningHours(LocalTime.parse(opening), LocalTime.parse(closing));
            this.marketService.save(longitude, latitude, name, address, hours, website, phoneNumber);
        } else
            this.marketService.save(longitude, latitude, name, address, null, website, phoneNumber);

        return "redirect:/markets";
    }

}
