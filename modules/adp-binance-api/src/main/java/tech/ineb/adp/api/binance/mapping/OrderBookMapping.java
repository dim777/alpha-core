package tech.ineb.adp.api.binance.mapping;

import org.mapstruct.*;
import tech.ineb.adp.api.binance.model.OrderBookDTO;
import tech.ineb.alpha.adp.binance.model.InlineResponse2002;

@Mapper(componentModel = "spring",
    collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OrderBookMapping {
  @Mapping(source = "lastUpdateId", target = "id")
  OrderBookDTO toDTO(InlineResponse2002 response);
  /**
   * {
   * "lastUpdateId": 1027024,
   * "bids": [
   * [
   * "4.00000000",     // PRICE
   * "431.00000000"    // QTY
   * ]
   * ],
   * "asks": [
   * [
   * "4.00000200",
   * "12.00000000"
   * ]
   * ]
   * }
   *
   * @param response from binance
   * @return orderBook
   */
  @AfterMapping
  default void orders(InlineResponse2002 response, @MappingTarget OrderBookDTO orderBookDTO) {
    response.getAsks().forEach(b -> {
      double price = Double.parseDouble(b.get(0));
      double volume = Double.parseDouble(b.get(1));
      orderBookDTO.put(price, volume);
    });

    response.getBids().forEach(b -> {
      double price = Double.parseDouble(b.get(0));
      double volume = -1 * Double.parseDouble(b.get(1));
      orderBookDTO.put(price, volume);
    });
  }
}
