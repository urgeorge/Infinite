package com.rekrutacja3;

public class Main {

    public static void main(String[] args) {
	InvoiceRepository repository = new InvoiceJpaRepository();
    InvoiceService service = new InvoiceService(repository);

    }
}
