package com.jbl.dao.impl;

import org.springframework.stereotype.Repository;

import com.jbl.dao.SupplierDAO;
import com.jbl.model.Tsupplier;

@Repository(value="supplierDAO")
public class SupplierDAOImpl extends BaseDAOImpl<Tsupplier> implements SupplierDAO {
}
