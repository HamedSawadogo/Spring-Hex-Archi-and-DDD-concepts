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
    private Long id;
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
                command.getId(),
                command.getAmount(),
                command.getCreatedAt(),
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
                accountCredited.getId(),
                accountCredited.getAmount(),
                accountCredited.getCreatedAt(),
                accountCredited.getStatus()
        );
        events.add(event);
        apply(event);

    }

    public  void apply(Event event) {
        if (event instanceof AccountCreated accountCreated) {
            this.amount = accountCreated.getAmount();
            this.id = accountCreated.getId();
            this.createdAt = accountCreated.getCreatedAt();
            this.status = accountCreated.getStatus();
        } else if (event instanceof AccountCredited accountCredited) {
            this.amount = this.amount.add(accountCredited.getAmount());
        }
    }
}
