package com.rekrutacja3.Zadanie.repositories;

import com.rekrutacja3.Zadanie.models.Invoice;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;


public interface InvoiceRepository {

    List<Invoice> invoiceCollection = new ArrayList<Invoice>();

    @Cacheable(value = "invoiceCollection")
    Invoice find(String invoiceNumber);
}
