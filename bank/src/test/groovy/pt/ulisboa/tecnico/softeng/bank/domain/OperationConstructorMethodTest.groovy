package pt.ulisboa.tecnico.softeng.bank.domain

import org.slf4j.LoggerFactory
import spock.lang.Specification
import org.slf4j.Logger
import pt.ulisboa.tecnico.softeng.bank.domain.Operation.Type

class OperationConstructorMethodTest extends Specification {
    final Logger logger = LoggerFactory.getLogger(OperationConstructorMethodTest.class)

    Bank bank
    Account account


    def setup() {
        this.bank = new Bank("Money", "BK01")
        Client client = new Client(this.bank, "António")
        this.account = new Account(this.bank, client)
    }


    def "success"() {
        given:
            Operation operation = new Operation(Type.DEPOSIT, this.account, 1000)

        assert operation.getReference().startsWith(this.bank.getCode())
        assert operation.getReference().length() > Bank.CODE_SIZE
        assert operation.getType() == Type.DEPOSIT
        assert operation.getAccount() == this.account
        assert operation.getValue() == 1000
        assert operation.getTime() != null
        assert this.bank.getOperation(operation.getReference()) == operation
    }


    def cleanup() {
        Bank.banks.clear()
    }
}

