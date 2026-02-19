package org.springlearning.springlearning.application;
import org.springframework.stereotype.Component;
import org.springlearning.springlearning.domain.*;

@Component
public class AccountCommandHandler {
    private final EventStore eventStore;

    public AccountCommandHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public void handle(Commmnand commmnand) {
        var events = eventStore.loadEventsById(commmnand.aggregateId());
        if (commmnand instanceof  CreateAccountCommand createAccountCommand) {
            BankAccountAggregate accountAggregate = BankAccountAggregate.create(createAccountCommand);
            eventStore.storeEvents(accountAggregate.getEvents());
            accountAggregate.getEvents().clear();
        } else if(commmnand instanceof AccountCredited accountCredited) {
            BankAccountAggregate accountAggregate = BankAccountAggregate.rebuildState(events);
            accountAggregate.creditAccount(accountCredited);
            eventStore.storeEvents(accountAggregate.getEvents());
            accountAggregate.getEvents().clear();
        }
    }
}
