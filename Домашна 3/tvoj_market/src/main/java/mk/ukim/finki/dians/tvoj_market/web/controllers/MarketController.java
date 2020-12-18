package mk.ukim.finki.dians.tvoj_market.web.controllers;

import mk.ukim.finki.dians.tvoj_market.model.Market;
import mk.ukim.finki.dians.tvoj_market.model.exceptions.NoMarketsAreOpenException;
import mk.ukim.finki.dians.tvoj_market.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/opened")
    public String getOpenMarkets(Model model) {
        try {
            List<Market> opened = this.marketService.findOpened();
            if (opened.isEmpty())
                throw new NoMarketsAreOpenException();
            model.addAttribute("markets", opened);
            model.addAttribute("bodyContent", "markets");
            return "master-template";

        } catch (RuntimeException e) {
            return "redirect:/markets?error=" + e.getMessage();
        }
    }

    @GetMapping("/confirm-delete/{id}")
    public String getDeleteConfirmPage(@PathVariable Long id, Model model) {
        try {
            Market market = this.marketService.findById(id);
            model.addAttribute("market", market);
            model.addAttribute("bodyContent", "confirm-delete");
            return "master-template";
//            return "confirm-delete";
        } catch (RuntimeException e) {
            return "redirect:/markets?error=" + e.getMessage();
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteMarket(@PathVariable Long id) {
        this.marketService.deleteById(id);
        return "redirect:/markets";
    }

    @GetMapping("/edit-form/{id}")
    public String editMarketPage(@PathVariable Long id, Model model) {
        try {
            Market market = this.marketService.findById(id);
            model.addAttribute("market", market);
            model.addAttribute("bodyContent", "add-market");
            return "master-template";
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
            String hours = String.format("%s-%s", opening, closing);
            this.marketService.save(longitude, latitude, name, address, hours, website, phoneNumber);
        } else
            this.marketService.save(longitude, latitude, name, address, null, website, phoneNumber);

        return "redirect:/markets";
    }

    @GetMapping("/details-form/{id}")
    public String getDetailsPage(@PathVariable Long id, Model model) {
        try {
            Market market = this.marketService.findById(id);
            model.addAttribute("longitude", market.getLongitude());
            model.addAttribute("latitude", market.getLatitude());
            model.addAttribute("market", market);
            model.addAttribute("bodyContent", "details");
            return "master-template";
//            return "details";
        } catch (RuntimeException e) {
            return "redirect:/markets?error=" + e.getMessage();
        }
    }
}
