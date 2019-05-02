package com.urise.webapp.model;

public class TextAbstractSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    private final String content;

    public TextAbstractSection(String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextAbstractSection that = (TextAbstractSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
