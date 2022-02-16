package com.rekrutacja3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class InvoiceJpaRepository implements InvoiceRepository{

    List<Invoice> invoiceCollection = new ArrayList<Invoice>();

    @Override
    public Invoice find(String invoiceNumber) {
        return invoiceCollection.get(Integer.parseInt(invoiceNumber));
    }
}
