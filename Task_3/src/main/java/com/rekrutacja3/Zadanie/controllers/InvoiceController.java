package com.rekrutacja3.Zadanie.controllers;

import com.rekrutacja3.Zadanie.models.Invoice;
import com.rekrutacja3.Zadanie.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @Autowired
    InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping(value = "/{id}")
    public Invoice getInvoiceById(@PathVariable String id){return invoiceService.getInvoice(id);}
}
