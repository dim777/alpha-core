package tech.ineb.ats.alpha.market.quote;

import lombok.Data;
import tech.ineb.ats.alpha.market.security.Equity;

import java.util.UUID;

@Data
public class BQuote<S extends Equity> extends Quote<S> {
    private UUID id;
    private S security;

    private BQuote() {
    }

    public static <S extends Equity> BQuote<S> of() {
        return new BQuote<>();
    }

    @Override
    public UUID id() {
        return super.id();
    }

    @Override
    public Double open() {
        return super.open();
    }

    @Override
    public Double high() {
        return super.high();
    }

    @Override
    public Double low() {
        return super.low();
    }

    @Override
    public Double close() {
        return super.close();
    }

    @Override
    public S security() {
        return security;
    }

//    @Override
//    public LocalDateTime created() {
//        return null;
//    }
//
//    @Override
//    public LocalDateTime received() {
//        return null;
//    }
}
