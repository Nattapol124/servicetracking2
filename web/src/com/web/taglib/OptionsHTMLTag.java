package com.web.taglib;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.PropertyUtils;

@SuppressWarnings("rawtypes")
public class OptionsHTMLTag extends TagSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected List property = null;

	public List getProperty() {
		return property;
	}

	public void setProperty(List property) {
		this.property = property;
	}

	protected String value = null;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	protected String label = null;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		try {
			if (property != null) {
				Iterator collIterator = property.iterator();
				while (collIterator.hasNext()) {
					Object bean = collIterator.next();

					Object objValue = PropertyUtils.getProperty(bean, value);
					Object objLabel = PropertyUtils.getProperty(bean, label);

					out.println("<option value='" + objValue.toString() + "'>" + objLabel.toString() + "</option>");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		property = null;
		value = null;
		label = null;
	}

}
