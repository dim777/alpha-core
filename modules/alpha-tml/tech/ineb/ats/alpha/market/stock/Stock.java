package tech.ineb.ats.alpha.market.stock;

import lombok.Data;

public interface Stock {
    String name();

    Country country();

    @Data
    class Country {
        private Integer code;
        private String name;
    }
}
