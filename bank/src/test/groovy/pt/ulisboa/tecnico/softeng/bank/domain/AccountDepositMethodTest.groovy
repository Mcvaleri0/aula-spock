package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class AccountDepositMethodTest extends Specification {
    Bank bank
    Account account

    def setup() {
        this.bank = new Bank("Money", "BK01")
        Client client = new Client(this.bank, "António")
        this.account = new Account(this.bank , client)
    }

    def "success"() {
        //when:
        given:
            String reference = this.account.deposit(50)

        assert this.account.getBalance() == 50
        Operation operation = this.bank.getOperation(reference)
        assert Operation.Type.DEPOSIT == operation.getType()
        assert this.account == operation.getAccount()
        assert 50 == operation.getValue()
    }

    def cleanup() {
        Bank.banks.clear()
    }
}