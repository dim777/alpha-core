package tech.ineb.adp.api.tcs.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ineb.adp.api.tcs.service.MarketService;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@RestController
@RequestMapping(("api/v1/markets"))
@AllArgsConstructor
@Slf4j
public class MarketController {
  private final MarketService marketService;

  /**
   * Sync athlete followers
   *
   * @param athleteRequest athlete id
   * @return ResponseEntity
   */
//  @RequestMapping(value = "/sync/followers/{platformCode}", method = RequestMethod.POST, produces = "application/json")
//  public ResponseEntity<Void> syncFollowers(@PathVariable String platformCode, @RequestBody @NonNull CommonReq<AthleteReq> athleteRequest) {
//    final UUID correlationId = athleteRequest.getCorrelationId();
//    log.info("Sync followers with correlation ID = '{}'", correlationId);
//
//    final AthleteReq payload = athleteRequest.getPayload();
//    final AthleteDTO athleteDTO = athletesService.findById(payload.getAthleteId());
//    final IntegrationAdapter<?> adapter = registry.findByCode(platformCode);
//    final CompletableFuture<List<AthleteDTO>> future = adapter.syncFollowers(athleteDTO);
//    CompletableFuture.allOf(future).join();
//
//    return ResponseEntity.noContent().build();
//  }
}
