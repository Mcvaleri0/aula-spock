package pt.ulisboa.tecnico.softeng.bank.domain

import spock.lang.Specification

class BankConstructorTest extends Specification {
    def setup() { }

    def "success"() {
        given:
            Bank bank = new Bank("Money", "BK01")

        assert bank.getName() == "Money"
        assert bank.getCode() == "BK01"
        assert Bank.banks.size() == 1
        assert bank.getNumberOfAccounts() == 0
        assert bank.getNumberOfClients() == 0
    }

    def cleanup() {
        Bank.banks.clear()
    }
}