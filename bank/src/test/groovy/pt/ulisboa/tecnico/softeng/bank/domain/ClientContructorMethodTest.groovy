package pt.ulisboa.tecnico.softeng.bank.domain;

import spock.lang.Specification

class ClientContructorMethodTest extends Specification {
    Bank bank

    def setup() {
        this.bank= new Bank("Money", "BK01")
    }

    def "success"() {
        given:
            Client client = new Client(this.bank, "António")

        assert client.getName() == "António"

        when:
            client.getID() >= 1

        then:
            this.bank.hasClient(client)
    }

    def cleanup() {
        Bank.banks.clear()
    }
}