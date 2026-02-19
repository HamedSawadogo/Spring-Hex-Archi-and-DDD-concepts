package org.springlearning.springlearning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springlearning.springlearning.application.BusinessException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor
@AllArgsConstructor
public class BankAccountAggregate {
    private AccountId accountId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private String status;
    private List<Event> events = new ArrayList<>();

    public static BankAccountAggregate rebuildState(List<Event> eventSchemas) {
        BankAccountAggregate accountAggregate = new BankAccountAggregate();
        eventSchemas.forEach(accountAggregate::apply);
        return accountAggregate;
    }

    public static BankAccountAggregate create(CreateAccountCommand command) {
        BankAccountAggregate accountAggregate = new BankAccountAggregate();
        accountAggregate.createAccount(command);
        return accountAggregate;
    }

    public void createAccount(CreateAccountCommand command) {
        if (command.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("invalid amount");
        }
        var event = new AccountCreated(
                AccountId.create().id(),
                command.getAmount(),
                command.getStatus()
        );
        events.add(event);
        apply(event);
    }

    public void creditAccount(AccountCredited accountCredited) {
        if (accountCredited.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessException("invalid amount");
        }
        var event = new AccountCredited(
                accountCredited.getStatus(),
                accountCredited.getAmount(),
                accountCredited.getAggregateId()
        );
        events.add(event);
        apply(event);

    }

    public  void apply(Event event) {
        if (event instanceof AccountCreated accountCreated) {
            this.amount = accountCreated.getAmount();
            this.accountId = new AccountId(accountCreated.getAggregateId());
            this.createdAt = accountCreated.getOccurredAt();
            this.status = accountCreated.getStatus();
        } else if (event instanceof AccountCredited accountCredited) {
            this.amount = this.amount.add(accountCredited.getAmount());
        }
    }
}
