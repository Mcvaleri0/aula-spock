package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class AccountWithdrawMethodTest extends Specification {
    Bank bank
    Account account

    def setup() {
        this.bank = new Bank("Money", "BK01")
        Client client = new Client(this.bank, "António")
        this.account = new Account(this.bank, client)

        this.account.deposit(100)
    }

    def "success"() {
        when:
            String reference = this.account.withdraw(40)

        then:
            assert this.account.getBalance() == 60
            Operation operation = this.bank.getOperation(reference)

            Operation.Type.WITHDRAW == operation.getType()
            this.account == operation.getAccount()
            operation.getValue() == 40
    }

    def cleanup() {
        Bank.banks.clear()
    }
}

