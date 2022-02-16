package com.rekrutacja3.Zadanie.repositories;

import com.rekrutacja3.Zadanie.models.Invoice;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;


@Repository
public class InvoiceJpaRepository implements InvoiceRepository{

    /* only for testing */
    @PostConstruct
    public void fillCollection(){
        invoiceCollection.add(new Invoice("0",new Date()));
        invoiceCollection.add(new Invoice("1",new Date()));
        invoiceCollection.add(new Invoice("2",new Date()));
        invoiceCollection.add(new Invoice("3",new Date()));
        invoiceCollection.add(new Invoice("4",new Date()));
        invoiceCollection.add(new Invoice("5",new Date()));
        invoiceCollection.add(new Invoice("6",new Date()));
        invoiceCollection.add(new Invoice("7",new Date()));
        invoiceCollection.add(new Invoice("8",new Date()));
        invoiceCollection.add(new Invoice("9",new Date()));
        invoiceCollection.add(new Invoice("10",new Date()));
        invoiceCollection.add(new Invoice("11",new Date()));
        invoiceCollection.add(new Invoice("12",new Date()));
    }


    @Override
    public Invoice find(String invoiceNumber) {
        return invoiceCollection.get(Integer.parseInt(invoiceNumber));
    }
}