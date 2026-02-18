package org.springlearning.springlearning.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springlearning.springlearning.application.AccountCommandHandler;
import org.springlearning.springlearning.domain.CreateAccountCommand;


@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
  private final AccountCommandHandler accountCommandHandler;

  @PostMapping
  public ResponseEntity<String> createAccount(@RequestBody CreateAccountCommand createAccountCommand) {
      accountCommandHandler.handle(createAccountCommand);
      return ResponseEntity.ok().body("account created");
  }
}
