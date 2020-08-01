package com.jcho5078.cast;

import java.beans.PropertyEditorSupport;

public class BindingEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(new Binding(Integer.parseInt(text)));
	}
	
	@Override
	public String getAsText() {
		Binding binding = (Binding)getValue();
		return binding.getValue().toString();
	}
	
}
