package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class AccountContructorMethodTest extends Specification {
    Bank bank
    Client client

    def setup() {
        this.bank = new Bank("Money", "BK01")
        this.client = new Client(this.bank, "António")
    }


    def "success"() {
        given:
            Account account = new Account(this.bank, this.client)

        assert account.getBank() == this.bank
        assert account.getIBAN().startsWith(this.bank.getCode())
        assert this.client == account.getClient()
        assert 0 == account.getBalance()
        assert 1 == this.bank.getNumberOfAccounts()
        assert this.bank.hasClient(this.client)
    }


    def cleanup() {
        Bank.banks.clear()
    }

}