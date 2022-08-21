package tech.ineb.adp.api.binance.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.ineb.adp.api.binance.service.RestApiService;
import tech.ineb.alpha.adp.binance.model.InlineResponse2002;

@AllArgsConstructor @Api(tags = {"quotes-controller"})
@Controller(value = "/api/v1/quotes")
public class QuotesController {
  private final RestApiService restApiService;

  @ApiOperation("Get all ticks")
  @GetMapping(value = "all")
  public ResponseEntity<InlineResponse2002> all(
      @ApiParam(value = "Security")
      @RequestParam(required = false) String security
  ) {
    InlineResponse2002 marketDepth = restApiService.getMarketDepth(security);
    return ResponseEntity.ok(marketDepth);
  }
}
