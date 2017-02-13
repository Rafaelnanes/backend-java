package rbn.edu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rbn.edu.config.ProjectConstants;
import rbn.edu.config.exceptions.BusinessException;
import rbn.edu.dao.IProductDAO;
import rbn.edu.enums.ProductTypeEnum;
import rbn.edu.model.FilterDTO;
import rbn.edu.model.Product;
import rbn.edu.model.ResponseServer;
import rbn.edu.service.IProductService;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Autowired
    private Environment env;

    @Override
    @Transactional
    public void add(Product t) throws BusinessException {
	if (productDAO.getByName(t.getName()) != null) {
	    throw new BusinessException(env.getProperty(ProjectConstants.PRODUCT_ALREADY_EXISTS));
	}
	productDAO.add(t);
    }

    @Override
    @Transactional
    public void update(Product t) throws BusinessException {
	Product managedProduct = productDAO.getByName(t.getName());
	if (managedProduct != null && !managedProduct.equals(t)
		&& managedProduct.getName().equalsIgnoreCase(t.getName())) {
	    throw new BusinessException(env.getProperty(ProjectConstants.PRODUCT_NAME_ALREADY_EXISTS));
	}
	managedProduct.setDate(t.getDate());
	managedProduct.setId(t.getId());
	managedProduct.setName(t.getName());
	managedProduct.setProductType(t.getProductType());
	managedProduct.setValue(t.getValue());
	productDAO.update(managedProduct);
    }

    @Override
    public List<Product> getAll() {
	return productDAO.getAll();
    }

    @Override
    public Product getById(long id) {
	return productDAO.getById(id);
    }

    @Override
    @Transactional
    public void remove(long id) {
	productDAO.remove(id);
    }

    @Override
    public List<ProductTypeEnum> getAllProductTypes() {
	List<ProductTypeEnum> list = new ArrayList<ProductTypeEnum>();
	for (ProductTypeEnum type : ProductTypeEnum.values()) {
	    list.add(type);
	}
	return list;
    }

    @Override
    public ResponseServer<Product> getAll(FilterDTO<Product> dto) {
	return productDAO.getAll(dto);
    }

}
