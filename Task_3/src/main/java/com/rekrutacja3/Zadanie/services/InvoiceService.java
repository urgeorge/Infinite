package com.rekrutacja3.Zadanie.services;

import com.rekrutacja3.Zadanie.models.Invoice;
import com.rekrutacja3.Zadanie.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public Invoice getInvoice(String invoiceNumber) {
        return repository.find(invoiceNumber);
    }

}
