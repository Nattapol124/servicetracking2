package gtt.web.common;

public class OptionDTO {

	private String value;
	private String label;

	public OptionDTO() {
	}

	public OptionDTO(OptionDTO dto) {
		this.setValue(dto.getValue());
		this.setLabel(dto.getLabel());
	}

	public OptionDTO(String value, String label) {
		this.setValue(value);
		this.setLabel(label);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
