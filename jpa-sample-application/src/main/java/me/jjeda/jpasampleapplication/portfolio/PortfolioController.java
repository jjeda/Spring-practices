package me.jjeda.jpasampleapplication.portfolio;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PortfolioController {

    PortfolioRepository portfolioRepository;

    @GetMapping("/portfolios")
    public List<Portfolio> list() {
       return portfolioRepository.findAll();
    }

    @GetMapping("/portfolio/{id}")
    public Optional<Portfolio> getPortfolio(@PathVariable Long id) {
        return portfolioRepository.findById(id);
    }

    @PostMapping("/portfolio")
    public ResponseEntity<?> postPortfolio(@RequestBody Portfolio portfolio) {
        portfolio.setCreatedDateNow();
        portfolioRepository.save(portfolio);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }
}
