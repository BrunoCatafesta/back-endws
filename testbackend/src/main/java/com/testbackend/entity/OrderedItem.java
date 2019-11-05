package com.testbackend.entity;

import com.testbackend.architecture.Identifier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "ordered_item")
public class OrderedItem implements Identifier<Long> {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_ordered_item")
    @SequenceGenerator(name = "sq_ordered_item", allocationSize = 1, sequenceName="sq_ordered_item")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product")
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordered")
    private Ordered ordered;

    @NotNull
    @Positive
    private BigDecimal units;


    public OrderedItem(){

    }

    public OrderedItem(Product product){
        this.product = product;
    }

    public Ordered getOrdered() {
        return ordered;
    }

    public void setOrdered(Ordered ordered) {
        this.ordered = ordered;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public void setUnits(BigDecimal units) {
        this.units = units;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}