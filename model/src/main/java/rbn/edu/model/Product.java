package rbn.edu.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRO_PRODUCT")
@AttributeOverrides({ @AttributeOverride(name = AbstractEntity.PK, column = @Column(name = Product.PK)) })
public class Product extends AbstractEntity<Long> {

    private static final long serialVersionUID = -3721178740679096393L;
    public static final String PK = "PRO_ID";

    @Column(name = "PRO_NAME", nullable = false)
    private String name;

    @Column(name = "PRO_VALUE", nullable = false, precision = 10, scale = 2)
    private BigDecimal value;

    // @Enumerated(EnumType.ORDINAL)
    // @Column(name = "PRO_TYPE", nullable = false)
    // private ProductTypeEnum productType;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal value) {
	super();
	this.id = id;
	this.name = name;
	this.value = value;
	// this.productType = productType;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public BigDecimal getValue() {
	return value;
    }

    public void setValue(BigDecimal value) {
	this.value = value;
    }

    // public ProductTypeEnum getProductType() {
    // return productType;
    // }
    //
    // public void setProductType(ProductTypeEnum productType) {
    // this.productType = productType;
    // }

}
