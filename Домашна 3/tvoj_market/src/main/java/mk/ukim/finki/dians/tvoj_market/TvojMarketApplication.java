package mk.ukim.finki.dians.tvoj_market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class TvojMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvojMarketApplication.class, args);
    }

}
