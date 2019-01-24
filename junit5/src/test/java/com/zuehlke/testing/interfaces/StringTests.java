package com.zuehlke.testing.interfaces;

public class StringTests implements EqualsContract<String> {

    @Override
    public String createValue() {
        return "foo";
    }

    @Override
    public String createNotEqualValue() {
        return "baz";
    }

}
