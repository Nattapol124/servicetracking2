package com.web.taglib.convert;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class NumberArabicToThai extends TagSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();
		try {
			if (data != null && !data.equals("")) {

				char[][] numthai = { { '1', '\u0e51' }, { '2', '\u0e52' }, { '3', '\u0e53' }, { '4', '\u0e54' },
						{ '5', '\u0e55' }, { '6', '\u0e56' }, { '7', '\u0e57' }, { '8', '\u0e58' }, { '9', '\u0e59' },
						{ '0', '\u0e50' } };

				String result = "";
				for (int i = 0; i < data.length(); i++) {
					char check = data.charAt(i);
					for (int j = 0; j < numthai.length; j++) {
						if (check == numthai[j][0]) {
							check = numthai[j][1];
						}
					}
					result += check;
				}

				out.println(result);
			} else {
				out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		data = null;
	}

}
