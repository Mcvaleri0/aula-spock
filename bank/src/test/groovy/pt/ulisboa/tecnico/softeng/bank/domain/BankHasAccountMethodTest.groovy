package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class BankHasAccountMethodTest extends Specification {
    Bank bank
    Client client

    def setup() {
        this.bank = new Bank("Money", "BK01")
        this.client = new Client(this.bank, "António")
    }

    def "success"() {
        given:
            Account account = new Account(this.bank, this.client)
            Account result = this.bank.getAccount(account.getIBAN())

        assert account == result
    }

    def cleanup() {
        Bank.banks.clear()
    }
}