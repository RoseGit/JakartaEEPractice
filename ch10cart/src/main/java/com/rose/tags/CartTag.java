package com.rose.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.rose.business.Cart;
import com.rose.business.LineItem;
import com.rose.business.Product;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

public class CartTag extends BodyTagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5286102331066680562L;
	private ArrayList<LineItem> lineItems;
    private Iterator iterator;
    private LineItem item;

    @Override
    public int doStartTag() {
        Cart cart = (Cart) pageContext.findAttribute("cart");
        lineItems = cart.getItems();
        if (lineItems.size() <= 0) {
            return SKIP_BODY;
        } else {
            return EVAL_BODY_BUFFERED;
        }
    }

    @Override
    public void doInitBody() throws JspException {
        iterator = lineItems.iterator();
        if (iterator.hasNext()) {
            item = (LineItem) iterator.next();
            this.setItemAttributes(item);
        }
    }

    private void setItemAttributes(LineItem item) {
        Product p = item.getProduct();
        pageContext.setAttribute(
                "productCode", p.getCode());
        pageContext.setAttribute(
                "productDescription", p.getDescription());
        pageContext.setAttribute(
                "productPrice", p.getPriceCurrencyFormat());
        pageContext.setAttribute(
                "quantity", new Integer(item.getQuantity()));
        pageContext.setAttribute(
                "total", item.getTotalCurrencyFormat());
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
            if (iterator.hasNext()) {
                item = (LineItem) iterator.next();
                this.setItemAttributes(item);
                return EVAL_BODY_AGAIN;
            } else {
                JspWriter out = bodyContent.getEnclosingWriter();
                bodyContent.writeOut(out);
                return SKIP_BODY;
            }
        } catch (IOException ioe) {
            System.err.println("error in doAfterBody " + ioe.getMessage());
            return SKIP_BODY;
        }
    }
}