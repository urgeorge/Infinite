package com.rekrutacja3;

public class InvoiceService {

    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public Invoice getInvoice(String invoiceNumber) {
        return repository.find(invoiceNumber);
    }

}
